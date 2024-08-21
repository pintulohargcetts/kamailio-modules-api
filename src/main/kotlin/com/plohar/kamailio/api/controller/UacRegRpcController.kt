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

import com.plohar.kamailio.api.service.UacRegRpcService
import com.plohar.kamailio.api.vo.`in`.uacreg.*
import com.plohar.kamailio.api.vo.out.ApiResponse
import com.plohar.kamailio.api.vo.out.JsonRpcResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import reactor.core.publisher.Mono

/**
 * Uac reg rpc controller
 *
 * @constructor Create empty Uac reg rpc controller
 * @property uacRegRpcService
 */
@RestController
@RequestMapping("/v1/uac/rpc")
class UacRegRpcController(
    private val uacRegRpcService: UacRegRpcService
) {

    @PostMapping("/refresh")
    fun refresh(@RequestBody uacRegRefreshRpcInVo: UacRegRpcRefreshInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        return uacRegRpcService.refresh(uacRegRefreshRpcInVo).map {
            ApiResponse(uacRegRefreshRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/info")
    fun info(@RequestBody uacRegRpcRegInfoInVo: UacRegRpcRegInfoInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        return uacRegRpcService.info(uacRegRpcRegInfoInVo).map {
            ApiResponse(uacRegRpcRegInfoInVo.transactionId, it)
        }
    }

    @PostMapping("/add")
    fun add(@RequestBody uacRegAddInVo: UacRegRpcAddInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        return uacRegRpcService.regAdd(uacRegAddInVo).map {
            ApiResponse(uacRegAddInVo.transactionId, it)
        }
    }

    @PutMapping("/remove")
    fun remove(@RequestBody uacRegRpcRemoveInVo: UacRegRpcRemoveInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        return uacRegRpcService.regRemove(uacRegRpcRemoveInVo).map {
            ApiResponse(uacRegRpcRemoveInVo.transactionId, it)
        }
    }

    @PutMapping("/unregister")
    fun unregister(@RequestBody uacRegRpcRegUnregisterInVo: UacRegRpcRegUnregisterInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        return uacRegRpcService.unregister(uacRegRpcRegUnregisterInVo).map {
            ApiResponse(uacRegRpcRegUnregisterInVo.transactionId, it)
        }
    }

    @PutMapping("/enable")
    fun enable(@RequestBody uacRegRpcRegEnableInVo: UacRegRpcRegEnableInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        return uacRegRpcService.enable(uacRegRpcRegEnableInVo).map {
            ApiResponse(uacRegRpcRegEnableInVo.transactionId, it)
        }
    }

    @PutMapping("/disable")
    fun disable(@RequestBody uacRegRpcRegDisableInVo: UacRegRpcRegDisableInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        return uacRegRpcService.disable(uacRegRpcRegDisableInVo).map {
            ApiResponse(uacRegRpcRegDisableInVo.transactionId, it)
        }
    }

}
