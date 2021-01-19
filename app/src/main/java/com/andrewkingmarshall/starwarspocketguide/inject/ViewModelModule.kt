package com.andrewkingmarshall.starwarspocketguide.inject

import android.content.Context
import com.andrewkingmarshall.starwarspocketguide.viewmodels.SearchViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class ViewModelModule {

    @Provides
    fun provideSearchViewModel(
        @ApplicationContext context: Context
    ): SearchViewModel {
        return SearchViewModel(
            context
        )
    }

}