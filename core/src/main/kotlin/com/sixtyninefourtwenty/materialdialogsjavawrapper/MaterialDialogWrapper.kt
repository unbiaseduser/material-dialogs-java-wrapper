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

package com.sixtyninefourtwenty.materialdialogsjavawrapper

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.Px
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.DialogBehavior
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.WhichButton
import com.afollestad.materialdialogs.actions.getActionButton
import com.afollestad.materialdialogs.actions.hasActionButton
import com.afollestad.materialdialogs.actions.hasActionButtons
import com.afollestad.materialdialogs.actions.setActionButtonEnabled
import com.afollestad.materialdialogs.callbacks.onCancel
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.afollestad.materialdialogs.callbacks.onPreShow
import com.afollestad.materialdialogs.callbacks.onShow
import com.afollestad.materialdialogs.checkbox.checkBoxPrompt
import com.afollestad.materialdialogs.checkbox.getCheckBoxPrompt
import com.afollestad.materialdialogs.checkbox.isCheckPromptChecked
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.list.checkAllItems
import com.afollestad.materialdialogs.list.checkItem
import com.afollestad.materialdialogs.list.checkItems
import com.afollestad.materialdialogs.list.customListAdapter
import com.afollestad.materialdialogs.list.getListAdapter
import com.afollestad.materialdialogs.list.getRecyclerView
import com.afollestad.materialdialogs.list.isItemChecked
import com.afollestad.materialdialogs.list.listItems
import com.afollestad.materialdialogs.list.listItemsMultiChoice
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.afollestad.materialdialogs.list.toggleAllItemsChecked
import com.afollestad.materialdialogs.list.toggleItemChecked
import com.afollestad.materialdialogs.list.toggleItemsChecked
import com.afollestad.materialdialogs.list.uncheckAllItems
import com.afollestad.materialdialogs.list.uncheckItem
import com.afollestad.materialdialogs.list.uncheckItems
import com.afollestad.materialdialogs.list.updateListItems
import com.afollestad.materialdialogs.list.updateListItemsMultiChoice
import com.afollestad.materialdialogs.list.updateListItemsSingleChoice
import com.afollestad.materialdialogs.message.DialogMessageSettings
import com.sixtyninefourtwenty.materialdialogsjavawrapper.data.CustomViewOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.data.ListItemMultiChoiceOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.data.ListItemOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.data.ListItemSingleChoiceOptions
import com.sixtyninefourtwenty.materialdialogsjavawrapper.utils.asKotlinFunction
import java.util.function.Consumer

