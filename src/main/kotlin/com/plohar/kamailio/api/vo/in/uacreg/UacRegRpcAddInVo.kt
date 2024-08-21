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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.plohar.kamailio.api.client.JsonRpcRequest
import com.plohar.kamailio.api.util.JsonRpcRequestFactory
import com.plohar.kamailio.api.vo.`in`.base.InRpcVoBase
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Size


@Schema(description = "Request to add uac reg record in memory thorugh rpc")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class UacRegRpcAddInVo(
    @field:Schema(
        description = "Transaction Id for identifying the transaction.",
        example = "dfda12b7-ced4-11ec-9e16-0242ac1c0199",
        required = true,
        maximum = "36"
    )
    @field:Size(max = 36)
    @field:JsonProperty("transactionId")
    @field:Transient
    override val transactionId: String,

    @field:Schema(
        description = "Server endpoint URL",
        example = "http://127.0.0.1:5060",
        required = true
    )
    override val serverUrl: String,

    @field:Schema(
        description = "json rpc id",
        example = "1",
        required = true
    )
    override val id: String,

    @field:Schema(
        description = "luuid",
        example = "1234567890",
        required = true
    )
    @field:Size(max = 64)
    @field:JsonProperty("luuid")
    val luuid: String,

    @field:Schema(
        description = "l_username",
        type = "String",
        maximum = "64",
        example = "1234567890"
    )
    @field:Size(max = 64)
    @field:JsonProperty("l_username")
    val luserName: String,

    @field:Schema(
        description = "l_domain",
        type = "String",
        maximum = "64",
        example = "172.27.0.35"
    )
    @field:Size(max = 64)
    @field:JsonProperty("l_domain")
    val ldomain: String,

    @field:Schema(
        description = "r_username",
        type = "String",
        maximum = "64",
        example = "1234567890"
    )
    @field:Size(max = 64)
    @field:JsonProperty("r_username")
    val ruserName: String,

    @field:Schema(
        description = "r_domain",
        type = "String",
        maximum = "64",
        example = "172.27.0.35"
    )
    @field:Size(max = 64)
    @field:JsonProperty("r_domain")
    val rdomain: String,

    @field:Schema(
        description = "realm",
        type = "String",
        maximum = "64",
        example = "org.kamailio"
    )
    @field:Size(max = 64)
    @field:JsonProperty("realm")
    val realm: String,

    @field:Schema(
        description = "auth_username",
        type = "String",
        maximum = "64",
        example = "1234567890"
    )
    @field:Size(max = 64)
    @field:JsonProperty("auth_username")
    val authUserName: String,

    @field:Schema(
        description = "auth_password",
        type = "String",
        maximum = "64",
        example = "a-valid-auth-token"
    )
    @field:Size(max = 64)
    @field:JsonProperty("auth_password")
    val authPassword: String,

    @field:Schema(
        description = "auth_ha1",
        type = "String",
        maximum = "128",
        example = "."
    )
    @field:Size(max = 128)
    @field:JsonProperty("auth_ha1")
    val authHa1: String = ".",

    @field:Schema(
        description = "auth_proxy",
        type = "String",
        maximum = "255",
        example = "sip:172.27.0.40:5070"
    )
    @field:Size(max = 255)
    @field:JsonProperty("auth_proxy")
    val authProxy: String,

    @field:Schema(
        description = "expires",
        type = "Int",
        example = "60"
    )
    @field:JsonProperty("expires")
    val expires: Int,

    @field:Schema(
        description = "flags",
        type = "Int",
        example = "1 or 0 Int value"
    )
    @field:JsonProperty("flags")
    val flags: Int,

    @field:Schema(
        description = "reg_delay",
        type = "Int",
        example = "30"
    )
    @field:JsonProperty("reg_delay")
    val regDelay: Int,

    @field:Schema(
        description = "contact_addr",
        type = "String",
        maximum = "255",
        example = "sip:172.27.0.35:5060"
    )
    @field:Size(max = 255)
    @field:JsonProperty("contact_addr")
    val contactAddr: String,

    @field:Schema(
        description = "contact_addr",
        type = "String",
        maximum = "128",
        example = "172.27.0.35:5060"
    )
    @field:Size(max = 128)
    @field:JsonProperty("socket")
    val socketToUse: String = "."

) : InRpcVoBase(transactionId = transactionId, serverUrl = serverUrl, id = id) {
    override fun toJsonRpc(): JsonRpcRequest {
        return JsonRpcRequestFactory.factory()
            .createUacRegAddRequest(this)
    }
}