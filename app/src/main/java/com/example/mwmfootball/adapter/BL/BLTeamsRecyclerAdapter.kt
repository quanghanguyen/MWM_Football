package com.example.mwmfootball.adapter.BL

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.databinding.ListTeamsBlBinding
import com.example.mwmfootball.model.Teams.Team

class BLTeamsRecyclerAdapter : RecyclerView.Adapter<BLTeamsRecyclerAdapter.MyViewHolder>() {

    private var lstTeamsBL = ArrayList<Team>()
    fun getListBLTeams(data : ArrayList<Team>){
        this.lstTeamsBL = data
    }

    class MyViewHolder(private val listTeamsBlBinding: ListTeamsBlBinding) : RecyclerView.ViewHolder(listTeamsBlBinding.root) {
        fun bind(blTeamsData : Team) {
            with(listTeamsBlBinding){
                tvTeamsBL.text = blTeamsData.name
                //Glide
                Glide.with(civTeamsBL)
                    .load(blTeamsData.crestUrl)
                    .into(civTeamsBL)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var listTeamsBlBinding = ListTeamsBlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder : MyViewHolder = MyViewHolder(listTeamsBlBinding)

        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstTeamsBL[position])
    }

    override fun getItemCount(): Int {
        return lstTeamsBL.size
    }
}