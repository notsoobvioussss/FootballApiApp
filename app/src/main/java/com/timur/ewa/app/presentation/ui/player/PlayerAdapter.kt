package com.timur.ewa.app.presentation.ui.player

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timur.ewa.app.databinding.ItemPlayerBinding
import com.timur.ewa.app.data.model.TopScorer
import com.timur.ewa.app.presentation.utils.ImageLoader

class PlayerAdapter(
    private val topScorers: List<TopScorer> = emptyList(),
    private val onTopScorerClick: (TopScorer) -> Unit
) : RecyclerView.Adapter<TopScorerViewHolder>() {

    private var topScorerList: List<TopScorer> = topScorers

    fun submitList(newTopScorers: List<TopScorer>) {
        topScorerList = topScorerList + newTopScorers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScorerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopScorerViewHolder(binding, onTopScorerClick)
    }

    override fun onBindViewHolder(holder: TopScorerViewHolder, position: Int) {
        holder.bind(topScorerList[position])
    }

    override fun getItemCount(): Int = topScorerList.size
}

class TopScorerViewHolder(
    private val binding: ItemPlayerBinding,
    private val onTopScorerClick: (TopScorer) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(topScorer: TopScorer) {
        binding.textViewPlayerName.text = topScorer.player_name
        binding.textViewPlayerInfo.text = topScorer.position
        binding.textViewPlayerComand.text = topScorer.team_name
        val playerPhotoUrl = "https://media.api-sports.io/football/players/${topScorer.player_id}.png"
        ImageLoader.loadImage(binding.imageViewPlayerPhoto, playerPhotoUrl)
        binding.root.setOnClickListener {
            onTopScorerClick(topScorer)
        }
    }
}
