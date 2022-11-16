package com.example.hammersystemspizza.di

import com.example.hammersystemspizza.presentation.MainActivity
import dagger.Subcomponent

@Subcomponent
interface MainActivityComponent {
    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }
}