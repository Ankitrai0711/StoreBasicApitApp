import com.example.resturantapp.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products") // Replace "data" with your actual endpoint
    fun getData(): Call<List<MyData>>
}
