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

import com.plohar.kamailio.api.dao.respository.UacRegRepository
import com.plohar.kamailio.api.entity.UacRegEntity
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Uac reg dao
 *
 * @constructor Create empty Uac reg dao
 * @property uacRegRespository
 */
@Component
class UacRegDao(
    private val uacRegRespository: UacRegRepository
) : IUacRegDAO {

    override fun findByLUuid(lUuid: String): Mono<UacRegEntity> {
        return uacRegRespository.findBylUuid(lUuid);
    }

    override fun deleteByLUuid(lUuid: String): Mono<Void> {
        return uacRegRespository.deleteBylUuid(lUuid)
    }

    override fun save(uacRegEntity: UacRegEntity): Mono<UacRegEntity> {
        return uacRegRespository.save(uacRegEntity)
    }

    override fun findAll(): Flux<UacRegEntity> {
        return uacRegRespository.findAll()
    }


}