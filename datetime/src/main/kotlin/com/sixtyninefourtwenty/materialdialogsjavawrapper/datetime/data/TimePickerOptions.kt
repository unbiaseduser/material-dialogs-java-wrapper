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

package com.sixtyninefourtwenty.materialdialogsjavawrapper.datetime.data

import com.afollestad.materialdialogs.MaterialDialog
import java.util.Calendar
import java.util.function.BiConsumer

class TimePickerOptions private constructor(builder: Builder) {

    internal val currentTime = builder.currentTime
    internal val requireFutureTime = builder.requireFutureTime
    internal val show24HoursView = builder.show24HoursView
    internal val timeCallback = builder.timeCallback

    class Builder {
        internal var currentTime: Calendar? = null
            private set
        internal var requireFutureTime: Boolean = false
            private set
        internal var show24HoursView: Boolean = true
            private set
        internal var timeCallback: BiConsumer<MaterialDialog, Calendar>? = null
            private set

        fun setCurrentTime(time: Calendar) = apply { this.currentTime = time }
        fun setRequireFutureTime(require: Boolean) = apply { this.requireFutureTime = require }
        fun setShow24HoursView(show: Boolean) = apply { this.show24HoursView = show }
        fun setTimeCallback(callback: BiConsumer<MaterialDialog, Calendar>) = apply { this.timeCallback = callback }
        fun build() = TimePickerOptions(this)
    }
}
