package com.devkazonovic.projects.mytasks.presentation.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devkazonovic.projects.mytasks.R
import com.devkazonovic.projects.mytasks.databinding.CardTaskListBinding
import com.devkazonovic.projects.mytasks.domain.model.Category
import com.devkazonovic.projects.mytasks.presentation.tasks.adapter.ListsDiffCallback

class TaskListsMenuAdapter(
    private var _listID: Long? = null,
    diffCallback: ListsDiffCallback,
    private val onClick: (list: Category) -> Unit
) : ListAdapter<Category, TaskListsMenuAdapter.ListViewHolder>(diffCallback) {


    class ListViewHolder(
        private val listID: Long? = null,
        private val binding: CardTaskListBinding,
        private val onClick: (list: Category) -> Unit

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(list: Category) {
            binding.textViewListName.text = list.name
            if (listID == list.id) {
                binding.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.teal_200
                    )
                )
            }
            binding.root.setOnClickListener {
                onClick(list)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            CardTaskListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(_listID, binding) {
            onClick(it)
        }
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}
