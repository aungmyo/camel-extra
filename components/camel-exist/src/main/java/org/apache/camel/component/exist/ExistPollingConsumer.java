/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.exist;

import org.apache.camel.Exchange;
import org.apache.camel.impl.PollingConsumerSupport;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;

/**
 * @version $Revision: 1.1 $
 */
public class ExistPollingConsumer extends PollingConsumerSupport {
    private ExistEndpoint endpoint;
    private ResourceIterator iterator;

    public ExistPollingConsumer(ExistEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public Exchange receive() {
        try {
            if (iterator == null) {
                iterator = endpoint.createResourceIterator();
            }
            if (iterator.hasMoreResources()) {
                Resource resource = iterator.nextResource();
                return endpoint.createExchange(resource);
            } else {
                iterator = null;
                return null;
            }
        }
        catch (XMLDBException e) {
            throw new RuntimeExistException(endpoint, e);
        }
    }

    public Exchange receiveNoWait() {
        return receive();
    }

    public Exchange receive(long l) {
        return receive();
    }

    protected void doStart() throws Exception {
    }

    protected void doStop() throws Exception {
    }
}
