/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.examples;

import org.apache.camel.component.hibernate.Consumed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a task which has multiple steps so that it can move from stage to stage
 * with the method annotated with {@link @Consumed} being invoked when the Camel consumer
 * has processed the entity bean
 *
 * @version $Revision: 630591 $
 */
//@NamedQuery(name = "step1", query = "select x from MultiSteps x where x.step = 1")
public class MultiSteps {
    private static final transient Logger LOG = LoggerFactory.getLogger(MultiSteps.class);
    private Long id;
    private String address;
    private int step;

    public MultiSteps() {
    }

    public MultiSteps(String address) {
        setAddress(address);
        setStep(1);
    }

    @Override
    public String toString() {
        return "MultiSteps[id: " + getId() + " step: " + getStep() + " address: " + getAddress() + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    /**
     * This method is invoked after the entity bean is processed successfully by a Camel endpoint
     */
    @Consumed
    public void goToNextStep() {
        setStep(getStep() + 1);

        LOG.info("Invoked the completion complete method. Now updated the step to: " + getStep());
    }
}
