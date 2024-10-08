package xyz.junerver.compose.hooks

import androidx.compose.runtime.Composable

/*
  Description: Hook that saves the previous state.
  Author: Junerver
  Date: 2024/2/1-14:55
  Email: junerver@gmail.com
  Version: v1.0
*/

@Composable
fun <T> usePrevious(present: T): T? {
    val (state, set) = useUndo(initialPresent = present)
    useEffect(present) {
        set(present)
    }
    return state.past.lastOrNull()
}
