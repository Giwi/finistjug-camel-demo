/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.giwi.finistjug.camel.demo.exception;

/**
 * @author Giwi Softwares
 * 
 */
public class CustomException extends Exception {
    /**
	 * 
	 */
    private static final long serialVersionUID = -6283963189346619663L;

    public enum ErrorCodes {

	ILLEGAL_PARAMETERS("IllegalParameters"), INTERNAL_ERROR("InternalError");

	private String code;

	/**
	 * @param code
	 *            le code erreur
	 */
	ErrorCodes(final String code) {
	    setCode(code);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
	    return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(final String code) {
	    this.code = code;
	}
    }

    private String error;
    private String message;

    /**
     * @param error
     *            le code erreur
     * @param message
     *            le message d'erreur
     */
    public CustomException(final ErrorCodes error, final String message) {
	this.error = error.getCode();
	this.message = error.getCode() + " : " + message;
    }

    /**
     * @param error
     *            le code erreur
     * @param message
     *            le message d'erreur
     * @param e
     *            l'exception
     */
    public CustomException(final ErrorCodes error, final String message,
	    final Exception e) {
	super(e);
	this.error = error.getCode();
	this.message = error.getCode() + " : " + message;
    }

    /**
     * @return le code erreur
     */
    public String getError() {
	return error;
    }

    /**
     * @param error
     *            le code erreur
     */
    public void setError(final String error) {
	this.error = error;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
	return message;
    }

    /**
     * @param message
     *            le message d'erreur
     */
    public void setMessage(final String message) {
	this.message = message;
    }
}
