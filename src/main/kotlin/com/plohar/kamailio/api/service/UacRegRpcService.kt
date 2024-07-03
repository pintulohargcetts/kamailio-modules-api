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

import com.plohar.kamailio.api.client.KamailioWebClient
import com.plohar.kamailio.api.vo.`in`.uacreg.*
import com.plohar.kamailio.api.vo.out.JsonRpcResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * Uac reg rpc service
 *
 * @constructor Create empty Uac reg rpc service
 * @property kamailioWebClient
 */
@Service
class UacRegRpcService(
        private val kamailioWebClient: KamailioWebClient
) {
    fun info(uacRegRpcRegInfoInVo: UacRegRpcRegInfoInVo): Mono<ResponseEntity<JsonRpcResponse>> {
        return kamailioWebClient.jsonRpcRequest(uacRegRpcRegInfoInVo.toJsonRpc())
    }

    fun refresh(uacRegRefreshRpcInVo: UacRegRpcRefreshInVo): Mono<ResponseEntity<JsonRpcResponse>> {
        return kamailioWebClient.jsonRpcRequest(uacRegRefreshRpcInVo.toJsonRpc())
    }

    fun regAdd(uacRegRpcAddInVo: UacRegRpcAddInVo): Mono<ResponseEntity<JsonRpcResponse>> {
        return kamailioWebClient.jsonRpcRequest(uacRegRpcAddInVo.toJsonRpc())
    }

    fun regRemove(uacRegRpcRemoveInVo: UacRegRpcRemoveInVo): Mono<ResponseEntity<JsonRpcResponse>> {
        return kamailioWebClient.jsonRpcRequest(uacRegRpcRemoveInVo.toJsonRpc())
    }

    fun unregister(uacRegRpcRegUnregisterInVo: UacRegRpcRegUnregisterInVo): Mono<ResponseEntity<JsonRpcResponse>> {
        return kamailioWebClient.jsonRpcRequest(uacRegRpcRegUnregisterInVo.toJsonRpc())
    }

    fun enable(uacRegRpcRegEnableInVo: UacRegRpcRegEnableInVo): Mono<ResponseEntity<JsonRpcResponse>> {
        return kamailioWebClient.jsonRpcRequest(uacRegRpcRegEnableInVo.toJsonRpc())
    }

    fun disable(uacRegRpcRegDisableInVo: UacRegRpcRegDisableInVo): Mono<ResponseEntity<JsonRpcResponse>> {
        return kamailioWebClient.jsonRpcRequest(uacRegRpcRegDisableInVo.toJsonRpc())
    }

    fun regActive(): Mono<ResponseEntity<JsonRpcResponse>> {
        TODO()
    }


}
