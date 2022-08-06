package com.erjan.tzandroid.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.erjan.tzandroid.databinding.ItemCandidateBinding
import com.erjan.tzandroid.presentation.base.BaseDiffUtilItemCallback
import com.erjan.tzandroid.presentation.extensions.load
import com.erjan.tzandroid.presentation.models.CandidateItemUI

class CandidateAdapter :
    ListAdapter<CandidateItemUI, CandidateAdapter.CandidateViewHolder>(BaseDiffUtilItemCallback()) {

    inner class CandidateViewHolder(private val binding: ItemCandidateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val companyAdapter = CompanyAdapter()

        fun bind(data: CandidateItemUI) {
            binding.nameTxt.text = data.id
            binding.profileLogo.load(data.photo)
            binding.educationTxt.text = setupEducation(data.education)
            companyAdapter.submitList(data.company)
            binding.recyclerCompany.adapter = companyAdapter
        }

        private fun setupEducation(education: Int) =
            when (education) {
                2 -> {
                    "bachelor"
                }
                3 -> {
                    "master"
                }
                4 -> {
                    "doctoral"
                }
                else -> {
                    "high school"
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CandidateViewHolder(
            ItemCandidateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}