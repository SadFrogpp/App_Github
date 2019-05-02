package com.example.app_github.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.app_github.R
import com.example.app_github.model.MainModel
import org.jetbrains.anko.find
import java.util.ArrayList

typealias onClick = (url: String) -> Unit

class MainAdapter(val mainModel: ArrayList<MainModel>, val onClick: onClick) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_issue, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(mainModel[i])
        viewHolder.btInfo.setOnClickListener {
            onClick(mainModel[i].textUrl)
        }
    }

    override fun getItemCount() = mainModel.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle = itemView.findViewById<TextView>(R.id.text_title)
        val textUser = itemView.find<TextView>(R.id.text_user)
        val textDate = itemView.find<TextView>(R.id.text_date)
        val textComment = itemView.find<TextView>(R.id.text_comment)
        val btInfo = itemView.find<Button>(R.id.bt_info)
        fun bind(mainModel: MainModel) {
            textTitle.text = mainModel.textTitle
            textUser.text = mainModel.textUser
            textDate.text = mainModel.textDate.substring(0, 10)
            textComment.text = mainModel.textComment.toString()
        }
    }
}
