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
package org.apache.camel.component.hibernate;

import org.hibernate.Session;

/**
 * A strategy for deleting entity beans which have been processed; either by a real delete or by an update of some
 * application specific properties so that the entity bean will not be found in future polling queries.
 *
 * @version $Revision: 630591 $
 */
public interface DeleteHandler<T> {

    /**
     * Deletes the entity bean after it has been processed either by actually
     * deleting the object or updating it in a way so that future queries do not return this object again.
     *
     * @param session       the session
     * @param entityBean    the entity bean that has been processed and should be deleted
     */
    void deleteObject(Session session, Object entityBean);
}
