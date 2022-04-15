package com.example.mwmfootball.adapter.L1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.databinding.ListTeamsL1Binding
import com.example.mwmfootball.databinding.ListTeamsPlBinding
import com.example.mwmfootball.model.Teams.Team

class L1TeamsRecyclerAdapter : RecyclerView.Adapter<L1TeamsRecyclerAdapter.MyViewHolder>() {

    var lstL1Teams = ArrayList<Team>()
    fun getlstL1Teams(data : ArrayList<Team>) {
        this.lstL1Teams = data
    }

    class MyViewHolder(val l1TeamsPlBinding: ListTeamsL1Binding) : RecyclerView.ViewHolder(l1TeamsPlBinding.root) {
        fun bind(data : Team) {
            with(l1TeamsPlBinding) {
                tvTeamsL1.text = data.name
                Glide.with(civTeamsL1)
                    .load(data.crestUrl)
                    .into(civTeamsL1)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val l1TeamsPlBinding = ListTeamsL1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder : MyViewHolder = MyViewHolder(l1TeamsPlBinding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstL1Teams[position])
    }

    override fun getItemCount(): Int {
        return lstL1Teams.size
    }
}