/*
 * Copyright 1999-2011 Alibaba Group.
 *  
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
 */
package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.demo.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoAction {
    
    private DemoService demoService;

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

	public void start() throws Exception {
        for (int i = 0; i < 100; i++){
            new ThreadTest(demoService).start();
        }
	}

    static class ThreadTest extends Thread {

        DemoService demoService;

        ThreadTest(DemoService demoService) {
            this.demoService = demoService;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    String hello = demoService.sayHello(Thread.currentThread().getName() + "_world"); // call remote method
                    System.out.println(hello); // get result
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }
}