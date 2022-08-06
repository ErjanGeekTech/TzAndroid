package com.erjan.data.remote.dtos

import com.erjan.domain.models.CandidateItem
import com.erjan.domain.models.CompanyItem
import com.google.gson.annotations.SerializedName

class CandidatesResponseDto(
    @SerializedName("candidates")
    val candidates: List<CandidateItemDto>
)

class CandidateItemDto(
    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("photo")
    val photo: String,

    @SerializedName("second_name")
    val secondName: String,

    @SerializedName("education")
    val education: Int,

    @SerializedName("company")
    val company: List<CompanyItemDto>

)

class CompanyItemDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("position")
    val position: String
)

fun CandidateItemDto.toDomain() =
    CandidateItem(firstName, photo, secondName, education, company.map { it.toDomain() })

fun CompanyItemDto.toDomain() = CompanyItem(name, position)