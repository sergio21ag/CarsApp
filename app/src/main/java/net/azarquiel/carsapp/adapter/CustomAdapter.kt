package net.azarquiel.carsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row.view.*
import net.azarquiel.carsapp.model.Coche

/**
 * Created by pacopulido on i9/i10/18.
 */
class CustomAdapter(val context: Context,
                    val layout: Int
                    ) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var dataList: List<Coche> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setCoches(coches: List<Coche>) {
        this.dataList = coches
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: Coche){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
//            itemView.tvnombrebarrow.text = dataItem.nombrebar
//            Picasso.get().load("http://tapeando.jldes.net/tapeando/images/logos/logo${dataItem.idbar}.png").into(itemView.ivbarrow)
//
//            itemView.tag = dataItem
        }

    }
}