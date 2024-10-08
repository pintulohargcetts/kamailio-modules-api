/*
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

package com.plohar.kamailio.api.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import jakarta.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.info.BuildProperties

/**
 * Base context
 *
 * @constructor Create empty Base context
 */
open class BaseContext {
    companion object {
        val objectMapper: ObjectMapper = ObjectMapper()
    }

    init {
        objectMapper
            .registerModule(JavaTimeModule())
            .registerModule(ParameterNamesModule())
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        objectMapper.dateFormat = StdDateFormat()
    }

    @Autowired
    protected lateinit var buildProperties: BuildProperties

    @Resource(name = "runtimeProfile")
    protected lateinit var runtimeProfile: ProfileType
}
