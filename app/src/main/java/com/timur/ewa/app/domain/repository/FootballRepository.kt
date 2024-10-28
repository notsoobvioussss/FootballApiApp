package com.timur.ewa.app.domain.repository

import com.timur.ewa.app.data.model.TopScorer


interface FootballRepository {
    suspend fun getTopScorers(leagueId: Int): List<TopScorer>?
}
