package com.timur.ewa.app.domain.usecase

import com.timur.ewa.app.data.model.TopScorer
import com.timur.ewa.app.domain.repository.FootballRepository

class GetTopScorersUseCase(private val repository: FootballRepository) {
    suspend fun execute(leagueId: Int): List<TopScorer>? {
        return repository.getTopScorers(leagueId)
    }
}
