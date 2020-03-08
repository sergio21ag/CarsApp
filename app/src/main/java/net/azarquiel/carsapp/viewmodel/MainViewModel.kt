package net.azarquiel.carsapp.viewmodel


import MainRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.carsapp.model.Coche

/**
 * Created by pacopulido on 04/02/2019.
 */
class MainViewModel : ViewModel() {

    private var repository: MainRepository = MainRepository()

    fun getDataCoches(): LiveData<List<Coche>> {
        val dataCoches = MutableLiveData<List<Coche>>()
        GlobalScope.launch(Main) {
            dataCoches.value = repository.getDataCoches()
        }
        return dataCoches
    }

    fun saveCar( modelo: String,kilometros: String,
                 ano: String,precio: String, combustible: String, potencia: String):LiveData<Coche> {
        val car= MutableLiveData<Coche>()
        GlobalScope.launch(Main) {
            car.value = repository.saveCar(modelo, kilometros, ano, precio, combustible, potencia)
        }
        return car
    }
// ……..   resto de métodos del ViewModel ………..
}
