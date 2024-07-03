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

package com.plohar.kamailio.api

import com.plohar.kamailio.api.core.BaseContext
import com.plohar.kamailio.api.core.ProfileType
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.boot.context.event.SpringApplicationEvent
import org.springframework.boot.runApplication
import org.springframework.boot.system.ApplicationPid
import org.springframework.context.ApplicationContext
import org.springframework.context.event.EventListener
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import java.io.File
import java.io.IOException

@SpringBootApplication
@EnableR2dbcRepositories
@OpenAPIDefinition(
        info = Info(
                title = "Kamailio-Module-API", version = "1.0.0", description = "module-apis"
        )
)
class KamailioModulesApiApplication(
        @Value(value = "\${spring.pid.file}") val pid: String
) : BaseContext() {
    @Autowired
    lateinit var ctx: ApplicationContext

    companion object : KLogging()

    @EventListener(ApplicationStartedEvent::class)
    fun applicationStaredEvent(event: SpringApplicationEvent) {
        logger.info("[ApplicationStartedEvent] Application is starting")
    }

    @EventListener(ApplicationReadyEvent::class)
    fun applicationReadyEvent(event: SpringApplicationEvent) {
        val activeProfile = ctx.environment.activeProfiles.let {
            if (it.isNotEmpty()) ProfileType.valueOf(it.last().uppercase()).name else ProfileType.DEFAULT.name
        }
        logger.info("[ApplicationReadyEvent] activeProfiles = $activeProfile")
        writePidFile()

        val appEnv = System.getProperty("app.env") ?: "host"
        val appName = System.getProperty("app.name")
        logger.info("[ApplicationReadyEvent] profile = $activeProfile")
        logger.info("[ApplicationReadyEvent] appName = $appName")
        logger.info("[ApplicationReadyEvent] appEnv = $appEnv")

    }

    @Throws(IOException::class)
    private fun writePidFile() {
        val pidFile = File(pid)
        ApplicationPid().write(pidFile)
        pidFile.deleteOnExit()
        logger.info("[ApplicationReadyEvent] pid = $pid, ${buildProperties.name}, ${buildProperties.version}")
    }
}

fun main(args: Array<String>) {
    System.setProperty("app.name", "kamailio-modules-api")
    System.setProperty("app.base", "./")
    System.setProperty("reactor.netty.http.server.accessLogEnabled", "true")
    runApplication<KamailioModulesApiApplication>(*args)
}
