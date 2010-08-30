/*
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
package org.apache.commons.digester.annotations.employee;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.annotations.AbstractAnnotatedPojoTestCase;

/**
 * 
 * @version $Id$
 * @since 2.1
 */
public final class EmployeeTestCase extends AbstractAnnotatedPojoTestCase {

    public void testEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("First Name");
        employee.setLastName("Last Name");

        Address address = new Address();
        address.setCity("Home City");
        address.setState("HS");
        address.setStreet("Home Street");
        address.setType("home");
        address.setZipCode("HmZip");
        address.setEmployee(employee);

        address = new Address();
        address.setCity("Office City");
        address.setState("OS");
        address.setStreet("Office Street");
        address.setType("office");
        address.setZipCode("OfZip");
        address.setEmployee(employee);

        this.verifyExpectedEqualsToParsed(employee);
    }

    @Override
    protected void decorate(Digester digester) {
        this.getDigesterLoader().addRules(Address.class, digester);
    }

}