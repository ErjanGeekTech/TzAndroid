package com.erjan.domain.repositories

import com.erjan.domain.Either
import com.erjan.domain.models.CandidateItem
import kotlinx.coroutines.flow.Flow
import java.awt.Cursor

interface CandidateRepository {

    fun fetchCandidates(): Flow<Either<String, List<CandidateItem>>>
}