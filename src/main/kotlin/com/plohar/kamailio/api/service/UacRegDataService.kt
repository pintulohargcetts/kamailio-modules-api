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

package com.plohar.kamailio.api.service

import com.plohar.kamailio.api.dao.IUacRegDAO
import com.plohar.kamailio.api.dto.UacRegDataDto
import com.plohar.kamailio.api.entity.UacRegEntity
import com.plohar.kamailio.api.vo.`in`.uacreg.UacRegDataInVo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Uac reg data service
 *
 * @constructor Create empty Uac reg data service
 * @property uacRegDAO
 */
@Service
class UacRegDataService(
        private val uacRegDAO: IUacRegDAO
) {

    fun findAllUacRegs(): Flux<UacRegDataDto> = uacRegDAO.findAll().flatMap {
        Flux.just(convertEntityToDto(it))
    }

    fun getUacRegByLuId(lUuid: String): Mono<UacRegDataDto> = uacRegDAO.findByLUuid(lUuid).map {
        convertEntityToDto(it)
    }

    fun createUacReg(uacRegInVo: UacRegDataInVo): Mono<UacRegDataDto> {
        val uacRegDto = uacRegInVo.toDTO()
        return uacRegDAO.save(convertDtoToEntity(uacRegDto)).map {
            uacRegDto
        }
    }

    fun updateUacReg(lUuid: String, uacRegInVo: UacRegDataInVo): Mono<UacRegDataDto> {
        val uacRegDto = uacRegInVo.toDTO()

        return uacRegDAO.findByLUuid(lUuid)
                .flatMap { existingUacRegEntity ->
                    // Update the existing entity fields
                    val updatedUacReg = existingUacRegEntity.copy(
                            lDomain = uacRegDto.lDomain,
                            rDomain = uacRegDto.rDomain,
                            realm = uacRegDto.realm,
                            authUsername = uacRegDto.authUsername,
                            authPassword = uacRegDto.authPassword,
                            authHa1 = uacRegDto.authHa1,
                            authProxy = uacRegDto.authProxy,
                            expires = uacRegDto.expires,
                            flags = uacRegDto.flags,
                            regDelay = uacRegDto.regDelay,
                            contactAddr = uacRegDto.contactAddr,
                            socket = uacRegDto.socket
                    )
                    // Save the updated entity
                    uacRegDAO.save(updatedUacReg).map {
                        uacRegDto
                    }
                }

    }

    fun deleteUacRegByLUuId(lUuid: String): Mono<Void> = uacRegDAO.deleteByLUuid(lUuid)

    private fun convertEntityToDto(uacRegEntity: UacRegEntity): UacRegDataDto {
        return UacRegDataDto(
                lUuid = uacRegEntity.lUuid,
                lUsername = uacRegEntity.lUsername,
                lDomain = uacRegEntity.lDomain,
                rUsername = uacRegEntity.rUsername,
                rDomain = uacRegEntity.rDomain,
                realm = uacRegEntity.realm,
                authUsername = uacRegEntity.authUsername,
                authPassword = uacRegEntity.authPassword,
                authHa1 = uacRegEntity.authHa1,
                authProxy = uacRegEntity.authProxy,
                expires = uacRegEntity.expires,
                flags = uacRegEntity.flags,
                regDelay = uacRegEntity.regDelay,
                contactAddr = uacRegEntity.contactAddr,
                socket = uacRegEntity.socket
        )
    }


    private fun convertDtoToEntity(uacRegDto: UacRegDataDto): UacRegEntity {
        return UacRegEntity(
                lUuid = uacRegDto.lUuid,
                lUsername = uacRegDto.lUsername,
                lDomain = uacRegDto.lDomain,
                rUsername = uacRegDto.rUsername,
                rDomain = uacRegDto.rDomain,
                realm = uacRegDto.realm,
                authUsername = uacRegDto.authUsername,
                authPassword = uacRegDto.authPassword,
                authHa1 = uacRegDto.authHa1,
                authProxy = uacRegDto.authProxy,
                expires = uacRegDto.expires,
                flags = uacRegDto.flags,
                regDelay = uacRegDto.regDelay,
                contactAddr = uacRegDto.contactAddr,
                socket = uacRegDto.socket
        )
    }
}
