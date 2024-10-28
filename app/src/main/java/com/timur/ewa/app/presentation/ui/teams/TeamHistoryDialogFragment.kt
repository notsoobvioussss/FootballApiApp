package com.timur.ewa.app.presentation.ui.teams

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.timur.ewa.app.databinding.DialogTeamHistoryBinding
import com.timur.ewa.app.presentation.utils.ImageLoader

class TeamHistoryDialogFragment : DialogFragment() {

    private var _binding: DialogTeamHistoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_TEAM_NAME = "team_name"
        private const val ARG_TEAM_HISTORY = "team_history"
        private const val ARG_TEAM_LOGO = "team_logo"

        fun newInstance(teamName: String, teamHistory: String, teamLogo: String): TeamHistoryDialogFragment {
            val fragment = TeamHistoryDialogFragment()
            val args = Bundle()
            args.putString(ARG_TEAM_NAME, teamName)
            args.putString(ARG_TEAM_HISTORY, teamHistory)
            args.putString(ARG_TEAM_LOGO, teamLogo)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogTeamHistoryBinding.inflate(LayoutInflater.from(context))

        val teamName = arguments?.getString(ARG_TEAM_NAME)
        val teamHistory = arguments?.getString(ARG_TEAM_HISTORY)
        val teamLogo = arguments?.getString(ARG_TEAM_LOGO)

        binding.textViewTeamName.text = teamName
        binding.textViewTeamHistory.text = teamHistory

        if (teamLogo != null) {
            ImageLoader.loadImage(binding.imageViewTeamLogo, teamLogo)
        }

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setPositiveButton("OK") { _, _ -> dismiss() }
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
