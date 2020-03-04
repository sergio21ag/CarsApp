package net.azarquiel.carsapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.carsapp.model.Coche
import net.azarquiel.retrofitcajonbindig.api.MainRepository

/**
 * Created by pacopulido on 04/02/2019.
 */
class MainViewModel : ViewModel() {

    private var repository: MainRepository = MainRepository()

    fun getDataCoches(): LiveData<List<Coche>> {
        val dataCoches = MutableLiveData<List<Coche>>()
        GlobalScope.launch(Main) {
            dataCoches.value = repository.getDataBares()
        }
        return dataCoches
    }

    fun saveCar( nombrecar: String,direccion: String,
                 municipio: String,provincia: String):LiveData<Coche> {
        val car= MutableLiveData<Coche>()
        GlobalScope.launch(Main) {
            car.value = repository.saveBar(nombrecar, direccion, municipio, provincia)
        }
        return car
    }
// ……..   resto de métodos del ViewModel ………..
}
