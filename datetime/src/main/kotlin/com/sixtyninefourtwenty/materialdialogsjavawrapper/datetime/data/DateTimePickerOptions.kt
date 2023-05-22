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

class DateTimePickerOptions private constructor(builder: Builder) {

    internal val minDateTime = builder.minDateTime
    internal val maxDateTime = builder.maxDateTime
    internal val currentDateTime = builder.currentDateTime
    internal val requireFutureDateTime = builder.requireFutureDateTime
    internal val show24HoursView = builder.show24HoursView
    internal val autoFlipToTime = builder.autoFlipToTime
    internal val dateTimeCallback = builder.dateTimeCallback

    class Builder {
        internal var minDateTime: Calendar? = null
            private set
        internal var maxDateTime: Calendar? = null
            private set
        internal var currentDateTime: Calendar? = null
            private set
        internal var requireFutureDateTime: Boolean = false
            private set
        internal var show24HoursView: Boolean = false
            private set
        internal var autoFlipToTime: Boolean = true
            private set
        internal var dateTimeCallback: BiConsumer<MaterialDialog, Calendar>? = null
            private set

        fun setMinDateTime(dateTime: Calendar) = apply { this.minDateTime = dateTime }
        fun setMaxDateTime(dateTime: Calendar) = apply { this.maxDateTime = dateTime }
        fun setCurrentDateTime(dateTime: Calendar) = apply { this.currentDateTime = dateTime }
        fun setRequireFutureDateTime(require: Boolean) = apply { this.requireFutureDateTime = require }
        fun setShow24HoursView(show: Boolean) = apply { this.show24HoursView = show }
        fun setAutoFlipToTime(flip: Boolean) = apply { this.autoFlipToTime = flip }
        fun setDateTimeCallback(callback: BiConsumer<MaterialDialog, Calendar>) = apply { this.dateTimeCallback = callback }
        fun build() = DateTimePickerOptions(this)
    }
}
