package com.example.mwmfootball.adapter.PL

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.R
import com.example.mwmfootball.databinding.DialogPlBinding
import com.example.mwmfootball.databinding.ListTeamsPlBinding
import com.example.mwmfootball.model.Teams.Team

// lateinit var plDialog : DialogPlBinding

class PLTeamsRecyclerAdapter : RecyclerView.Adapter<PLTeamsRecyclerAdapter.MyViewHolder>() {

    var lstTeams = ArrayList<Team>()
    private lateinit var dialog : Dialog

    fun getlstTeams(data : ArrayList<Team>) {
        this.lstTeams = data
    }

    class MyViewHolder(val plTeamsBinding : ListTeamsPlBinding) : RecyclerView.ViewHolder(plTeamsBinding.root) {
        //private var rcvBinding = ListTeamsPlBinding.bind(plTeamsBinding)

        fun bind(data : Team) {
            with(plTeamsBinding){
                tvTeams.text = data.name
                Glide.with(civTeams)
                    .load(data.crestUrl)
                    .into(civTeams)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_teams_pl, parent, false)
        val plTeamsBinding = ListTeamsPlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val plDialog = DialogPlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder : MyViewHolder = MyViewHolder(plTeamsBinding)
        //Dialog
        //val plItems = plTeamsBinding.rlitemTeams


        dialog = Dialog(parent.context)
        dialog.setContentView(R.layout.dialog_pl)
        viewHolder.plTeamsBinding.rlitemTeams.setOnClickListener {

            plDialog.tvNameDetails.text = lstTeams[viewHolder.absoluteAdapterPosition].name
            plDialog.tvShortNameDetails.text = lstTeams[viewHolder.absoluteAdapterPosition].shortName
            plDialog.tvTLADetails.text = lstTeams[viewHolder.absoluteAdapterPosition].tla
            plDialog.tvAddressDetails.text = lstTeams[viewHolder.absoluteAdapterPosition].address
            plDialog.tvPhoneDetails.text = lstTeams[viewHolder.absoluteAdapterPosition].phone
            plDialog.tvWebsiteDetails.text = lstTeams[viewHolder.absoluteAdapterPosition].website
            plDialog.tvEmailDetails.text = lstTeams[viewHolder.absoluteAdapterPosition].email
            plDialog.tvFoundedDetails.text = lstTeams[viewHolder.absoluteAdapterPosition].founded.toString()
            plDialog.tvVenueDetails.text = lstTeams[viewHolder.absoluteAdapterPosition].venue

            dialog.show()
        }


        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstTeams[position])
    }

    override fun getItemCount(): Int {
        return lstTeams.size
    }
}