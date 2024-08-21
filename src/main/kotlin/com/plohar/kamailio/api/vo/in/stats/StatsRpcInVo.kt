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

package com.plohar.kamailio.api.vo.`in`.stats

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.plohar.kamailio.api.client.JsonRpcRequest
import com.plohar.kamailio.api.util.JsonRpcRequestFactory
import com.plohar.kamailio.api.vo.`in`.base.InRpcVoBase
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Request to get statistics")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class StatsRpcInVo(
    @JsonIgnore var statsType: StatsType? = StatsType.STATS_GET_STATISTICS,
    transactionId: String,
    serverUrl: String,
    id: String
) :
    InRpcVoBase(
        transactionId, serverUrl, id
    ) {
    override fun toJsonRpc(): JsonRpcRequest {
        return JsonRpcRequestFactory.factory()
            .createStatsRequest(this)
    }


    enum class StatsType {
        CORE_ALIASES_LIST,    // core.aliases_list
        CORE_ARG,             // core.arg
        CORE_ECHO,            // core.echo
        CORE_FLAGS,           // core.flags
        CORE_INFO,            // core.info
        CORE_RUNINFO,         // core.runinfo
        CORE_KILL,            // core.kill
        CORE_PRINTI,          // core.printi
        CORE_PRINTS,          // core.prints
        CORE_PS,              // core.ps
        CORE_PSX,             // core.psx
        CORE_PWD,             // core.pwd
        CORE_SHMMEM,          // core.shmmem
        CORE_SOCKETS_LIST,    // core.sockets_list
        CORE_TCP_INFO,        // core.tcp_info
        CORE_TCP_LIST,        // core.tcp_list
        CORE_TCP_OPTIONS,     // core.tcp_options
        CORE_UDP4_RAW_INFO,   // core.udp4_raw_info
        CORE_UPTIME,          // core.uptime
        CORE_VERSION,         // core.version
        CORE_PPDEFINES,       // core.ppdefines
        CORE_MODULES,         // core.modules
        PKG_STATS,            // pkg.stats
        PKG_INFO,             // pkg.info
        STATS_GET_STATISTICS, // stats.get_statistics
        STATS_FETCH,          // stats.fetch
        STATS_FETCHN,         // stats.fetchn
        STATS_RESET_STATISTICS, // stats.reset_statistics
        STATS_CLEAR_STATISTICS, // stats.clear_statistics
        SYSTEM_LIST_METHODS,  // system.listMethods
        SYSTEM_METHOD_HELP,   // system.methodHelp
        SYSTEM_METHOD_SIGNATURE, // system.methodSignature
        MOD_MEM_STATS,        // mod.mem_stats
        MOD_STATS,            // mod.stats
        MOD_MEM_STATSX        // mod.mem_statsx
    }
}