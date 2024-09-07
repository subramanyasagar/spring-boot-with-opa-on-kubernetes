/*
 * Copyright (c) 2021 VMware, Inc. or its affiliates
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

package com.springboot.opa.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v1")
@Api(tags = {"AdminController"})
@RequiredArgsConstructor
@Slf4j
class AdminController {


    @GetMapping(value = "/admin/users/{userName}", produces = MediaType.TEXT_PLAIN_VALUE)
    String getUsers(@PathVariable String userName) {
       // Just return a simple String.
            return "Hello!! "+ userName+ " You have reached the Get Users";
    }

    @PostMapping(value = "/admin/users/{userName}", produces = MediaType.TEXT_PLAIN_VALUE)
    String updateUsers(@PathVariable String userName) {
        // Just return a simple String.
        return "Hello!! "+ userName+ " You have access to edits";
    }

}