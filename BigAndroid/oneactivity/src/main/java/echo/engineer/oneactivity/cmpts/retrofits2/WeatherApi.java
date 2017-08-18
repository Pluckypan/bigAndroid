package echo.engineer.oneactivity.cmpts.retrofits2;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * WeatherApi.java
 * Useage: WeatherApi
 * Created by Plucky<py@meitu.com> on 2017/8/14 - 14:17
 */

public interface WeatherApi {
    @GET("/weather_mini")
    Observable<JsonResult<Weather>> getWeather(@Query("city") String city);
}