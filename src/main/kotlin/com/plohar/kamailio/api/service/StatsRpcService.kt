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
import com.plohar.kamailio.api.vo.`in`.stats.StatsRpcInVo
import com.plohar.kamailio.api.vo.out.JsonRpcResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class StatsRpcService(
    private val kamailioWebClient: KamailioWebClient
) {
    fun getStatisticsByStatsType(statsRpcInVo: StatsRpcInVo): Mono<ResponseEntity<JsonRpcResponse>> {
        return kamailioWebClient.jsonRpcRequest(statsRpcInVo.toJsonRpc())
    }
}