open class MaterialDialogWrapper @JvmOverloads constructor(
    context: Context,
    dialogBehavior: DialogBehavior = MaterialDialog.DEFAULT_BEHAVIOR
) {
    val dialog = MaterialDialog(context, dialogBehavior)

    //region standard
    /**
     * @see [MaterialDialog.config]
     */
    val config = dialog.config

    /**
     * @see [MaterialDialog.config]
     */
    @Suppress("UNCHECKED_CAST")
    fun <T> config(key: String): T {
        return config[key] as T
    }

    /**
     * @see [MaterialDialog.icon]
     */
    fun icon(@DrawableRes res: Int) = apply {
        dialog.icon(res = res)
    }

    /**
     * @see [MaterialDialog.icon]
     */
    fun icon(drawable: Drawable) = apply {
        dialog.icon(drawable = drawable)
    }

    /**
     * @see [MaterialDialog.title]
     */
    fun title(@StringRes res: Int) = apply {
        dialog.title(res = res)
    }

    /**
     * @see [MaterialDialog.title]
     */
    fun title(text: String) = apply {
        dialog.title(text = text)
    }

    /**
     * @see [MaterialDialog.message]
     */
    @JvmOverloads
    fun message(
        @StringRes res: Int,
        applySettings: Consumer<DialogMessageSettings>? = null
    ) = apply {
        dialog.message(res = res, applySettings = applySettings?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.message]
     */
    @JvmOverloads
    fun message(
        text: CharSequence,
        applySettings: Consumer<DialogMessageSettings>? = null
    ) = apply {
        dialog.message(text = text, applySettings = applySettings?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.positiveButton]
     */
    @JvmOverloads
    fun positiveButton(
        @StringRes res: Int,
        click: Consumer<MaterialDialog>? = null
    ) = apply {
        dialog.positiveButton(res = res, click = click?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.positiveButton]
     */
    @JvmOverloads
    fun positiveButton(
        text: CharSequence,
        click: Consumer<MaterialDialog>? = null
    ) = apply {
        dialog.positiveButton(text = text, click = click?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.clearPositiveListeners]
     */
    fun clearPositiveListeners() = apply {
        dialog.clearPositiveListeners()
    }

    /**
     * @see [MaterialDialog.negativeButton]
     */
    @JvmOverloads
    fun negativeButton(
        @StringRes res: Int,
        click: Consumer<MaterialDialog>? = null
    ) = apply {
        dialog.negativeButton(res = res, click = click?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.negativeButton]
     */
    @JvmOverloads
    fun negativeButton(
        text: CharSequence,
        click: Consumer<MaterialDialog>? = null
    ) = apply {
        dialog.negativeButton(text = text, click = click?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.clearNegativeListeners]
     */
    fun clearNegativeListeners() = apply {
        dialog.clearNegativeListeners()
    }

    /**
     * @see [MaterialDialog.neutralButton]
     */
    @Suppress("DEPRECATION")
    @JvmOverloads
    fun neutralButton(
        @StringRes res: Int,
        click: Consumer<MaterialDialog>? = null
    ) = apply {
        dialog.neutralButton(res = res, click = click?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.neutralButton]
     */
    @Suppress("DEPRECATION")
    @JvmOverloads
    fun neutralButton(
        text: CharSequence,
        click: Consumer<MaterialDialog>? = null
    ) = apply {
        dialog.neutralButton(text = text, click = click?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.clearNeutralListeners]
     */
    @Suppress("DEPRECATION")
    fun clearNeutralListeners() = apply {
        dialog.clearNeutralListeners()
    }

    /**
     * @see [MaterialDialog.noAutoDismiss]
     */
    @SuppressLint("CheckResult")
    fun noAutoDismiss() = apply {
        dialog.noAutoDismiss()
    }

    /**
     * @see [MaterialDialog.maxWidth]
     */
    fun maxWidthUsingDimenRes(@DimenRes res: Int) = apply {
        dialog.maxWidth(res = res)
    }

    /**
     * @see [MaterialDialog.maxWidth]
     */
    fun maxWidthUsingLiteral(@Px literal: Int) = apply {
        dialog.maxWidth(literal = literal)
    }

    /**
     * @see [MaterialDialog.cornerRadius]
     */
    fun cornerRadiusUsingDimenRes(@DimenRes res: Int) = apply {
        dialog.cornerRadius(res = res)
    }

    /**
     * @see [MaterialDialog.cornerRadius]
     */
    fun cornerRadiusUsingLiteral(literalDp: Float) = apply {
        dialog.cornerRadius(literalDp = literalDp)
    }

    /**
     * @see [MaterialDialog.debugMode]
     */
    @SuppressLint("CheckResult")
    @JvmOverloads
    fun debugMode(debugMode: Boolean = true) = apply {
        dialog.debugMode(debugMode = debugMode)
    }

    /**
     * @see [MaterialDialog.show]
     */
    fun show() = dialog.show()

    /**
     * @see [MaterialDialog.show]
     */
    fun show(func: Consumer<MaterialDialog>) = dialog.show(func.asKotlinFunction())

    /**
     * @see [MaterialDialog.cancelable]
     */
    fun cancelable(cancelable: Boolean) = apply {
        dialog.cancelable(cancelable = cancelable)
    }

    /**
     * @see [MaterialDialog.cancelOnTouchOutside]
     */
    fun cancelOnTouchOutside(cancelable: Boolean) = apply {
        dialog.cancelOnTouchOutside(cancelable = cancelable)
    }
    //endregion

    //region checkbox
    /**
     * @see [MaterialDialog.getCheckBoxPrompt]
     */
    fun getCheckBoxPrompt() = dialog.getCheckBoxPrompt()

    /**
     * @see [MaterialDialog.isCheckPromptChecked]
     */
    fun isCheckPromptChecked() = dialog.isCheckPromptChecked()

    /**
     * @see [MaterialDialog.checkBoxPrompt]
     */
    @JvmOverloads
    fun checkBoxPrompt(
        @StringRes res: Int,
        onToggle: Consumer<Boolean>,
        isCheckedDefault: Boolean = false
    ) = apply {
        dialog.checkBoxPrompt(
            res = res,
            isCheckedDefault = isCheckedDefault,
            onToggle = onToggle.asKotlinFunction()
        )
    }

    /**
     * @see [MaterialDialog.checkBoxPrompt]
     */
    @JvmOverloads
    fun checkBoxPrompt(
        text: String,
        onToggle: Consumer<Boolean>,
        isCheckedDefault: Boolean = false
    ) = apply {
        dialog.checkBoxPrompt(
            text = text,
            isCheckedDefault = isCheckedDefault,
            onToggle = onToggle.asKotlinFunction()
        )
    }
    //endregion

    //region actions
    /**
     * @see [MaterialDialog.hasActionButtons]
     */
    fun hasActionButtons() = dialog.hasActionButtons()

    /**
     * @see [MaterialDialog.hasActionButton]
     */
    fun hasActionButton(which: WhichButton) = dialog.hasActionButton(which = which)

    /**
     * @see [MaterialDialog.getActionButton]
     */
    fun getActionButton(which: WhichButton) = dialog.getActionButton(which = which)

    /**
     * @see [MaterialDialog.setActionButtonEnabled]
     */
    fun setActionButtonEnabled(
        dialog: MaterialDialog,
        which: WhichButton,
        enabled: Boolean
    ) = apply { dialog.setActionButtonEnabled(which = which, enabled = enabled) }
    //endregion

    //region callbacks
    /**
     * @see [MaterialDialog.onPreShow]
     */
    fun onPreShow(callback: Consumer<MaterialDialog>) = apply {
        dialog.onPreShow(callback = callback.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.onShow]
     */
    fun onShow(callback: Consumer<MaterialDialog>) = apply {
        dialog.onShow(callback = callback.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.onDismiss]
     */
    fun onDismiss(callback: Consumer<MaterialDialog>) = apply {
        dialog.onDismiss(callback = callback.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.onCancel]
     */
    fun onCancel(callback: Consumer<MaterialDialog>) = apply {
        dialog.onCancel(callback = callback.asKotlinFunction())
    }
    //endregion

    //region custom view
    /**
     * @see [MaterialDialog.getCustomView]
     */
    fun getCustomView() = dialog.getCustomView()

    /**
     * @see [MaterialDialog.customView]
     */
    fun customView(options: CustomViewOptions) = apply {
        dialog.customView(viewRes = options.viewRes,
            view = options.view,
            scrollable = options.scrollable,
            noVerticalPadding = options.noVerticalPadding,
            horizontalPadding = options.horizontalPadding,
            dialogWrapContent = options.dialogWrapContent)
    }
    //endregion

    //region list
    /**
     * @see [MaterialDialog.getRecyclerView]
     */
    fun getRecyclerView() = dialog.getRecyclerView()

    /**
     * @see [MaterialDialog.getListAdapter]
     */
    fun getListAdapter() = dialog.getListAdapter()

    /**
     * @see [MaterialDialog.customListAdapter]
     */
    @JvmOverloads
    fun customListAdapter(adapter: RecyclerView.Adapter<*>,
                          layoutManager: RecyclerView.LayoutManager? = null) = apply {
        dialog.customListAdapter(adapter = adapter, layoutManager = layoutManager)
    }

    /**
     * @see [MaterialDialog.listItems]
     */
    @SuppressLint("CheckResult")
    fun listItems(options: ListItemOptions) = apply {
        dialog.listItems(res = options.res,
            items = options.items,
            disabledIndices = options.disabledIndices,
            waitForPositiveButton = options.waitForPositiveButton,
            selection = options.selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.updateListItems]
     */
    @JvmOverloads
    fun updateListItems(@ArrayRes res: Int,
                        disabledIndices: IntArray? = null,
                        selection: RealItemListener? = null) = apply {
        dialog.updateListItems(res = res,
            disabledIndices = disabledIndices,
            selection = selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.updateListItems]
     */
    @JvmOverloads
    fun updateListItems(items: List<CharSequence>,
                        disabledIndices: IntArray? = null,
                        selection: RealItemListener? = null) = apply {
        dialog.updateListItems(items = items,
            disabledIndices = disabledIndices,
            selection = selection?.asKotlinFunction())
    }
    //endregion

    //region multi choice
    /**
     * @see [MaterialDialog.listItemsMultiChoice]
     */
    @SuppressLint("CheckResult")
    fun listItemsMultiChoice(options: ListItemMultiChoiceOptions) = apply {
        dialog.listItemsMultiChoice(res = options.res,
            items = options.items,
            disabledIndices = options.disabledIndices,
            initialSelection = options.initialSelection,
            waitForPositiveButton = options.waitForPositiveButton,
            allowEmptySelection = options.allowEmptySelection,
            selection = options.selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.updateListItemsMultiChoice]
     */
    @JvmOverloads
    fun updateListItemsMultiChoice(@ArrayRes res: Int,
                                   disabledIndices: IntArray? = null,
                                   selection: RealMultiChoiceListener? = null) = apply {
        dialog.updateListItemsMultiChoice(res = res,
            disabledIndices = disabledIndices,
            selection = selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.updateListItemsMultiChoice]
     */
    @JvmOverloads
    fun updateListItemsMultiChoice(items: List<CharSequence>,
                                   disabledIndices: IntArray? = null,
                                   selection: RealMultiChoiceListener? = null) = apply {
        dialog.updateListItemsMultiChoice(items = items,
            disabledIndices = disabledIndices,
            selection = selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.checkItems]
     */
    fun checkItems(indices: IntArray) = apply {
        dialog.checkItems(indices = indices)
    }

    /**
     * @see [MaterialDialog.uncheckItems]
     */
    fun uncheckItems(indices: IntArray) = apply {
        dialog.uncheckItems(indices = indices)
    }

    /**
     * @see [MaterialDialog.toggleItemsChecked]
     */
    fun toggleItemsChecked(indices: IntArray) = apply {
        dialog.toggleItemsChecked(indices = indices)
    }

    /**
     * @see [MaterialDialog.checkAllItems]
     */
    fun checkAllItems() = apply { dialog.checkAllItems() }

    /**
     * @see [MaterialDialog.uncheckAllItems]
     */
    fun uncheckAllItems() = apply { dialog.uncheckAllItems() }

    /**
     * @see [MaterialDialog.toggleAllItemsChecked]
     */
    fun toggleAllItemsChecked() = apply { dialog.toggleAllItemsChecked() }
    //endregion

    //region single choice
    /**
     * @see [MaterialDialog.listItemsSingleChoice]
     */
    @SuppressLint("CheckResult")
    fun listItemsSingleChoice(options: ListItemSingleChoiceOptions) = apply {
        dialog.listItemsSingleChoice(res = options.res,
            items = options.items,
            disabledIndices = options.disabledIndices,
            initialSelection = options.initialSelection,
            waitForPositiveButton = options.waitForPositiveButton,
            checkedColor = options.checkedColor,
            uncheckedColor = options.uncheckedColor,
            selection = options.selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.updateListItemsSingleChoice]
     */
    @JvmOverloads
    fun updateListItemsSingleChoice(@ArrayRes res: Int,
                                    disabledIndices: IntArray? = null,
                                    selection: RealSingleChoiceListener? = null) = apply {
        dialog.updateListItemsSingleChoice(res = res,
            disabledIndices = disabledIndices,
            selection = selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.updateListItemsSingleChoice]
     */
    @JvmOverloads
    fun updateListItemsSingleChoice(items: List<CharSequence>,
                                    disabledIndices: IntArray? = null,
                                    selection: RealSingleChoiceListener? = null) = apply {
        dialog.updateListItemsSingleChoice(items = items,
            disabledIndices = disabledIndices,
            selection = selection?.asKotlinFunction())
    }

    /**
     * @see [MaterialDialog.checkItem]
     */
    fun checkItem(index: Int) = apply { dialog.checkItem(index = index) }

    /**
     * @see [MaterialDialog.uncheckItem]
     */
    fun uncheckItem(index: Int) = apply { dialog.uncheckItem(index = index) }

    /**
     * @see [MaterialDialog.toggleItemChecked]
     */
    fun toggleItemChecked(index: Int) = apply { dialog.toggleItemChecked(index = index) }

    /**
     * @see [MaterialDialog.isItemChecked]
     */
    fun isItemChecked(index: Int) = apply { dialog.isItemChecked(index = index) }
    //endregion
}
