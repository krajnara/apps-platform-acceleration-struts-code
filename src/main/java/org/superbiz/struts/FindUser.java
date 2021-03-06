/*

 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package org.superbiz.struts;

import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

@Component
public class FindUser {

    private int id;
    private String errorMessage;
    private User user;

    private UserService service;

    public FindUser(UserService service) {
        this.service = service;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() {

        try {
            System.out.println("Finding user for ID: " + id);
            this.user = service.find(id);
            System.out.println("Found user with ID: " + user.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            this.errorMessage = e.getMessage();
            return "failure";
        }

        return "success";
    }
}
