package com.timur.ewa.app.presentation.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timur.ewa.app.data.model.FootballTeam
import com.timur.ewa.app.databinding.ItemTeamBinding
import com.timur.ewa.app.presentation.utils.ImageLoader

class TeamsAdapter(private val teams: List<FootballTeam>, private val onItemClick: (FootballTeam) -> Unit) :
    RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(team: FootballTeam) {
            binding.textViewTeamName.text = team.name
            ImageLoader.loadImage(binding.imageViewTeamLogo, team.logoUrl)

            itemView.setOnClickListener {
                onItemClick(team)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount() = teams.size
}
