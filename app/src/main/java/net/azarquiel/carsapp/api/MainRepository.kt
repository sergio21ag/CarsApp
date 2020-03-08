
import net.azarquiel.carsapp.model.Coche
import net.azarquiel.carsapp.api.WebAccess

/**
 * Created by pacopulido on 04/02/2019.
 */


class MainRepository() {
    val service = WebAccess.carService

    suspend fun getDataCoches(): List<Coche> {
        val webResponse = service.getDataCar().await()
        if (webResponse.isSuccessful) {
            return webResponse.body()!!.coches
        }
        return emptyList()
    }

    suspend fun saveCar(
        modelo: String,
        kilometros: String,
        ano: String,
        precio: String,
        combustible: String,
        potencia: String
    ): Coche? {
        var coche: Coche? = null
        val webResponse = service.saveCar(modelo, kilometros, ano, precio, combustible, potencia).await()
        if (webResponse.isSuccessful) {
            coche = webResponse.body()!!.coche
        }
        return coche
    }
}
