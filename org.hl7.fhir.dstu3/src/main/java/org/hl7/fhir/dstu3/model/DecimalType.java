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
/**
 * 
 */
package org.hl7.fhir.dstu3.model;

/*-
 * #%L
 * org.hl7.fhir.dstu3
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


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.hl7.fhir.instance.model.api.IBaseDecimalDatatype;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * Primitive type "decimal" in FHIR: A rational number
 */
@DatatypeDef(name = "decimal")
public class DecimalType extends PrimitiveType<BigDecimal> implements Comparable<DecimalType>, IBaseDecimalDatatype {

	private static final long serialVersionUID = 3L;

	/**
	 * Constructor
	 */
	public DecimalType() {
		super();
	}

	/**
	 * Constructor
	 */
	public DecimalType(BigDecimal theValue) {
		setValue(theValue);
	}

	/**
	 * Constructor
	 */
	public DecimalType(double theValue) {
		// Use the valueOf here because the constructor gives wacky precision
		// changes due to the floating point conversion
		setValue(BigDecimal.valueOf(theValue));
	}

	/**
	 * Constructor
	 */
	public DecimalType(long theValue) {
		setValue(theValue);
	}

	/**
	 * Constructor
	 */
	public DecimalType(String theValue) {
		setValue(new BigDecimal(theValue));
	}

	@Override
	public int compareTo(DecimalType theObj) {
		if (getValue() == null && theObj.getValue() == null) {
			return 0;
		}
		if (getValue() != null && theObj.getValue() == null) {
			return 1;
		}
		if (getValue() == null && theObj.getValue() != null) {
			return -1;
		}
		return getValue().compareTo(theObj.getValue());
	}

	@Override
	protected String encode(BigDecimal theValue) {
		return getValue().toPlainString();
	}

	/**
	 * Gets the value as an integer, using {@link BigDecimal#intValue()}
	 */
	public int getValueAsInteger() {
		return getValue().intValue();
	}

	public Number getValueAsNumber() {
		return getValue();
	}

	@Override
	protected BigDecimal parse(String theValue) {
		return new BigDecimal(theValue);
	}

	/**
	 * Rounds the value to the given prevision
	 * 
	 * @see MathContext#getPrecision()
	 */
	public void round(int thePrecision) {
		if (getValue() != null) {
			BigDecimal newValue = getValue().round(new MathContext(thePrecision));
			setValue(newValue);
		}
	}

	/**
	 * Rounds the value to the given prevision
	 * 
	 * @see MathContext#getPrecision()
	 * @see MathContext#getRoundingMode()
	 */
	public void round(int thePrecision, RoundingMode theRoundingMode) {
		if (getValue() != null) {
			BigDecimal newValue = getValue().round(new MathContext(thePrecision, theRoundingMode));
			setValue(newValue);
		}
	}

	/**
	 * Sets a new value using an integer
	 */
	public void setValueAsInteger(int theValue) {
		setValue(BigDecimal.valueOf(theValue));
	}

	/**
	 * Sets a new value using a long
	 */
	public void setValue(long theValue) {
		setValue(BigDecimal.valueOf(theValue));
	}

	/**
	 * Sets a new value using a double
	 */
	public void setValue(double theValue) {
		setValue(BigDecimal.valueOf(theValue));
	}

	@Override
	public DecimalType copy() {
		return new DecimalType(getValue());
	}

	public String fhirType() {
		return "decimal";		
	}

}
