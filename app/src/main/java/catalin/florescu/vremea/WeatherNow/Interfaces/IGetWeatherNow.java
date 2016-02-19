package catalin.florescu.vremea.WeatherNow.Interfaces;

import catalin.florescu.vremea.WeatherObjects.WeatherObject;

/**
 * Created by Florescu George Cătălin on 24.10.2015.
 */
public interface IGetWeatherNow {
    void onSuccessWeatherNowResponse(WeatherObject weatherObject);

    void onFailedWeatherNowResponse();
}
