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

import com.plohar.kamailio.api.vo.`in`.uacreg.UacRegRpcAddInVo
import com.plohar.kamailio.api.vo.`in`.uacreg.UacRegRpcRefreshInVo
import com.plohar.kamailio.api.vo.`in`.uacreg.UacRegRpcRegEnableInVo
import com.plohar.kamailio.api.vo.`in`.uacreg.UacRegRpcRegInfoInVo
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk

class DefaultJsonRpcRequestFactoryTest : StringSpec({

    // Mocking dependencies
    @MockK
    lateinit var uacRegRefreshRpcInVo: UacRegRpcRefreshInVo

    @MockK
    lateinit var uacRegRpcRegInfoInVo: UacRegRpcRegInfoInVo

    @MockK
    lateinit var uacRegRpcRegEnableInVo: UacRegRpcRegEnableInVo

    @MockK
    lateinit var uacRegAddInVo: UacRegRpcAddInVo

    // Initializing the factory
    val factory = DefaultJsonRpcRequestFactory()

    // Initialize mock annotations
    beforeTest {
        MockKAnnotations.init(this)
    }

    "createUacRefreshRegRequest should create valid JsonRpcRequest" {
        // Mock behavior for uacRegRefreshRpcInVo
        uacRegRefreshRpcInVo = mockk()
        every { uacRegRefreshRpcInVo.serverUrl } returns "http://example.com"
        every { uacRegRefreshRpcInVo.id } returns "1"
        every { uacRegRefreshRpcInVo.luuid } returns "04011110000"

        val result = factory.createUacRefreshRegRequest(uacRegRefreshRpcInVo)

        result.method shouldBe Method.UAC_REG_REFRESH
        result.serverEndPoint shouldBe "http://example.com"
        result.id shouldBe "1"
        result.params shouldBe listOf("l_uuid", "04011110000")
    }

    "createUacRegInfoRequest should create valid JsonRpcRequest" {
        // Mock behavior for uacRegRpcRegInfoInVo
        uacRegRpcRegInfoInVo = mockk()
        every { uacRegRpcRegInfoInVo.serverUrl } returns "http://example.com"
        every { uacRegRpcRegInfoInVo.id } returns "1"
        every { uacRegRpcRegInfoInVo.luuid } returns "04011110000"

        val result = factory.createUacRegInfoRequest(uacRegRpcRegInfoInVo)

        result.method shouldBe Method.UAC_REG_INFO
        result.serverEndPoint shouldBe "http://example.com"
        result.id shouldBe "1"
        result.params shouldBe listOf("l_uuid", "04011110000")
    }

    "createUacRegEnableRequest should create valid JsonRpcRequest" {
        uacRegRpcRegEnableInVo = mockk()
        // Mock behavior for uacRegRpcRegEnableInVo
        every { uacRegRpcRegEnableInVo.serverUrl } returns "http://example.com"
        every { uacRegRpcRegEnableInVo.id } returns "1"
        every { uacRegRpcRegEnableInVo.luuid } returns "04011110000"

        val result = factory.createUacRegEnableRequest(uacRegRpcRegEnableInVo)

        result.method shouldBe Method.UAC_REG_ENABLE
        result.serverEndPoint shouldBe "http://example.com"
        result.id shouldBe "1"
        result.params shouldBe listOf("l_uuid", "04011110000")
    }

    "createUacRegAddRequest should create valid JsonRpcRequest" {
        // Mock behavior for uacRegAddInVo
        uacRegAddInVo = mockk()
        every { uacRegAddInVo.serverUrl } returns "http://example.com"
        every { uacRegAddInVo.id } returns "1"
        every { uacRegAddInVo.luuid } returns "04011110000"
        every { uacRegAddInVo.luserName } returns "N1234"
        every { uacRegAddInVo.ldomain } returns "."
        every { uacRegAddInVo.ruserName } returns "test"
        every { uacRegAddInVo.rdomain } returns "30"
        every { uacRegAddInVo.realm } returns "0"
        every { uacRegAddInVo.authUserName } returns "0"
        every { uacRegAddInVo.authPassword } returns "0"
        every { uacRegAddInVo.authHa1 } returns "0"
        every { uacRegAddInVo.authProxy } returns "test"
        every { uacRegAddInVo.expires } returns 60
        every { uacRegAddInVo.flags } returns 0
        every { uacRegAddInVo.regDelay } returns 30
        every { uacRegAddInVo.contactAddr } returns "sip:172.27.0.10:6060"
        every { uacRegAddInVo.socketToUse } returns "172.27.0.10:6060"

        val result = factory.createUacRegAddRequest(uacRegAddInVo)

        result.method shouldBe Method.UAC_REG_ADD
        result.serverEndPoint shouldBe "http://example.com"
        result.id shouldBe "1"
        result.params shouldBe listOf(
                "04011110000",
                "N1234",
                ".",
                "test",
                "30",
                "0",
                "0",
                "0",
                "0",
                "test",
                60,
                0,
                30,
                "sip:172.27.0.10:6060",
                "172.27.0.10:6060"
        )
    }

    // Add more test cases for other factory methods as needed

})