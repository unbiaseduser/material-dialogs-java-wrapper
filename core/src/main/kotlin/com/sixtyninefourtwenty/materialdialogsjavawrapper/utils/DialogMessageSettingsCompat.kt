/*
 * Copyright (C) 2023 unbiaseduser (Dang Quang Trung)
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
 */

@file:JvmName("DialogMessageSettingsCompat")
@file:Suppress("unused")
package com.sixtyninefourtwenty.materialdialogsjavawrapper.utils

import com.afollestad.materialdialogs.message.DialogMessageSettings
import java.util.function.Consumer

@JvmOverloads
fun DialogMessageSettings.htmlCompat(
    onLinkClick: Consumer<String>? = null
) = html(onLinkClick = onLinkClick?.asKotlinFunction())