package com.example.mwmfootball.adapter.SA

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.databinding.ListTeamsSaBinding
import com.example.mwmfootball.model.Teams.Team

class SATeamsRecyclerAdapter : RecyclerView.Adapter<SATeamsRecyclerAdapter.MyViewHolder>() {

    var lstSATeams = ArrayList<Team>()

    fun getlstSATeams(saTeamsData : ArrayList<Team>) {
        this.lstSATeams = saTeamsData
    }

    class MyViewHolder(private val saTeamsBinding : ListTeamsSaBinding) : RecyclerView.ViewHolder(saTeamsBinding.root) {
        fun bind(saTeamsData: Team) {
            with(saTeamsBinding) {
                tvTeamsSA.text = saTeamsData.name

                Glide.with(civTeamsSA)
                    .load(saTeamsData.crestUrl)
                    .into(civTeamsSA)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val saTeamsBinding = ListTeamsSaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder : MyViewHolder = MyViewHolder(saTeamsBinding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstSATeams[position])
    }

    override fun getItemCount(): Int {
        return lstSATeams.size
    }
}