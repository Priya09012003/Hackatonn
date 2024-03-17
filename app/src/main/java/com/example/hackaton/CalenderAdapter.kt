package com.example.hackaton

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hackaton.databinding.DateItemBinding

class CalenderAdapter (
    private  val calenderInterface: CalendarInterface,
    private val list: ArrayList<calenderData>
        ) : RecyclerView.Adapter<CalenderAdapter.ViewHolder>(){

    var pos:Int=-1




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderAdapter.ViewHolder {
       val binding =DateItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalenderAdapter.ViewHolder, position: Int) {
     holder.bind(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: DateItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(calenderDataModel: calenderData,position: Int){
                val calenderDay =binding.tvCalenderDay
                val calendarDate=binding.tvCalenderDate
                val cardView=binding.root
                if(pos==position){
                    calenderDataModel.isSelected=true
                }

                if(calenderDataModel.isSelected){
                  pos =-1
                  calenderDay.setTextColor(
                      ContextCompat.getColor(itemView.context,R.color.white)
                  )
                    calendarDate.setTextColor(
                        ContextCompat.getColor(itemView.context,R.color.white)
                    )

                    cardView.setBackgroundColor(
                        ContextCompat.getColor(itemView.context,R.color.cardColor)
                    )
                }else{
                    calenderDay.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                    calendarDate.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                    cardView.setBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                }
                calenderDay.text= calenderDataModel.calendarDay
                calendarDate.text=calenderDataModel.calenderData
                cardView.setOnClickListener{
                    calenderInterface.onSelect(calenderDataModel,adapterPosition,calendarDate)
                }
            }

    }


    interface CalendarInterface {
        fun onSelect(calenderData: calenderData,position:Int,day:TextView)
    }
    fun setPosition(pos:Int){
        this.pos=pos
    }
    fun updateList(calendarList:ArrayList<calenderData>){
        list.clear()
        list.addAll(calendarList)
        notifyDataSetChanged()
    }



}