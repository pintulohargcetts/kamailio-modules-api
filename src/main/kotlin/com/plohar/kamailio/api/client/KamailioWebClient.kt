package com.plohar.kamailio.api.client
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
import com.plohar.kamailio.api.core.BaseContext
import com.plohar.kamailio.api.core.KLog
import com.plohar.kamailio.api.core.LT
import com.plohar.kamailio.api.vo.out.JsonRpcResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import reactor.core.publisher.Mono

@Component
class KamailioWebClient(
    private val webClient: WebClient,
) : BaseContext() {
    fun jsonRpcRequest(jsonRpcRequest: JsonRpcRequest): Mono<ResponseEntity<JsonRpcResponse>> {
        return webClient.post()
            .uri(jsonRpcRequest.serverEndPoint + "/rpc")
            .header("Content-Type", "application/json")
            .bodyValue(convertToJson(jsonRpcRequest))
            .retrieve()
            .bodyToMono(JsonRpcResponse::class.java)
            .map {
                ResponseEntity.ok(it)
            }.onErrorResume(WebClientResponseException::class.java) {
                Mono.just(ResponseEntity.ok(it.getResponseBodyAs(JsonRpcResponse::class.java)))
            }
    }

    fun convertToJson(request: JsonRpcRequest): String {
        val value = objectMapper.writeValueAsString(request)
        KLog.i(LT.SYS, " rpc param : $value")
        return objectMapper.writeValueAsString(request)
    }
}