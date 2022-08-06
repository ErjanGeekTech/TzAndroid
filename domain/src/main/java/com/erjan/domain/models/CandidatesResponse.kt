package com.erjan.domain.models

class CandidateItem(
    val firstName: String,
    val photo: String,
    val secondName: String,
    val education: Int,
    val company: List<CompanyItem>

)

class CompanyItem(
    val name: String,
    val position: String
)