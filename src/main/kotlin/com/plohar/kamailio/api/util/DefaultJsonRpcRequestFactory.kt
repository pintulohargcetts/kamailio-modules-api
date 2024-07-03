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

package com.plohar.kamailio.api.util

import com.plohar.kamailio.api.client.JsonRpcRequest
import com.plohar.kamailio.api.vo.`in`.uacreg.*

/**
 * Default json rpc request factory
 *
 * @constructor Create empty Default json rpc request factory
 */
class DefaultJsonRpcRequestFactory : JsonRpcRequestFactory {
    override fun createUacRefreshRegRequest(uacRegRefreshRpcInVo: UacRegRpcRefreshInVo): JsonRpcRequest {
        return JsonRpcRequest(
                method = Method.UAC_REG_REFRESH,
                serverEndPoint = uacRegRefreshRpcInVo.serverUrl,
                id = uacRegRefreshRpcInVo.id,
                params = listOf("l_uuid", uacRegRefreshRpcInVo.luuid)
        )
    }

    override fun createUacRegInfoRequest(uacRegRpcRegInfo: UacRegRpcRegInfoInVo): JsonRpcRequest {
        return JsonRpcRequest(
                method = Method.UAC_REG_INFO,
                serverEndPoint = uacRegRpcRegInfo.serverUrl,
                id = uacRegRpcRegInfo.id,
                params = listOf("l_uuid", uacRegRpcRegInfo.luuid)
        )
    }

    override fun createUacRegEnableRequest(uacRegRpcRegEnableInVo: UacRegRpcRegEnableInVo): JsonRpcRequest {
        return JsonRpcRequest(
                method = Method.UAC_REG_ENABLE,
                serverEndPoint = uacRegRpcRegEnableInVo.serverUrl,
                id = uacRegRpcRegEnableInVo.id,
                params = listOf("l_uuid", uacRegRpcRegEnableInVo.luuid)
        )
    }

    override fun createUacRegDisableRequest(uacRegRpcRegDisableInVo: UacRegRpcRegDisableInVo): JsonRpcRequest {
        return JsonRpcRequest(
                method = Method.UAC_REG_DISABLE,
                serverEndPoint = uacRegRpcRegDisableInVo.serverUrl,
                id = uacRegRpcRegDisableInVo.id,
                params = listOf("l_uuid", uacRegRpcRegDisableInVo.luuid)
        )
    }

    override fun createUacRegUnregRequest(uacRegRpcRegUnregisterInVo: UacRegRpcRegUnregisterInVo): JsonRpcRequest {
        return JsonRpcRequest(
                method = Method.UAC_REG_UNREGISTER,
                serverEndPoint = uacRegRpcRegUnregisterInVo.serverUrl,
                id = uacRegRpcRegUnregisterInVo.id,
                params = listOf("l_uuid", uacRegRpcRegUnregisterInVo.luuid)
        )
    }

    override fun createUacRegAddRequest(uacRegAddInVo: UacRegRpcAddInVo): JsonRpcRequest {
        return JsonRpcRequest(
                method = Method.UAC_REG_ADD,
                serverEndPoint = uacRegAddInVo.serverUrl,
                id = uacRegAddInVo.id,
                // order to be strictly maintained..
                params = listOf(
                        uacRegAddInVo.luuid,
                        uacRegAddInVo.luserName,
                        uacRegAddInVo.ldomain,
                        uacRegAddInVo.ruserName,
                        uacRegAddInVo.rdomain,
                        uacRegAddInVo.realm,
                        uacRegAddInVo.authUserName,
                        uacRegAddInVo.authPassword,
                        uacRegAddInVo.authHa1,
                        uacRegAddInVo.authProxy,
                        uacRegAddInVo.expires,
                        uacRegAddInVo.flags,
                        uacRegAddInVo.regDelay,
                        uacRegAddInVo.contactAddr,
                        uacRegAddInVo.socketToUse
                )
        )
    }

    override fun createUacRegRemove(uacRegRemoveRpcInVo: UacRegRpcRemoveInVo): JsonRpcRequest {
        return JsonRpcRequest(
                method = Method.UAC_REG_REMOVE,
                serverEndPoint = uacRegRemoveRpcInVo.serverUrl,
                id = uacRegRemoveRpcInVo.id,
                params = listOf(uacRegRemoveRpcInVo.luuid)
        )
    }
}