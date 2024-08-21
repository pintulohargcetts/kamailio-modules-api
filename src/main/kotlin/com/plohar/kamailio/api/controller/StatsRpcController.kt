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

package com.plohar.kamailio.api.controller

import com.plohar.kamailio.api.service.StatsRpcService
import com.plohar.kamailio.api.vo.`in`.stats.StatsRpcInVo
import com.plohar.kamailio.api.vo.out.ApiResponse
import com.plohar.kamailio.api.vo.out.JsonRpcResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/v1/stats/rpc")
class StatsRpcController(
    private val statsRpcService: StatsRpcService
) {

    @GetMapping("/aliases_list")
    fun getAliasList(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_ALIASES_LIST
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/arg")
    fun getArg(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_ARG
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/echo")
    fun getEcho(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_ECHO
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/flags")
    fun getFlags(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_FLAGS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/info")
    fun getInfo(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_INFO
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/runinfo")
    fun getRunInfo(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_RUNINFO
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/kill")
    fun getKill(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_KILL
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/printi")
    fun getPrinti(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_PRINTI
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/prints")
    fun getPrints(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_PRINTS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/ps")
    fun getPs(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_PS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/psx")
    fun getPsx(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_PSX
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/pwd")
    fun getPwd(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_PWD
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/shmmem")
    fun getShmmem(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_SHMMEM
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/sockets_list")
    fun getSocketsList(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_SOCKETS_LIST
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/tcp_info")
    fun getTcpInfo(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_TCP_INFO
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/tcp_list")
    fun getTcpList(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_TCP_LIST
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/tcp_options")
    fun getTcpOptions(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_TCP_OPTIONS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/udp4_raw_info")
    fun getUdp4RawInfo(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_UDP4_RAW_INFO
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/uptime")
    fun getUptime(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_UPTIME
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/version")
    fun getVersion(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_VERSION
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/ppdefines")
    fun getPpdefines(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_PPDEFINES
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/modules")
    fun getModules(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.CORE_MODULES
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/pkg_stats")
    fun getPkgStats(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.PKG_STATS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/pkg_info")
    fun getPkgInfo(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.PKG_INFO
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/get_statistics")
    fun getStatistics(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.STATS_GET_STATISTICS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/fetch")
    fun fetch(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.STATS_FETCH
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/fetchn")
    fun fetchN(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.STATS_FETCHN
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/reset_statistics")
    fun resetStatistics(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.STATS_RESET_STATISTICS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/clear_statistics")
    fun clearStatistics(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.STATS_CLEAR_STATISTICS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/list_methods")
    fun listMethods(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.SYSTEM_LIST_METHODS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    /*@GetMapping("/method_help")
    fun methodHelp(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.SYSTEM_METHOD_HELP
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }*/

    @GetMapping("/method_signature")
    fun methodSignature(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.SYSTEM_METHOD_SIGNATURE
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/mem_stats")
    fun memStats(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.MOD_MEM_STATS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/mod_stats")
    fun stats(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.MOD_STATS
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }

    @GetMapping("/mem_statsx")
    fun memStatsx(statsRpcInVo: StatsRpcInVo): Mono<ApiResponse<ResponseEntity<JsonRpcResponse>>> {
        statsRpcInVo.statsType = StatsRpcInVo.StatsType.MOD_MEM_STATSX
        return statsRpcService.getStatisticsByStatsType(statsRpcInVo).map {
            ApiResponse(statsRpcInVo.transactionId, it)
        }
    }
}
