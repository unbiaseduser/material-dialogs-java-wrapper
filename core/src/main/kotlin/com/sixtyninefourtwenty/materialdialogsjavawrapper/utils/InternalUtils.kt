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

@file:JvmSynthetic
package com.sixtyninefourtwenty.materialdialogsjavawrapper.utils

import com.afollestad.materialdialogs.MaterialDialog
import com.sixtyninefourtwenty.materialdialogsjavawrapper.RealItemListener
import com.sixtyninefourtwenty.materialdialogsjavawrapper.RealMultiChoiceListener
import com.sixtyninefourtwenty.materialdialogsjavawrapper.RealSingleChoiceListener
import java.util.function.BiConsumer
import java.util.function.Consumer
import java.util.function.ObjIntConsumer
import java.util.function.Predicate

internal fun RealSingleChoiceListener.asKotlinFunction(): (MaterialDialog, Int, CharSequence) -> Unit = (this::accept)

internal fun RealMultiChoiceListener.asKotlinFunction(): (MaterialDialog, IntArray, List<CharSequence>) -> Unit = (this::accept)

internal fun RealItemListener.asKotlinFunction(): (MaterialDialog, Int, CharSequence) -> Unit = (this::accept)

fun <T> Predicate<T>.asKotlinFunction(): (T) -> Boolean = (this::test)

fun <T> Consumer<T>.asKotlinFunction() : Function1<T, Unit> = (this::accept)

fun <T> ObjIntConsumer<T>.asKotlinFunction(): (T, Int) -> Unit = (this::accept)

fun <T, U> BiConsumer<T, U>.asKotlinFunction(): (T, U) -> Unit = (this::accept)
