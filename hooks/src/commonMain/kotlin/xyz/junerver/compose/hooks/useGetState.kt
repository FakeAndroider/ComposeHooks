package xyz.junerver.compose.hooks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

/*
  Description: Better `useState`
  Author: Junerver
  Date: 2024/5/10-9:31
  Email: junerver@gmail.com
  Version: v1.0
*/

/**
 * Description: Using destructuring declarations on [useState] can cause
 * closure problems. Using [useLatestRef] is a solution, but if you call
 * the set function quickly(millisecond level), there will be a problem of
 * state loss.
 *
 * Now you can use [useGetState] to solve these problems and get the latest
 * value through `getter` to avoid closure problems. The `setter` function
 * also supports fast update.
 */
@Composable
fun <T> useGetState(default: T & Any): Triple<T, SetValueFn<T & Any>, GetValueFn<T>> {
    var state: T & Any by useState(default)
    return Triple(
        first = state, // state
        second = { state = it }, // setter
        third = { state } // getter
    )
}

/**
 * A nullable version of [useGetState]
 *
 * @param default
 * @param T
 * @return
 */
@Composable
fun <T> _useGetState(default: T): Triple<T, SetValueFn<T>, GetValueFn<T>> {
    var state: T by _useState(default)
    return Triple(
        first = state,
        second = { state = it },
        third = { state }
    )
}
