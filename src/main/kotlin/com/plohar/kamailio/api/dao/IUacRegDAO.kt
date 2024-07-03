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

package com.plohar.kamailio.api.dao

import com.plohar.kamailio.api.entity.UacRegEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * IUacRegDAO
 *
 * @constructor Create empty I uac reg d a o
 */
interface IUacRegDAO {
    fun findByLUuid(lUuid: String): Mono<UacRegEntity>
    fun deleteByLUuid(lUuid: String): Mono<Void>
    fun save(uacRegEntity: UacRegEntity): Mono<UacRegEntity>
    fun findAll(): Flux<UacRegEntity>
}