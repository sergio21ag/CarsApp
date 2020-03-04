package net.azarquiel.retrofitcajonbindig.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_detail.*
import net.azarquiel.retrofitcajonbindig.R
import net.azarquiel.retrofitcajonbindig.databinding.ActivityDetailBinding
import net.azarquiel.retrofitcajonbindig.model.Bar
import net.azarquiel.retrofitcajonbindig.util.setImageUrl
import net.azarquiel.retrofitcajonbindig.viewmodel.MainViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var MainViewModel : MainViewModel
    private lateinit var bar : Bar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bar = intent.getSerializableExtra("bar") as Bar
        var binding:ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.bar = bar
        rbEstrellas.rating = 2.5F
        //pintar()
    }

    private fun pintar() {
        // podemos probar esta nueva extension function así:
        ivcardetail.setImageUrl(bar.idbar)
        // aunque como tenemos bindeado tambien la imagen con picasso, no es necesario
        // Pintamos la foto mediante la libreria picasso
//        var foto = "http://tapeando.jldes.net/tapeando/images/logos/logo${bar.idbar}.png"
//        Picasso.get().load(foto).into(ivbardetail)


    }


}
