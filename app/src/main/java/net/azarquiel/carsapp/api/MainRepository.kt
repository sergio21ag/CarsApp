
import net.azarquiel.carsapp.model.Coche
import net.azarquiel.retrofitcajonbindig.api.WebAccess
import net.azarquiel.retrofitcajonbindig.model.Bar

/**
 * Created by pacopulido on 04/02/2019.
 */


class MainRepository() {
    val service = WebAccess.barService

    suspend fun getDataBares(): List<Coche> {
        val webResponse = service.getDataBares().await()
        if (webResponse.isSuccessful) {
            return webResponse.body()!!.bares
        }
        return emptyList()
    }

    suspend fun saveCar(
        nombrebar: String,
        direccion: String,
        municipio: String,
        provincia: String
    ): Bar? {
        var bar: Bar? = null
        val webResponse = service.saveBar(nombrebar, direccion, municipio, provincia).await()
        if (webResponse.isSuccessful) {
            bar = webResponse.body()!!.bar
        }
        return bar
    }
}
