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

class DatePickerOptions private constructor(builder: Builder) {

    internal val minDate = builder.minDate
    internal val maxDate = builder.maxDate
    internal val currentDate = builder.currentDate
    internal val requireFutureDate = builder.requireFutureDate
    internal val dateCallback = builder.dateCallback

    class Builder {
        internal var minDate: Calendar? = null
            private set
        internal var maxDate: Calendar? = null
            private set
        internal var currentDate: Calendar? = null
            private set
        internal var requireFutureDate: Boolean = false
            private set
        internal var dateCallback: BiConsumer<MaterialDialog, Calendar>? = null
            private set

        fun setMinDate(date: Calendar) = apply { this.minDate = date }
        fun setMaxDate(date: Calendar) = apply { this.maxDate = date }
        fun setCurrentDate(date: Calendar) = apply { this.currentDate = date }
        fun setRequireFutureDate(require: Boolean) = apply { this.requireFutureDate = require }
        fun setDateCallback(dateCallback: BiConsumer<MaterialDialog, Calendar>) = apply { this.dateCallback = dateCallback }
        fun build() = DatePickerOptions(this)
    }
}
