package com.rickclephas.kmp.nativecoroutines.sample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class IntegrationTests {

    private val job = SupervisorJob()
    internal val coroutineScope = CoroutineScope(job + Dispatchers.Default)

    val activeJobCount: Int
        get() = job.children.count { it.isActive }

    val uncompletedJobCount: Int
        get() = job.children.count { !it.isCompleted }

    init {
        freeze()
    }
}