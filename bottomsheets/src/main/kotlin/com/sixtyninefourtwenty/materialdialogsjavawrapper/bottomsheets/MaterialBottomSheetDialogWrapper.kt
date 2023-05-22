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

@file:Suppress("unused", "MemberVisibilityCanBePrivate")
package com.sixtyninefourtwenty.materialdialogsjavawrapper.bottomsheets

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.DimenRes
import androidx.annotation.Px
import com.afollestad.materialdialogs.LayoutMode
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.bottomsheets.GridItem
import com.afollestad.materialdialogs.bottomsheets.collapseBottomSheet
import com.afollestad.materialdialogs.bottomsheets.expandBottomSheet
import com.afollestad.materialdialogs.bottomsheets.gridItems
import com.afollestad.materialdialogs.bottomsheets.setPeekHeight
import com.afollestad.materialdialogs.bottomsheets.updateGridItems
import com.sixtyninefourtwenty.materialdialogsjavawrapper.MaterialDialogWrapper
import com.sixtyninefourtwenty.materialdialogsjavawrapper.bottomsheets.data.GridItemsOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.bottomsheets.utils.asKotlinFunction

class MaterialBottomSheetDialogWrapper @JvmOverloads constructor(
    context: Context,
    layoutMode: LayoutMode = LayoutMode.MATCH_PARENT
) : MaterialDialogWrapper(context, BottomSheet(layoutMode)) {

    /**
     * @see [MaterialDialog.expandBottomSheet]
     */
    fun expandBottomSheet() = apply { dialog.expandBottomSheet() }

    /**
     * @see [MaterialDialog.collapseBottomSheet]
     */
    fun collapseBottomSheet() = apply { dialog.collapseBottomSheet() }

    /**
     * @see [MaterialDialog.setPeekHeight]
     */
    fun setPeekHeightUsingLiteral(@Px literal: Int) = apply {
        dialog.setPeekHeight(literal = literal)
    }

    /**
     * @see [MaterialDialog.setPeekHeight]
     */
    fun setPeekHeightUsingDimenRes(@DimenRes res: Int) = apply {
        dialog.setPeekHeight(res = res)
    }

    /**
     * @see [MaterialDialog.gridItems]
     */
    @SuppressLint("CheckResult")
    fun <IT : GridItem> gridItems(options: GridItemsOptions<IT>) = apply {
        dialog.gridItems(items = options.items,
            customGridWidth = options.customGridWidth,
            disabledIndices = options.disabledIndices,
            waitForPositiveButton = options.waitForPositiveButton,
            selection = options.selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.updateGridItems]
     */
    @JvmOverloads
    fun updateGridItems(items: List<GridItem>,
                        disabledIndices: IntArray? = null) = apply {
        dialog.updateGridItems(items = items, disabledIndices = disabledIndices)
    }
}
