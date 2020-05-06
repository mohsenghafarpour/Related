package com.karafs.related.di

import com.karafs.related.ui.user.UserAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { UserAdapter() }
}