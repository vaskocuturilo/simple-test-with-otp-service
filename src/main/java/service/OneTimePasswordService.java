package service;

import model.OneTimePassword;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OneTimePasswordService {
    @GET("data/2.5/weather?")
    Call<OneTimePassword> getCurrentWeatherData();
}
