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

@file:JvmName("MDFilePicker")
@file:Suppress("unused")
package com.sixtyninefourtwenty.materialdialogsjavawrapper.files

import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.files.fileChooser
import com.afollestad.materialdialogs.files.selectedFile
import com.sixtyninefourtwenty.materialdialogsjavawrapper.MaterialDialogWrapper
import com.sixtyninefourtwenty.materialdialogsjavawrapper.files.data.FileFolderPickerOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.utils.asKotlinFunction

/**
 * @see [MaterialDialog.selectedFile]
 */
fun MaterialDialogWrapper.selectedFile() = dialog.selectedFile()

/**
 * @see [MaterialDialog.fileChooser]
 */
fun MaterialDialogWrapper.fileChooser(options: FileFolderPickerOptions) {
    dialog.fileChooser(context = options.context,
        initialDirectory = options.initialDirectory,
        filter = options.filter?.asKotlinFunction(),
        waitForPositiveButton = options.waitForPositiveButton,
        emptyTextRes = options.emptyTextRes,
        allowFolderCreation = options.allowFolderCreation,
        folderCreationLabel = options.folderCreationLabel,
        selection = options.selection?.asKotlinFunction())
}
