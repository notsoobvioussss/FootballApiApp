package com.timur.ewa.app.presentation.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.timur.ewa.app.R
import com.timur.ewa.app.databinding.FragmentPlayerListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlayerListFragment : Fragment(R.layout.fragment_player_list) {
    private val viewModel: PlayerListViewModel by viewModel()
    private lateinit var binding: FragmentPlayerListBinding
    private lateinit var adapter: PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewPlayers.layoutManager = LinearLayoutManager(requireContext())

        adapter = PlayerAdapter { topScorer ->
            val bundle = Bundle().apply {
                putParcelable("topScorer", topScorer)
            }
            findNavController().navigate(R.id.playerDetailsFragment, bundle)
        }

        binding.recyclerViewPlayers.adapter = adapter

        val leagueIds = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var currentLeagueIndex = 0

        val loadMore = {
            if (currentLeagueIndex < leagueIds.size) {
                val leagueId = leagueIds[currentLeagueIndex]
                viewModel.loadTopScorers(leagueId)
                currentLeagueIndex++
                setupObservers()
            }
        }

        binding.recyclerViewPlayers.addOnScrollListener(EndlessRecyclerViewScrollListener(binding.recyclerViewPlayers.layoutManager as LinearLayoutManager, loadMore))
        loadMore()
    }

    private fun setupObservers() {
        viewModel.topScorers.observe(viewLifecycleOwner) { scorers ->
            if (scorers != null) {
                adapter.submitList(scorers)
            }
        }

    }
}
