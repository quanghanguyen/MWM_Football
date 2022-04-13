package com.example.mwmfootball.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.R
import com.example.mwmfootball.databinding.FragmentPLTeamsBinding
import com.example.mwmfootball.databinding.ListTeamsPlBinding
import com.example.mwmfootball.model.Teams.Team

class PLTeamsRecyclerAdapter : RecyclerView.Adapter<PLTeamsRecyclerAdapter.MyViewHolder>() {

    var lstTeams = ArrayList<Team>()

    fun getlstTeams(data : ArrayList<Team>) {
        this.lstTeams = data
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private var rcvBinding = ListTeamsPlBinding.bind(view)

        fun bind(data : Team) {
            with(rcvBinding){
                tvTeams.text = data.name
                Glide.with(civTeams)
                    .load(data.crestUrl)
                    .into(civTeams)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_teams_pl, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstTeams[position])
    }

    override fun getItemCount(): Int {
        return lstTeams.size
    }
}