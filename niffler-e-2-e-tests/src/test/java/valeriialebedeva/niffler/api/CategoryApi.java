package valeriialebedeva.niffler.api;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import valeriialebedeva.niffler.model.CategoryJson;

public interface CategoryApi {

    @POST("/category")
    Call<CategoryJson> addCategory(@Body CategoryJson category);

}
