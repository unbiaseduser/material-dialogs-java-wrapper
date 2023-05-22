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

@file:JvmName("MDTimePicker")
@file:Suppress("unused")
package com.sixtyninefourtwenty.materialdialogsjavawrapper.datetime

import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.selectedTime
import com.afollestad.materialdialogs.datetime.timePicker
import com.sixtyninefourtwenty.materialdialogsjavawrapper.MaterialDialogWrapper
import com.sixtyninefourtwenty.materialdialogsjavawrapper.datetime.data.TimePickerOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.utils.asKotlinFunction

/**
 * @see [MaterialDialog.timePicker]
 */
fun MaterialDialogWrapper.timePicker(options: TimePickerOptions) {
    dialog.timePicker(currentTime = options.currentTime,
        requireFutureTime = options.requireFutureTime,
        show24HoursView = options.show24HoursView,
        timeCallback = options.timeCallback?.asKotlinFunction())
}

/**
 * @see [MaterialDialog.selectedTime]
 */
fun MaterialDialogWrapper.selectedTime() = dialog.selectedTime()
