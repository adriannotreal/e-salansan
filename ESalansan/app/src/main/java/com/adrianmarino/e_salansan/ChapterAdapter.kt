package com.adrianmarino.e_salansan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chapter_title.view.*

class ChapterAdapter (
    var chapters: List<Chapter>, private val onChapterClickListener: OnChapterClickListener
) : RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>(){
    inner class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chapter_title, parent, false)
        return ChapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.itemView.apply {
            ChapterTitle.text = chapters[position].title
        }
        holder.itemView.setOnClickListener {
            onChapterClickListener.onChapterClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return chapters.size
    }
}