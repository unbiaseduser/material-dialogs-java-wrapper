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

package com.sixtyninefourtwenty.materialdialogsjavawrapper.input.data

import android.text.InputType
import com.afollestad.materialdialogs.MaterialDialog
import java.util.function.BiConsumer

class InputOptions private constructor(builder: Builder) {
    internal val hint = builder.hint
    internal val hintRes = builder.hintRes
    internal val prefill = builder.prefill
    internal val prefillRes = builder.prefillRes
    internal val inputType = builder.inputType
    internal val maxLength = builder.maxLength
    internal val waitForPositiveButton = builder.waitForPositiveButton
    internal val allowEmpty = builder.allowEmpty
    internal val callback = builder.callback

    class Builder {
        internal var hint: String? = null
            private set
        internal var hintRes: Int? = null
            private set
        internal var prefill: CharSequence? = null
            private set
        internal var prefillRes: Int? = null
            private set
        internal var inputType: Int = InputType.TYPE_CLASS_TEXT
            private set
        internal var maxLength: Int? = null
            private set
        internal var waitForPositiveButton: Boolean = true
            private set
        internal var allowEmpty: Boolean = false
            private set
        internal var callback: BiConsumer<MaterialDialog, CharSequence>? = null
            private set

        fun setHint(hint: String) = apply { this.hint = hint }
        fun setHint(hintRes: Int) = apply { this.hintRes = hintRes }
        fun setPrefill(prefill: CharSequence) = apply { this.prefill = prefill }
        fun setPrefill(prefillRes: Int) = apply { this.prefillRes = prefillRes }
        fun setInputType(inputType: Int) = apply { this.inputType = inputType }
        fun setMaxLength(maxLength: Int) = apply { this.maxLength = maxLength }
        fun setWaitForPositiveButton(wait: Boolean) = apply { this.waitForPositiveButton = wait }
        fun setAllowEmpty(allow: Boolean) = apply { this.allowEmpty = allow }
        fun setCallback(callback: BiConsumer<MaterialDialog, CharSequence>) = apply { this.callback = callback }
        fun build() = InputOptions(this)
    }
}
