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

package com.sixtyninefourtwenty.materialdialogsjavawrapper.files.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.StringRes
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.files.R
import java.io.File
import java.util.function.BiConsumer
import java.util.function.Predicate

class FileFolderPickerOptions private constructor(builder: Builder) {

    internal val context = builder.context
    internal val initialDirectory = builder.initialDirectory
    internal val filter = builder.filter
    internal val waitForPositiveButton = builder.waitForPositiveButton
    internal val emptyTextRes = builder.emptyTextRes
    internal val allowFolderCreation = builder.allowFolderCreation
    internal val folderCreationLabel = builder.folderCreationLabel
    internal val selection = builder.selection

    class Builder(internal val context: Context) {
        internal var initialDirectory: File? = context.getExternalFilesDir(null)
            private set
        internal var filter: Predicate<File>? = null
            private set
        internal var waitForPositiveButton: Boolean = true
            private set
        @SuppressLint("PrivateResource")
        internal var emptyTextRes: Int = R.string.files_default_empty_text
            private set
        internal var allowFolderCreation: Boolean = false
            private set
        @StringRes internal var folderCreationLabel: Int? = null
            private set
        internal var selection: BiConsumer<MaterialDialog, File>? = null
            private set

        fun setInitialDirectory(dir: File) = apply { this.initialDirectory = dir }
        fun setFilter(filter: Predicate<File>) = apply { this.filter = filter }
        fun setWaitForPositiveButton(wait: Boolean) = apply { this.waitForPositiveButton = wait }
        fun setEmptyTextRes(@StringRes res: Int) = apply { this.emptyTextRes = res }
        fun setAllowFolderCreation(allow: Boolean) = apply { this.allowFolderCreation = allow }
        fun setFolderCreationLabel(@StringRes label: Int) = apply { this.folderCreationLabel = label }
        fun setSelection(selection: BiConsumer<MaterialDialog, File>) = apply { this.selection = selection }
        fun build() = FileFolderPickerOptions(this)
    }
}
