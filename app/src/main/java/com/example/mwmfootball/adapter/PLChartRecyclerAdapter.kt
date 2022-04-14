package com.example.mwmfootball.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.R
import com.example.mwmfootball.databinding.ListChartPlBinding
import com.example.mwmfootball.model.Chart.Table

class PLChartRecyclerAdapter : RecyclerView.Adapter<PLChartRecyclerAdapter.MyViewHolder>() {

    var lstChart = ArrayList<Table>()

    fun getlstChart(chartData : ArrayList<Table>) {
        this.lstChart = chartData
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var lstChartPL = ListChartPlBinding.bind(view)

        fun bind(plChartData : Table){
            with(lstChartPL){
                tvD.text = plChartData.draw.toString()
                tvL.text = plChartData.lost.toString()
                tvNameTeam.text = plChartData.team.name
                tvP.text = plChartData.points.toString()
                tvW.text = plChartData.won.toString()
                tvPosition.text = plChartData.points.toString()

                Glide.with(civTeamIcon)
                    .load(plChartData.team.crestUrl)
                    .into(civTeamIcon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_chart_pl, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstChart[position])
    }

    override fun getItemCount(): Int {

        return lstChart.size

    }
}