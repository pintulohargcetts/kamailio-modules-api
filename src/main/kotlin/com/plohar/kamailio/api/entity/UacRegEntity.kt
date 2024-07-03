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

package com.plohar.kamailio.api.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

/**
 * Uac reg entity
 *
 * @constructor Create empty Uac reg entity
 * @property id
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
@Table("uacreg")
data class UacRegEntity(
        @Id val id: Long = 0,
        @Column("l_uuid")
        val lUuid: String,
        @Column("l_username")
        var lUsername: String,
        @Column("l_domain")
        var lDomain: String,
        @Column("r_username")
        var rUsername: String,
        @Column("r_domain")
        var rDomain: String,
        @Column("realm")
        var realm: String,
        @Column("auth_username")
        var authUsername: String,
        @Column("auth_password")
        var authPassword: String,
        @Column("auth_ha1")
        var authHa1: String,
        @Column("auth_proxy")
        var authProxy: String,
        var expires: Int,
        var flags: Int,
        @Column("reg_delay")
        var regDelay: Int,
        @Column("contact_addr")
        var contactAddr: String,
        var socket: String
)