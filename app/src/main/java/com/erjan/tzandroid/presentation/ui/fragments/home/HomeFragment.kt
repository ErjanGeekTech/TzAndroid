package com.erjan.tzandroid.presentation.ui.fragments.home

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.erjan.tzandroid.R
import com.erjan.tzandroid.databinding.FragmentHomeBinding
import com.erjan.tzandroid.presentation.base.BaseFragment
import com.erjan.tzandroid.presentation.ui.adapters.CandidateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val candidateAdapter = CandidateAdapter()

    override fun initialize() {
        binding.recyclerHome.adapter = candidateAdapter
    }

    override fun setupSubscribes() {
        subscribeToCandidates()
    }

    private fun subscribeToCandidates() {
        viewModel.candidatesState.collectUIState(
            onError = {
                Log.e("anime", it)
            },
            onSuccess = {
                Log.e("anime", it.toString())
                candidateAdapter.submitList(it)
            }
        )
    }
}