package com.erjan.domain.usecases

import com.erjan.domain.repositories.CandidateRepository
import javax.inject.Inject

class FetchCandidatesUseCase @Inject constructor(private val repository: CandidateRepository) {

    operator fun invoke() = repository.fetchCandidates()
}