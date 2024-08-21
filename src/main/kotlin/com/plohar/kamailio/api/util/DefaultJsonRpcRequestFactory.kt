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
import com.plohar.kamailio.api.vo.`in`.stats.StatsRpcInVo
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

    override fun createStatsRequest(statsRpcInVo: StatsRpcInVo): JsonRpcRequest {
        /* val (method, params) = when (statsRpcInVo.statsType) {
             StatsRpcInVo.StatsType.CORE_ALIASES_LIST -> Pair(Method.CORE_ALIASES_LIST, listOf())
             else -> Pair(Method.STATS_GET_STATISTICS, listOf())
         }*/
        val (method, params) = when (statsRpcInVo.statsType) {
            StatsRpcInVo.StatsType.CORE_ALIASES_LIST -> Method.CORE_ALIASES_LIST to listOf("")
            StatsRpcInVo.StatsType.CORE_ARG -> Method.CORE_ECHO to listOf("")
            StatsRpcInVo.StatsType.CORE_ECHO -> Method.CORE_ECHO to listOf("")
            StatsRpcInVo.StatsType.CORE_FLAGS -> Method.CORE_FLAGS to listOf("")
            StatsRpcInVo.StatsType.CORE_INFO -> Method.CORE_INFO to listOf("")
            StatsRpcInVo.StatsType.CORE_RUNINFO -> Method.CORE_RUNINFO to listOf("")
            StatsRpcInVo.StatsType.CORE_KILL -> Method.CORE_KILL to listOf("")
            StatsRpcInVo.StatsType.CORE_PRINTI -> Method.CORE_PRINTI to listOf()
            StatsRpcInVo.StatsType.CORE_PRINTS -> Method.CORE_PRINTS to listOf()
            StatsRpcInVo.StatsType.CORE_PS -> Method.CORE_PS to listOf()
            StatsRpcInVo.StatsType.CORE_PSX -> Method.CORE_PSX to listOf()
            StatsRpcInVo.StatsType.CORE_PWD -> Method.CORE_PWD to listOf()
            StatsRpcInVo.StatsType.CORE_SHMMEM -> Method.CORE_SHMMEM to listOf()
            StatsRpcInVo.StatsType.CORE_SOCKETS_LIST -> Method.CORE_SOCKETS_LIST to listOf()
            StatsRpcInVo.StatsType.CORE_TCP_INFO -> Method.CORE_TCP_INFO to listOf()
            StatsRpcInVo.StatsType.CORE_TCP_LIST -> Method.CORE_TCP_LIST to listOf()
            StatsRpcInVo.StatsType.CORE_TCP_OPTIONS -> Method.CORE_TCP_OPTIONS to listOf()
            StatsRpcInVo.StatsType.CORE_UDP4_RAW_INFO -> Method.CORE_UDP4_RAW_INFO to listOf()
            StatsRpcInVo.StatsType.CORE_UPTIME -> Method.CORE_UPTIME to listOf()
            StatsRpcInVo.StatsType.CORE_VERSION -> Method.CORE_VERSION to listOf()
            StatsRpcInVo.StatsType.CORE_PPDEFINES -> Method.CORE_PPDEFINES to listOf()
            StatsRpcInVo.StatsType.CORE_MODULES -> Method.CORE_MODULES to listOf()
            StatsRpcInVo.StatsType.PKG_STATS -> Method.PKG_STATS to listOf()
            StatsRpcInVo.StatsType.PKG_INFO -> Method.PKG_INFO to listOf()
            StatsRpcInVo.StatsType.STATS_GET_STATISTICS -> Method.STATS_GET_STATISTICS to listOf("all")
            StatsRpcInVo.StatsType.STATS_FETCH -> Method.STATS_FETCH to listOf("all")
            StatsRpcInVo.StatsType.STATS_FETCHN -> Method.STATS_FETCHN to listOf("all")
            StatsRpcInVo.StatsType.STATS_RESET_STATISTICS -> Method.STATS_RESET_STATISTICS to listOf("all")
            StatsRpcInVo.StatsType.STATS_CLEAR_STATISTICS -> Method.STATS_CLEAR_STATISTICS to listOf("all")
            StatsRpcInVo.StatsType.SYSTEM_LIST_METHODS -> Method.SYSTEM_LIST_METHODS to listOf()
            StatsRpcInVo.StatsType.SYSTEM_METHOD_HELP -> Method.SYSTEM_METHOD_HELP to listOf()
            //StatsRpcInVo.StatsType.SYSTEM_METHOD_SIGNATURE -> Method.SYSTEM_METHOD_SIGNATURE to listOf()

            // it can be module based..
            StatsRpcInVo.StatsType.MOD_MEM_STATS -> Method.MOD_MEM_STATS to listOf("all", "all")
            StatsRpcInVo.StatsType.MOD_STATS -> Method.MOD_STATS to listOf("all", "all")
            StatsRpcInVo.StatsType.MOD_MEM_STATSX -> Method.MOD_MEM_STATSX to listOf("all", "all")

            else -> Method.STATS_GET_STATISTICS to listOf()
        }

        return JsonRpcRequest(
            method = method,
            serverEndPoint = statsRpcInVo.serverUrl,
            id = statsRpcInVo.id,
            params = params
        )
    }

}