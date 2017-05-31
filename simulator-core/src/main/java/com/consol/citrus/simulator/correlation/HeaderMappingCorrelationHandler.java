/*
 * Copyright 2006-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.consol.citrus.simulator.correlation;

import com.consol.citrus.message.Message;

/**
 * @author Christoph Deppisch
 */
public class HeaderMappingCorrelationHandler extends AbstractCorrelationHandler {

    /**
     * Message header to match on
     */
    private final String headerName;
    private final String value;

    /**
     * Constructor using header name property.
     *
     * @param headerName
     */
    public HeaderMappingCorrelationHandler(String headerName, String value) {
        this.headerName = headerName;
        this.value = value;
    }

    @Override
    public boolean isHandlerFor(Message message) {
        return message.getHeader(headerName) != null && message.getHeader(headerName).equals(context.replaceDynamicContentInString(value));
    }
}