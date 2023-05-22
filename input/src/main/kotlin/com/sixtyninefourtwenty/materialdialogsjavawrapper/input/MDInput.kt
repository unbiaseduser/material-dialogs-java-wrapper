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

@file:JvmName("MDInput")
@file:Suppress("unused")
package com.sixtyninefourtwenty.materialdialogsjavawrapper.input

import android.annotation.SuppressLint
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.getInputLayout
import com.afollestad.materialdialogs.input.input
import com.sixtyninefourtwenty.materialdialogsjavawrapper.MaterialDialogWrapper
import com.sixtyninefourtwenty.materialdialogsjavawrapper.input.data.InputOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.utils.asKotlinFunction

/**
 * @see [MaterialDialog.getInputLayout]
 */
fun MaterialDialogWrapper.getInputLayout() = dialog.getInputLayout()

/**
 * @see [MaterialDialog.getInputField]
 */
fun MaterialDialogWrapper.getInputField() = dialog.getInputField()

/**
 * @see [MaterialDialog.input]
 */
@SuppressLint("CheckResult")
fun MaterialDialogWrapper.input(options: InputOptions) {
    dialog.input(hint = options.hint,
        hintRes = options.hintRes,
        prefill = options.prefill,
        prefillRes = options.prefillRes,
        inputType = options.inputType,
        maxLength = options.maxLength,
        waitForPositiveButton = options.waitForPositiveButton,
        allowEmpty = options.allowEmpty,
        callback = options.callback?.asKotlinFunction())
}
