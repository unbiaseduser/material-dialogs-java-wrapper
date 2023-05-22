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

package com.sixtyninefourtwenty.materialdialogsjavawrapper.data

import androidx.annotation.ArrayRes
import com.sixtyninefourtwenty.materialdialogsjavawrapper.RealItemListener

class ListItemOptions private constructor(builder: Builder) {

    internal val res = builder.res
    internal val items = builder.items
    internal val disabledIndices = builder.disabledIndices
    internal val waitForPositiveButton = builder.waitForPositiveButton
    internal val selection = builder.selection

    class Builder private constructor(@ArrayRes internal val res: Int?,
                                      internal val items: List<CharSequence>?) {
        constructor(res: Int): this(res, null)
        constructor(items: List<CharSequence>): this(null, items)

        internal var disabledIndices: IntArray? = null
            private set
        internal var waitForPositiveButton: Boolean = true
            private set
        internal var selection: RealItemListener? = null
            private set

        fun setDisabledIndices(indices: IntArray) = apply { this.disabledIndices = indices }
        fun setWaitForPositiveButton(wait: Boolean) = apply { this.waitForPositiveButton = wait }
        fun setSelection(selection: RealItemListener) = apply { this.selection = selection }
        fun build() = ListItemOptions(this)
    }
}
