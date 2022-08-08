package com.erjan.tzandroid.presentation.ui.fragments.home

import com.erjan.domain.usecases.FetchCandidatesUseCase
import com.erjan.tzandroid.presentation.base.BaseViewModel
import com.erjan.tzandroid.presentation.models.CandidateItemUI
import com.erjan.tzandroid.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchCandidatesUseCase: FetchCandidatesUseCase) :
    BaseViewModel() {

    private val _candidatesState = mutableUIStateFlow<List<CandidateItemUI>>()
    val candidatesState = _candidatesState.asStateFlow()

    init {
        fetchCandidates()
    }

    private fun fetchCandidates() {
        fetchCandidatesUseCase().collectRequest(_candidatesState) { it.map { it.toUI() } }
    }
}