package com.timur.ewa.app.presentation.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.timur.ewa.app.databinding.FragmentThemeBinding
import com.timur.ewa.app.presentation.utils.ThemeManager

class ThemeFragment : Fragment() {

    private var _binding: FragmentThemeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThemeBinding.inflate(inflater, container, false)
        val view = binding.root

        val currentTheme = ThemeManager.loadTheme(requireContext())
        binding.themeSwitch.isChecked = currentTheme == ThemeManager.DARK_THEME

        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                ThemeManager.saveTheme(requireContext(), ThemeManager.DARK_THEME)
                ThemeManager.applyTheme(ThemeManager.DARK_THEME)
            } else {
                ThemeManager.saveTheme(requireContext(), ThemeManager.LIGHT_THEME)
                ThemeManager.applyTheme(ThemeManager.LIGHT_THEME)
            }
            requireActivity().recreate()
        }

        binding.textViewPrivacyPolicy.setOnClickListener {
            binding.scrollViewPrivacyPolicy.visibility =
                if (binding.scrollViewPrivacyPolicy.visibility == View.GONE) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            if(binding.scrollViewPrivacyPolicy.visibility == View.VISIBLE){
                binding.textViewPolicyContent.visibility = View.VISIBLE
            }else{
                binding.textViewPolicyContent.visibility = View.GONE
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}