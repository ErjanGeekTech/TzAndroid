package com.erjan.tzandroid.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.erjan.tzandroid.databinding.ItemCompanyBinding
import com.erjan.tzandroid.presentation.base.BaseDiffUtilItemCallback
import com.erjan.tzandroid.presentation.models.CompanyItemUI

class CompanyAdapter :
    ListAdapter<CompanyItemUI, CompanyAdapter.CompanyViewHolder>(BaseDiffUtilItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompanyViewHolder(
        ItemCompanyBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class CompanyViewHolder(private val binding: ItemCompanyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: CompanyItemUI) {
            binding.nameTxt.text = data.id
            binding.positionTxt.text = data.position

        }
    }
}