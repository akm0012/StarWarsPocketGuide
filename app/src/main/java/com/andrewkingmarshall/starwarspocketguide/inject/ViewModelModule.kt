package com.andrewkingmarshall.starwarspocketguide.inject

import android.content.Context
import com.andrewkingmarshall.starwarspocketguide.repository.PeopleRepository
import com.andrewkingmarshall.starwarspocketguide.viewmodels.SearchViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class ViewModelModule {

//    @Provides
//    fun provideSearchViewModel(
//        @ApplicationContext context: Context,
//        peopleRepository: PeopleRepository,
//    ): SearchViewModel {
//        return SearchViewModel(
//            context,
//            peopleRepository,
//        )
//    }

}