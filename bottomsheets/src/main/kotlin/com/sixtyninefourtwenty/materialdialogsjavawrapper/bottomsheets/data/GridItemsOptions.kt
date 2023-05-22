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

package com.sixtyninefourtwenty.materialdialogsjavawrapper.bottomsheets.data

import androidx.annotation.IntegerRes
import com.sixtyninefourtwenty.materialdialogsjavawrapper.bottomsheets.RealGridItemListener

class GridItemsOptions<T> private constructor(builder: Builder<T>) {

    internal val items = builder.items
    internal val customGridWidth = builder.customGridWidth
    internal val disabledIndices = builder.disabledIndices
    internal val waitForPositiveButton = builder.waitForPositiveButton
    internal val selection = builder.selection

    class Builder<T>(internal val items: List<T>) {
        internal var customGridWidth: Int? = null
            private set
        internal var disabledIndices: IntArray? = null
            private set
        internal var waitForPositiveButton: Boolean = true
            private set
        internal var selection: RealGridItemListener<T>? = null
            private set

        fun setCustomGridWidth(@IntegerRes width: Int) = apply { this.customGridWidth = width }
        fun setDisabledIndices(indices: IntArray) = apply { this.disabledIndices = indices }
        fun setWaitForPositiveButton(wait: Boolean) = apply { this.waitForPositiveButton = wait }
        fun setSelection(selection: RealGridItemListener<T>) = apply { this.selection = selection }
        fun build() = GridItemsOptions(this)
    }
}
