/*
 * Copyright 2005 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildFileTest;

public class EchoXMLTest extends BuildFileTest {

    public EchoXMLTest(String name) {
        super(name);
    }

    public void setUp() {
        configureProject("src/etc/testcases/taskdefs/echoxml.xml");
    }

    public void tearDown() {
        executeTarget("tearDown");
    }

    public void testPass() {
        executeTarget("testPass");
    }

    public void testFail() {
        expectBuildExceptionContaining("testFail", "must fail", "${foo}=bar");
    }

    public void testEmpty() {
        expectBuildExceptionContaining("testEmpty", "must fail", "No nested XML specified");
    }

}