package com.timur.ewa.app.presentation.ui.playerdetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.timur.ewa.app.R
import com.timur.ewa.app.data.model.TopScorer
import com.timur.ewa.app.databinding.FragmentPlayerDetailsBinding
import com.timur.ewa.app.presentation.utils.ImageLoader

class PlayerDetailsFragment : Fragment(R.layout.fragment_player_details) {
    private lateinit var binding: FragmentPlayerDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPlayerDetailsBinding.bind(view)

        val topScorer = arguments?.getParcelable<TopScorer>("topScorer")

        topScorer?.let {
            displayPlayerDetails(it)
        }
    }

    private fun displayPlayerDetails(topScorer: TopScorer) {
        binding.textViewPlayerName.text = topScorer.player_name
        binding.textViewPlayerPosition.text = topScorer.position
        binding.textViewTeamName.text = topScorer.team_name
        binding.textViewNationality.text = topScorer.nationality
        binding.textViewGames.text = "Appearances: ${topScorer.games.appearences}, Minutes played: ${topScorer.games.minutes_played}"
        binding.textViewGoals.text = "Goals: ${topScorer.goals.total}, Assists: ${topScorer.goals.assists}"
        binding.textViewShots.text = "Shots: ${topScorer.shots.total}, On target: ${topScorer.shots.on}"
        binding.textViewPenalties.text = "Penalties won: ${topScorer.penalty.won}, Success: ${topScorer.penalty.success}"
        binding.textViewCards.text = "Yellow: ${topScorer.cards.yellow}, Red: ${topScorer.cards.red}"
        val playerPhotoUrl = "https://media.api-sports.io/football/players/${topScorer.player_id}.png"
        ImageLoader.loadImage(binding.imageViewPlayerPhoto, playerPhotoUrl)
    }

}
