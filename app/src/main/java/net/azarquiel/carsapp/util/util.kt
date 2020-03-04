package net.azarquiel.carsapp.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import net.azarquiel.carsapp.R

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: Int?) {
    val urlcompleted = "http://tapeando.jldes.net/tapeando/images/logos/logo$url.png"
    Log.d("paco",urlcompleted)
    if (url==null)
        this.setImageResource(R.drawable.noimage)
    else
        Picasso.get().load(urlcompleted).into(this)
}

