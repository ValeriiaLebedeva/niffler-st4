package valeriialebedeva.niffler.api;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import valeriialebedeva.niffler.model.CategoryJson;

import java.util.List;

public interface CategoryApi {

    @POST("/category")
    Call<CategoryJson> addCategory(@Body CategoryJson category);

    @GET("/categories")
    Call<List<CategoryJson>> getAllCategoriesByUser(@Query("username") String username);

}
