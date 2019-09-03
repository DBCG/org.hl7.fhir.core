package org.hl7.fhir.r4.model.codesystems;

/*-
 * #%L
 * org.hl7.fhir.r4
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
  Copyright (c) 2011+, HL7, Inc.
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

// Generated on Wed, Jan 30, 2019 16:19-0500 for FHIR v4.0.0


import org.hl7.fhir.r4.model.EnumFactory;

public class V3RelationalOperatorEnumFactory implements EnumFactory<V3RelationalOperator> {

  public V3RelationalOperator fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("CT".equals(codeString))
      return V3RelationalOperator.CT;
    if ("EQ".equals(codeString))
      return V3RelationalOperator.EQ;
    if ("GE".equals(codeString))
      return V3RelationalOperator.GE;
    if ("GN".equals(codeString))
      return V3RelationalOperator.GN;
    if ("GT".equals(codeString))
      return V3RelationalOperator.GT;
    if ("LE".equals(codeString))
      return V3RelationalOperator.LE;
    if ("LT".equals(codeString))
      return V3RelationalOperator.LT;
    if ("NE".equals(codeString))
      return V3RelationalOperator.NE;
    throw new IllegalArgumentException("Unknown V3RelationalOperator code '"+codeString+"'");
  }

  public String toCode(V3RelationalOperator code) {
    if (code == V3RelationalOperator.CT)
      return "CT";
    if (code == V3RelationalOperator.EQ)
      return "EQ";
    if (code == V3RelationalOperator.GE)
      return "GE";
    if (code == V3RelationalOperator.GN)
      return "GN";
    if (code == V3RelationalOperator.GT)
      return "GT";
    if (code == V3RelationalOperator.LE)
      return "LE";
    if (code == V3RelationalOperator.LT)
      return "LT";
    if (code == V3RelationalOperator.NE)
      return "NE";
    return "?";
  }

    public String toSystem(V3RelationalOperator code) {
      return code.getSystem();
      }

}

