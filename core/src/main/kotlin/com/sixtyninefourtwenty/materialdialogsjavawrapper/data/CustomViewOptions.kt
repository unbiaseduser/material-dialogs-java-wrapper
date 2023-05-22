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

import android.view.View

class CustomViewOptions private constructor(builder: Builder) {

    internal val view = builder.view
    internal val viewRes = builder.viewRes
    internal val scrollable = builder.scrollable
    internal val noVerticalPadding = builder.noVerticalPadding
    internal val horizontalPadding = builder.horizontalPadding
    internal val dialogWrapContent = builder.dialogWrapContent

    class Builder private constructor(internal val view: View?,
                                      internal val viewRes: Int?) {
        constructor(view: View): this(view, null)
        constructor(viewRes: Int): this(null, viewRes)
        internal var scrollable: Boolean = false
            private set
        internal var noVerticalPadding: Boolean = false
            private set
        internal var horizontalPadding: Boolean = false
            private set
        internal var dialogWrapContent: Boolean = false
            private set

        fun setScrollable(scrollable: Boolean) = apply { this.scrollable = scrollable }
        fun setNoVerticalPadding(no: Boolean) = apply { this.noVerticalPadding = no }
        fun setHorizontalPadding(has: Boolean) = apply { this.horizontalPadding = has }
        fun setDialogWrapContent(wrap: Boolean) = apply { this.dialogWrapContent = wrap }
        fun build() = CustomViewOptions(this)
    }
}
