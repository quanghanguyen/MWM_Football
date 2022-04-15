package com.example.mwmfootball.adapter.L1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.R
import com.example.mwmfootball.databinding.ListChartL1Binding
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.model.Chart.Table

class L1ChartRecyclerAdapter : RecyclerView.Adapter<L1ChartRecyclerAdapter.MyViewHolder>() {

    var lstL1Chart = ArrayList<Table>()

    fun getL1ListChart(l1ChartData : ArrayList<Table>) {
        this.lstL1Chart = l1ChartData
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private var lstL1ChartData = ListChartL1Binding.bind(view)

        fun bind(lstL1Chart : Table){
            with(lstL1ChartData){
                tvDL1.text = lstL1Chart.draw.toString()
                tvLL1.text = lstL1Chart.lost.toString()
                tvNameTeamL1.text = lstL1Chart.team.name
                tvPL1.text = lstL1Chart.points.toString()
                tvWL1.text = lstL1Chart.won.toString()
                tvPositionL1.text = lstL1Chart.position.toString()

                Glide.with(civTeamIconL1)
                    .load(lstL1Chart.team.crestUrl)
                    .into(civTeamIconL1)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_chart_l1, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstL1Chart[position])
    }

    override fun getItemCount(): Int {
        return lstL1Chart.size
    }
}