package com.example.mwmfootball.adapter.SA

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwmfootball.R
import com.example.mwmfootball.databinding.ListChartSaBinding
import com.example.mwmfootball.model.Chart.Table

class SAChartRecyclerAdapter : RecyclerView.Adapter<SAChartRecyclerAdapter.MyViewHolder>() {

    private var lstSAChart = ArrayList<Table>()

    fun getListSAChart(saChartData : ArrayList<Table>) {
        this.lstSAChart = saChartData
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){

        private var lstChartSA = ListChartSaBinding.bind(view)

        fun bind(saChartData: Table) {
            with(lstChartSA) {
                tvDSA.text = saChartData.draw.toString()
                tvLSA.text = saChartData.lost.toString()
                tvNameTeamSA.text = saChartData.team.name
                tvPSA.text = saChartData.points.toString()
                tvWSA.text = saChartData.won.toString()
                tvPositionSA.text = saChartData.position.toString()

                Glide.with(civTeamIconSA)
                    .load(saChartData.team.crestUrl)
                    .into(civTeamIconSA)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_chart_sa, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lstSAChart[position])
    }

    override fun getItemCount(): Int {
        return lstSAChart.size
    }
}