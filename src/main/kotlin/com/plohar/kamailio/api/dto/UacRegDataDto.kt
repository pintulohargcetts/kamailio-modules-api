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

package com.plohar.kamailio.api.dto

/**
 * Uac reg data dto
 *
 * @constructor Create empty Uac reg data dto
 * @property lUuid
 * @property lUsername
 * @property lDomain
 * @property rUsername
 * @property rDomain
 * @property realm
 * @property authUsername
 * @property authPassword
 * @property authHa1
 * @property authProxy
 * @property expires
 * @property flags
 * @property regDelay
 * @property contactAddr
 * @property socket
 */
class UacRegDataDto(
    val lUuid: String,
    val lUsername: String,
    val lDomain: String,
    val rUsername: String,
    val rDomain: String,
    val realm: String,
    val authUsername: String,
    val authPassword: String,
    val authHa1: String,
    val authProxy: String,
    val expires: Int,
    val flags: Int,
    val regDelay: Int,
    val contactAddr: String,
    val socket: String, // Constructors, getters, and setters
)