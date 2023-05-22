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

@file:JvmName("MDColorPicker")
@file:Suppress("unused")
package com.sixtyninefourtwenty.materialdialogsjavawrapper.color

import android.annotation.SuppressLint
import androidx.annotation.ColorInt
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.color.colorChooser
import com.afollestad.materialdialogs.color.setArgbColor
import com.sixtyninefourtwenty.materialdialogsjavawrapper.MaterialDialogWrapper
import com.sixtyninefourtwenty.materialdialogsjavawrapper.color.data.ColorPickerOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.utils.asKotlinFunction

/**
 * @see [MaterialDialog.colorChooser]
 */
@SuppressLint("CheckResult")
fun MaterialDialogWrapper.colorChooser(options: ColorPickerOptions) {
    dialog.colorChooser(colors = options.colors,
        subColors = options.subColors,
        initialSelection = options.initialSelection,
        waitForPositiveButton = options.waitForPositiveButton,
        allowCustomArgb = options.allowCustomArgb,
        showAlphaSelector = options.showAlphaSelector,
        changeActionButtonsColor = options.changeActionButtonsColor,
        selection = options.selection?.asKotlinFunction())
}

/**
 * @see [MaterialDialog.setArgbColor]
 */
fun MaterialDialogWrapper.setArgbColor(@ColorInt color: Int) {
    dialog.setArgbColor(color = color)
}
