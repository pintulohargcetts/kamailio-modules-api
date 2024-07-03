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
 * Json rpc request factory
 *
 * @constructor Create empty Json rpc request factory
 */
interface JsonRpcRequestFactory {
    fun createUacRefreshRegRequest(uacRegRefreshRpcInVo: UacRegRpcRefreshInVo): JsonRpcRequest
    fun createUacRegInfoRequest(uacRegRpcRegInfo: UacRegRpcRegInfoInVo): JsonRpcRequest
    fun createUacRegEnableRequest(uacRegRpcRegEnableInVo: UacRegRpcRegEnableInVo): JsonRpcRequest
    fun createUacRegDisableRequest(uacRegRpcRegDisableInVo: UacRegRpcRegDisableInVo): JsonRpcRequest
    fun createUacRegUnregRequest(uacRegRpcRegUnregisterInVo: UacRegRpcRegUnregisterInVo): JsonRpcRequest

    fun createUacRegAddRequest(uacRegAddInVo: UacRegRpcAddInVo): JsonRpcRequest
    fun createUacRegRemove(uacRegRemoveRpcInVo: UacRegRpcRemoveInVo): JsonRpcRequest

    companion object {
        fun factory(): JsonRpcRequestFactory = DefaultJsonRpcRequestFactory()
    }
}