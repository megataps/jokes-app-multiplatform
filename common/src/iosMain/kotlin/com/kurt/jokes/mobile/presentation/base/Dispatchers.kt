package com.kurt.jokes.mobile.presentation.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext

actual val mainDispatcher: CoroutineDispatcher = IosMainDispatcher
actual val ioDispatcher: CoroutineDispatcher = IosMainDispatcher

private object IosMainDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) { block.run() }
    }
}