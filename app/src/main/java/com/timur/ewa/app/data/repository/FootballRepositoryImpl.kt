package com.timur.ewa.app.data.repository

import com.timur.ewa.app.data.api.FootballApi
import com.timur.ewa.app.data.model.TopScorer
import com.timur.ewa.app.domain.repository.FootballRepository

class FootballRepositoryImpl(private val api: FootballApi) : FootballRepository {
    val apiKey = "1802eba2aamsh6d90ab045648085p164ad4jsn4468117101a5"

    override suspend fun getTopScorers(leagueId: Int): List<TopScorer>? {
        val response = api.getTopScorers(leagueId, apiKey)
        return if (response.isSuccessful) {
            response.body()?.api?.topscorers
        } else {
            null
        }
    }

}

