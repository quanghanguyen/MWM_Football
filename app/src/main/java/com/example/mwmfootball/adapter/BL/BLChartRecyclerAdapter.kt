package com.example.mwmfootball.adapter.BL

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.R
import com.example.mwmfootball.databinding.ListChartBlBinding
import com.example.mwmfootball.model.Chart.Table

class BLChartRecyclerAdapter : RecyclerView.Adapter<BLChartRecyclerAdapter.MyViewHolder>() {

    private var lstBLChart = ArrayList<Table>()

    fun getBLListChart(listBLChart: ArrayList<Table>) {
        this.lstBLChart = listBLChart
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private var lstBlChartBinding = ListChartBlBinding.bind(view)

        fun bind(lstBLChartData : Table){
            with(lstBlChartBinding){
                //tvPositionBL.text = lstBLChartData.position.toString()
                tvDBL.text = lstBLChartData.draw.toString()
                tvLBL.text = lstBLChartData.lost.toString()
                tvNameTeamBL.text = lstBLChartData.team.name
                tvPBL.text = lstBLChartData.points.toString()
                tvWBL.text = lstBLChartData.won.toString()
                tvPositionBL.text = lstBLChartData.position.toString()

                Glide.with(civTeamIconBL)
                    .load(lstBLChartData.team.crestUrl)
                    .into(civTeamIconBL)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_chart_bl, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstBLChart[position])
    }

    override fun getItemCount(): Int {
        return lstBLChart.size
    }
}