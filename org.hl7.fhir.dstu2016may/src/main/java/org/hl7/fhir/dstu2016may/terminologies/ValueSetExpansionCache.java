package org.hl7.fhir.dstu2016may.terminologies;

/*-
 * #%L
 * org.hl7.fhir.dstu2016may
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


/*
Copyright (c) 2011+, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2016may.model.OperationOutcome;
import org.hl7.fhir.dstu2016may.model.Resource;
import org.hl7.fhir.dstu2016may.model.ValueSet;
import org.hl7.fhir.dstu2016may.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.dstu2016may.utils.IWorkerContext;
import org.hl7.fhir.dstu2016may.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;

public class ValueSetExpansionCache implements ValueSetExpanderFactory {

  public class CacheAwareExpander implements ValueSetExpander {

	  @Override
	  public ValueSetExpansionOutcome expand(ValueSet source) throws ETooCostly, IOException {
	  	if (expansions.containsKey(source.getUrl()))
	  		return expansions.get(source.getUrl());
	  	ValueSetExpander vse = new ValueSetExpanderSimple(context, ValueSetExpansionCache.this);
	  	ValueSetExpansionOutcome vso = vse.expand(source);
	  	if (vso.getError() != null) {
	  	  // well, we'll see if the designated server can expand it, and if it can, we'll cache it locally
	  		vso = context.expandVS(source, false);
	  		FileOutputStream s = new FileOutputStream(Utilities.path(cacheFolder, makeFile(source.getUrl())));
	  		context.newXmlParser().setOutputStyle(OutputStyle.PRETTY).compose(s, vso.getValueset());
	  		s.close();
	  	}
	  	expansions.put(source.getUrl(), vso);
	  	return vso;
	  }

    private String makeFile(String url) {
      return url.replace("$", "").replace(":", "").replace("//", "/").replace("/", "_")+".xml";
    }
  }

  private static final String VS_ID_EXT = "http://tools/cache";

  private final Map<String, ValueSetExpansionOutcome> expansions = new HashMap<String, ValueSetExpansionOutcome>();
  private final IWorkerContext context;
  private final String cacheFolder;
	
	public ValueSetExpansionCache(IWorkerContext context) {
    super();
    cacheFolder = null;
    this.context = context;
  }
  
	public ValueSetExpansionCache(IWorkerContext context, String cacheFolder) throws FHIRFormatError, IOException {
    super();
    this.context = context;
    this.cacheFolder = cacheFolder;
    if (this.cacheFolder != null)
      loadCache();
  }
  
	private void loadCache() throws FHIRFormatError, IOException {
	  File[] files = new File(cacheFolder).listFiles();
    for (File f : files) {
      if (f.getName().endsWith(".xml")) {
        final FileInputStream is = new FileInputStream(f);
        try {	   
        Resource r = context.newXmlParser().setOutputStyle(OutputStyle.PRETTY).parse(is);
        if (r instanceof OperationOutcome) {
          OperationOutcome oo = (OperationOutcome) r;
          expansions.put(ToolingExtensions.getExtension(oo,VS_ID_EXT).getValue().toString(),
            new ValueSetExpansionOutcome(new XhtmlComposer(true, false).composePlainText(oo.getText().getDiv())));
        } else {
          ValueSet vs = (ValueSet) r; 
          expansions.put(vs.getUrl(), new ValueSetExpansionOutcome(vs, null));
        }
        } finally {
          IOUtils.closeQuietly(is);
        }
      }
    }
  }

  @Override
	public ValueSetExpander getExpander() {
		return new CacheAwareExpander();
		// return new ValueSetExpander(valuesets, codesystems);
	}

}
