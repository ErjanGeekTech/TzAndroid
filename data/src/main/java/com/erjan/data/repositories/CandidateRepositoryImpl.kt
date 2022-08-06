package com.erjan.data.repositories

import android.content.Context
import android.os.ParcelFileDescriptor.open
import android.system.Os.open
import com.erjan.data.R
import com.erjan.data.remote.dtos.CandidatesResponseDto
import com.erjan.data.remote.dtos.toDomain
import com.erjan.data.repositories.base.BaseRepository
import com.erjan.domain.Either
import com.erjan.domain.models.CandidateItem
import com.erjan.domain.repositories.CandidateRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.Pipe.open
import javax.inject.Inject

class CandidateRepositoryImpl @Inject constructor(private val context: Context) : BaseRepository(),
    CandidateRepository {

    override fun fetchCandidates(): Flow<Either<String, List<CandidateItem>>> =
        doRequest {
            Gson().fromJson(
                context.assets?.open("candidates.json")
                    ?.bufferedReader()
                    .use { it?.readText() },
                CandidatesResponseDto::class.java
            ).candidates.map { it.toDomain() }
        }
}