package net.azarquiel.carsapp.views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import net.azarquiel.carsapp.R
import net.azarquiel.carsapp.adapter.CustomAdapter
import net.azarquiel.carsapp.model.Coche
import net.azarquiel.carsapp.viewmodel.MainViewModel
import net.azarquiel.retrofitcajonbindig.views.DetailActivity

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {
    private lateinit var searchView: SearchView
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CustomAdapter
//    private lateinit var bares: List<Bar>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        nav_view.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        updateHeader()
        initRV()
        getCoches()

        fab.setOnClickListener { view ->
            saveCar()
        }

    }

    private fun updateHeader() {
        val miivavatar = nav_view.getHeaderView(0).ivavatar
        miivavatar.setOnClickListener{
            Toast.makeText(this, "Pulsaste sobre el avatar..",Toast.LENGTH_LONG).show()
        }
        val mitvavatar = nav_view.getHeaderView(0).tvavatar
        miivavatar.setImageResource(R.drawable.avatar)
        mitvavatar.text = "El presi"
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var fragment:Fragment? = null
        when (item.itemId) {
            R.id.nav_login -> {
                Toast.makeText(this,"Login", Toast.LENGTH_LONG).show()
            }
            R.id.nav_registro -> {
                Toast.makeText(this,"Registro", Toast.LENGTH_LONG).show()
            }
            R.id.nav_acercade -> {
                Toast.makeText(this,"A cerca de", Toast.LENGTH_LONG).show()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    private fun saveBar() {
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        viewModel.saveBar("0TTTTOOONTTTOOO", "SE", "Toledo", "TO").observe(this, Observer { it ->
//            it?.let{
//                val bar=it
//                val baresaux = ArrayList<Bar>(bares)
//                baresaux.add(0, bar)
//                bares = ArrayList<Bar>(baresaux)
//                adapter.setBares(bares)
//            }
//        })
//    }

    private fun getCoches() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getDataBares().observe(this, Observer { it ->
            it?.let{
                coches=it
                adapter.setBares(coches)
            }
        })

    }

    private fun initRV() {
        adapter = CustomAdapter(this, R.layout.row)
        rvCoches.adapter = adapter
        rvCoches.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        // ************* <Filtro> ************
        val searchItem = menu.findItem(R.id.search)
        searchView = searchItem.actionView as SearchView
        searchView.setQueryHint("Search...")
        searchView.setOnQueryTextListener(this)
        // ************* </Filtro> ************

        return true
    }

    // ************* <Filtro> ************
    override fun onQueryTextChange(query: String): Boolean {
        val original = ArrayList<Coche>(coches)
        adapter.setBares(original.filter { bar -> bar.nombrecar.contains(query) })
        return false
    }

    override fun onQueryTextSubmit(text: String): Boolean {
        return false
    }
    // ************* </Filtro> ************
    fun onClickCar(v: View){
        val carpuldado = v.tag as Coche
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("car", carpuldado)
        startActivity(intent)
    }


}
