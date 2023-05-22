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

package com.sixtyninefourtwenty.materialdialogsjavawrapper.color.data

import androidx.annotation.ColorInt
import com.afollestad.materialdialogs.MaterialDialog
import java.util.function.ObjIntConsumer

class ColorPickerOptions private constructor(builder: Builder) {

    internal val colors = builder.colors
    internal val subColors = builder.subColors
    internal val initialSelection = builder.initialSelection
    internal val waitForPositiveButton = builder.waitForPositiveButton
    internal val allowCustomArgb = builder.allowCustomArgb
    internal val showAlphaSelector = builder.showAlphaSelector
    internal val changeActionButtonsColor = builder.changeActionButtonsColor
    internal val selection = builder.selection

    @Suppress("unused")
    class Builder(@ColorInt internal val colors: IntArray) {
        internal var subColors: Array<IntArray>? = null
            private set
        @ColorInt
        internal var initialSelection: Int? = null
            private set
        internal var waitForPositiveButton: Boolean = true
            private set
        internal var allowCustomArgb: Boolean = false
            private set
        internal var showAlphaSelector: Boolean = false
            private set
        internal var changeActionButtonsColor: Boolean = false
            private set
        internal var selection: ObjIntConsumer<MaterialDialog>? = null
            private set

        fun setSubColors(subColors: Array<IntArray>) = apply { this.subColors = subColors }
        fun setInitialSelection(@ColorInt selection: Int) = apply { this.initialSelection = selection }
        fun setWaitForPositiveButton(wait: Boolean) = apply { this.waitForPositiveButton = wait }
        fun setAllowCustomArgb(allow: Boolean) = apply { this.allowCustomArgb = allow }
        fun setShowAlphaSelector(show: Boolean) = apply { this.showAlphaSelector = show }
        fun setChangeActionButtonsColor(change: Boolean) = apply { this.changeActionButtonsColor = change }
        fun setSelection(callback: ObjIntConsumer<MaterialDialog>) = apply { this.selection = callback }
        fun build() = ColorPickerOptions(this)
    }
}
