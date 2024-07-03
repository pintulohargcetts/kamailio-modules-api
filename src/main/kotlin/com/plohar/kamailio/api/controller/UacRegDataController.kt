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

package com.plohar.kamailio.api.controller


import com.plohar.kamailio.api.dto.UacRegDataDto
import com.plohar.kamailio.api.service.UacRegDataService
import com.plohar.kamailio.api.vo.`in`.uacreg.UacRegDataInVo
import com.plohar.kamailio.api.vo.out.ApiResponse
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

/**
 * Uac reg data controller
 *
 * @constructor Create empty Uac reg data controller
 * @property uacRegService
 */
@RestController
@RequestMapping("/v1/uac/data")
class UacRegDataController(private val uacRegService: UacRegDataService) {

    /*
    @GetMapping
    fun getAllUacRegs(): Flux<ApiResponse<UacRegDataDto>> {
        return uacRegService.findAllUacRegs().map {
            ApiResponse(UUID.randomUUID().toString(), it)
        }
    }*/

    @GetMapping("/{luuid}")
    fun getUacRegByLUuid(@PathVariable luuid: String): Mono<ApiResponse<UacRegDataDto>> {
        return uacRegService.getUacRegByLuId(luuid).map {
            ApiResponse(UUID.randomUUID().toString(), it)
        }
    }

    @PostMapping
    fun createUacReg(@RequestBody uacReg: UacRegDataInVo): Mono<ApiResponse<UacRegDataDto>> {
        return uacRegService.createUacReg(uacReg).map {
            ApiResponse(uacReg.transactionId, it)
        }
    }

    @PutMapping
    fun updateUacReg(
            @RequestBody uacRegInVo: UacRegDataInVo
    ): Mono<ApiResponse<UacRegDataDto>> {
        return uacRegService.updateUacReg(uacRegInVo.luuid, uacRegInVo).map {
            ApiResponse(uacRegInVo.transactionId, it)
        }
    }

    @DeleteMapping("/{luuid}")
    fun deleteUacReg(@PathVariable luuid: String): Mono<Void> = uacRegService.deleteUacRegByLUuId(luuid)
}
