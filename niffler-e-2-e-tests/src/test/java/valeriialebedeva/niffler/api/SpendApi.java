package valeriialebedeva.niffler.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import valeriialebedeva.niffler.model.SpendJson;

public interface SpendApi {
  @POST("/addSpend")
  Call<SpendJson> addSpend(@Body SpendJson spend);
}
