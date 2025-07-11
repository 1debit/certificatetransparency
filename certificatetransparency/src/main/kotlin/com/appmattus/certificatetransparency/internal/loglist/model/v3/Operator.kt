/*
 * Copyright 2021 Appmattus Limited
 * Copyright 2019 Babylon Partners Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * File modified by Appmattus Limited
 * See: https://github.com/appmattus/certificatetransparency/compare/e3d469df9be35bcbf0f564d32ca74af4e5ca4ae5...main
 */

package com.appmattus.certificatetransparency.internal.loglist.model.v3

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property name Name of this log operator
 * @property email CT log operator email addresses. The log operator can be contacted using any of these email addresses. (format: email)
 * @property logs Details of Certificate Transparency logs run by this operator.
 * @property tiledLogs Details of tiled Certificate Transparency logs run by this operator.
 */
@Serializable
internal data class Operator(
    @SerialName("name") val name: String,
    @SerialName("email") val email: List<String>,
    @SerialName("logs") val logs: List<Log> = emptyList(),
    @SerialName("tiled_logs") val tiledLogs: List<Log> = emptyList()
) {
    init {
        require(name.isNotEmpty())
        require(email.isNotEmpty())
        // Note: Removed requirement for logs.isNotEmpty() || tiledLogs.isNotEmpty()
        // to handle cases where operators have empty logs arrays in the JSON
    }
}
