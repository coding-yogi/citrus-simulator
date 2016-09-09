/*
 * Copyright 2006-2014 the original author or authors.
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

package com.consol.citrus.simulator.scenario;

import com.consol.citrus.simulator.AbstractSimulatorScenario;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Christoph Deppisch
 */
@Component("GoodNight")
@Scope("prototype")
public class GoodNightScenario extends AbstractSimulatorScenario {

    @Override
    protected void configure() {
        receiveSOAPRequest()
            .payload("<GoodNight xmlns=\"http://citrusframework.org/schemas/hello\">" +
                        "Go to sleep!" +
                     "</GoodNight>")
            .header("citrus_soap_action", "GoodNight");

        sendSoapFault()
            .faultCode("{http://citrusframework.org}CITRUS:SIM-1001")
            .faultString("No sleep for me!");
    }
}