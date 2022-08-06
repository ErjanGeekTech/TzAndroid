package com.erjan.tzandroid.presentation.models

import com.erjan.domain.models.CandidateItem
import com.erjan.domain.models.CompanyItem
import com.erjan.tzandroid.presentation.base.IBaseDiffModel

data class CandidateItemUI(
    override val id: String,
    val photo: String,
    val secondName: String,
    val education: Int,
    val company: List<CompanyItemUI>
) : IBaseDiffModel<String>

data class CompanyItemUI(
    override val id: String,
    val position: String
) : IBaseDiffModel<String>

fun CandidateItem.toUI() =
    CandidateItemUI(firstName, photo, secondName, education, company.map { it.toUI() })

fun CompanyItem.toUI() = CompanyItemUI(name, position)