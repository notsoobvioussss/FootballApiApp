package com.timur.ewa.app.di

import com.timur.ewa.app.data.api.FootballApi
import com.timur.ewa.app.data.repository.FootballRepositoryImpl
import com.timur.ewa.app.domain.repository.FootballRepository
import com.timur.ewa.app.domain.usecase.GetTopScorersUseCase
import com.timur.ewa.app.presentation.ui.player.PlayerListViewModel
import com.timur.ewa.app.presentation.ui.playerdetails.PlayerDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballApi::class.java)
    }

    // Repository
    single<FootballRepository> { FootballRepositoryImpl(get()) }

    // UseCase
    factory { GetTopScorersUseCase(get()) }

    // ViewModels
    viewModel { PlayerListViewModel(get()) }
    viewModel { PlayerDetailsViewModel() }
}