package com.timur.ewa.app.data.repository

import com.timur.ewa.app.data.api.FootballApi
import com.timur.ewa.app.data.model.TopScorer
import com.timur.ewa.app.domain.repository.FootballRepository

class FootballRepositoryImpl(private val api: FootballApi) : FootballRepository {
    val apiKey = "pur_your_api_key"

    override suspend fun getTopScorers(leagueId: Int): List<TopScorer>? {
        val response = api.getTopScorers(leagueId, apiKey)
        return if (response.isSuccessful) {
            response.body()?.api?.topscorers
        } else {
            null
        }
    }

}

