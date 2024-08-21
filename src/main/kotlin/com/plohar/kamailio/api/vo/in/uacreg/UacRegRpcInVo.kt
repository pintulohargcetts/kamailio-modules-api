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

package com.plohar.kamailio.api.vo.`in`.uacreg

import com.fasterxml.jackson.annotation.JsonProperty
import com.plohar.kamailio.api.client.JsonRpcRequest
import com.plohar.kamailio.api.vo.`in`.base.InRpcVo
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Size

@Deprecated("shifted to InRpcVoBase")
abstract class UacRegRpcInVo(
    @field:Schema(
        description = "Transaction Id for identifying the transaction.",
        example = "dfda12b7-ced4-11ec-9e16-0242ac1c0199",
        type = "UUID",
        maximum = "36"
    )
    @Size(max = 36)
    @field:JsonProperty("transactionId")
    @Transient
    override val transactionId: String,

    @field:Schema(
        description = "Server endpoint URL",
        example = "http://127.0.0.1:5060",
        required = true
    )
    @JsonProperty("serverEndpointUrl")
    override val serverUrl: String,

    @field:Schema(
        description = "json rpc id",
        example = "1",
        required = true
    )
    @field:JsonProperty("id")
    override val id: String,
) : InRpcVo<JsonRpcRequest>(transactionId = transactionId, serverUrl = serverUrl, id = id)
