package com.timur.ewa.app.presentation.ui.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timur.ewa.app.data.model.TopScorer
import com.timur.ewa.app.domain.usecase.GetTopScorersUseCase
import kotlinx.coroutines.launch

class PlayerListViewModel(private val getTopScorersUseCase: GetTopScorersUseCase) : ViewModel() {
    private val _topScorers = MutableLiveData<List<TopScorer>?>()
    val topScorers: LiveData<List<TopScorer>?> get() = _topScorers

    fun loadTopScorers(leagueId: Int) {
        viewModelScope.launch {
            val scorers = getTopScorersUseCase.execute(leagueId)
            _topScorers.value = scorers
        }
    }

}
