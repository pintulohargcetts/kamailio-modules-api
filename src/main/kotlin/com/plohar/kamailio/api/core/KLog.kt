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

package com.plohar.kamailio.api.core

import mu.KLogging

/**
 * K log
 *
 * @constructor Create empty K log
 */
class KLog {
    companion object : KLogging() {
        @Throws(ClassNotFoundException::class)
        private fun getCallerClass(): StackTraceElement? {
            val level = 2 // level The level of the caller class.
            val stElements = Thread.currentThread().stackTrace
            return if (stElements[level + 1] != null) stElements[level + 1] else stElements[1]
        }

        private fun printOut(it: StackTraceElement, logType: LT, msg: String?): String {
            return "[${it.className.substringAfterLast('.', "")}:${it.lineNumber}" +
                    ":${it.methodName}][${logType.name}]: $msg"
        }


        fun d(logType: LT, msg: String?) {
            getCallerClass()?.let {
                logger.debug(printOut(it, logType, msg))
            }
        }

        fun i(logType: LT, msg: String?) {
            getCallerClass()?.let {
                logger.info(printOut(it, logType, msg))
            }
        }

    }

}