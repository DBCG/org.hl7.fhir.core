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

public class V3CodingRationaleEnumFactory implements EnumFactory<V3CodingRationale> {

  public V3CodingRationale fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("O".equals(codeString))
      return V3CodingRationale.O;
    if ("OR".equals(codeString))
      return V3CodingRationale.OR;
    if ("P".equals(codeString))
      return V3CodingRationale.P;
    if ("PR".equals(codeString))
      return V3CodingRationale.PR;
    if ("R".equals(codeString))
      return V3CodingRationale.R;
    if ("HL7".equals(codeString))
      return V3CodingRationale.HL7;
    if ("SH".equals(codeString))
      return V3CodingRationale.SH;
    if ("SRC".equals(codeString))
      return V3CodingRationale.SRC;
    throw new IllegalArgumentException("Unknown V3CodingRationale code '"+codeString+"'");
  }

  public String toCode(V3CodingRationale code) {
    if (code == V3CodingRationale.O)
      return "O";
    if (code == V3CodingRationale.OR)
      return "OR";
    if (code == V3CodingRationale.P)
      return "P";
    if (code == V3CodingRationale.PR)
      return "PR";
    if (code == V3CodingRationale.R)
      return "R";
    if (code == V3CodingRationale.HL7)
      return "HL7";
    if (code == V3CodingRationale.SH)
      return "SH";
    if (code == V3CodingRationale.SRC)
      return "SRC";
    return "?";
  }

    public String toSystem(V3CodingRationale code) {
      return code.getSystem();
      }

}

