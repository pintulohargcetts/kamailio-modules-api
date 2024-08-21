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

/**
 * Method
 *
 * @constructor Create empty Method
 */
class Method {

    companion object {
        // uac
        val UAC_REG_INFO = "uac.reg_info"
        val UAC_REG_ENABLE = "uac.reg_enable"
        val UAC_REG_DISABLE = "uac.reg_disable"
        val UAC_REG_UNREGISTER = "uac.reg_unregister"
        val UAC_REG_REFRESH = "uac.reg_refresh"
        val UAC_REG_ACTIVE = "uac.reg_active"
        val UAC_REG_ADD = "uac.reg_add"
        val UAC_REG_REMOVE = "uac.reg_remove"

        // stats
        val CORE_ALIASES_LIST = "core.aliases_list"
        val CORE_ARG = "core.arg"
        val CORE_ECHO = "core.echo"
        val CORE_FLAGS = "core.flags"
        val CORE_INFO = "core.info"
        val CORE_RUNINFO = "core.runinfo"
        val CORE_KILL = "core.kill"
        val CORE_PRINTI = "core.printi"
        val CORE_PRINTS = "core.prints"
        val CORE_PS = "core.ps"
        val CORE_PSX = "core.psx"
        val CORE_PWD = "core.pwd"
        val CORE_SHMMEM = "core.shmmem"
        val CORE_SOCKETS_LIST = "core.sockets_list"
        val CORE_TCP_INFO = "core.tcp_info"
        val CORE_TCP_LIST = "core.tcp_list"
        val CORE_TCP_OPTIONS = "core.tcp_options"
        val CORE_UDP4_RAW_INFO = "core.udp4_raw_info"
        val CORE_UPTIME = "core.uptime"
        val CORE_VERSION = "core.version"
        val CORE_PPDEFINES = "core.ppdefines"
        val CORE_MODULES = "core.modules"
        val PKG_STATS = "pkg.stats"
        val PKG_INFO = "pkg.info"
        val STATS_GET_STATISTICS = "stats.get_statistics"
        val STATS_FETCH = "stats.fetch"
        val STATS_FETCHN = "stats.fetchn"
        val STATS_RESET_STATISTICS = "stats.reset_statistics"
        val STATS_CLEAR_STATISTICS = "stats.clear_statistics"
        val SYSTEM_LIST_METHODS = "system.listMethods"
        val SYSTEM_METHOD_HELP = "system.methodHelp"
        val SYSTEM_METHOD_SIGNATURE = "system.methodSignature"
        val MOD_MEM_STATS = "mod.mem_stats"
        val MOD_STATS = "mod.stats"
        val MOD_MEM_STATSX = "mod.mem_statsx"

    }
}