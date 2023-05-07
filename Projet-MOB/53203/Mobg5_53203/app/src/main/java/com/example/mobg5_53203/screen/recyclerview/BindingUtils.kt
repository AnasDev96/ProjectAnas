/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mobg5_53203.screen.recyclerview


import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Sets the text of the TextView to the specified item.
 *
 * @param item: the string to be set as the text of the TextView.
 */
@BindingAdapter("detailDescription")
fun TextView.setDetailDescription(item: String?) {
        text = item
}

/**
 * Sets the text of the TextView to the specified item.
 *
 * @param item: the string to be set as the text of the TextView.
 */
@BindingAdapter("detailNom")
fun TextView.setDetailNom(item: String?) {
        text = item
}

/**
 * Sets the text of the TextView to the specified item.
 *
 * @param item: the string to be set as the text of the TextView.
 */
@BindingAdapter("detailEmplacement")
fun TextView.setDetailEmplacement(item: String?) {
    text = item
}
/**
 * Sets the text of the TextView to the specified item.
 *
 * @param item: the string to be set as the text of the TextView.
 */
@BindingAdapter("detailAdresse")
fun TextView.setDetailAdresse(item: String?) {
    text = item
}


