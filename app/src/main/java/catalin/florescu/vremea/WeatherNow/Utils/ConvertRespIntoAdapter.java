package catalin.florescu.vremea.WeatherNow.Utils;

import catalin.florescu.vremea.WeatherNow.View.Adapter.WeatherNowAdapter;
import catalin.florescu.vremea.WeatherObjects.WeatherObject;

/**
 * Created by Florescu George Cătălin on 24.10.2015.
 */
public class ConvertRespIntoAdapter {

    public static WeatherNowAdapter convertResponse(WeatherObject weatherObject) {
        return new WeatherNowAdapter(weatherObject.searchedPlace,
                String.valueOf(weatherObject.weatherIndicators.temperature),
                String.valueOf(weatherObject.weatherIndicators.maximumTemperature),
                String.valueOf(weatherObject.weatherIndicators.minimumTemperature),
                String.valueOf(weatherObject.weatherIndicators.pressure),
                String.valueOf(weatherObject.weatherIndicators.humidity),
                String.valueOf(weatherObject.weatherIndicators.seaLevel),
                String.valueOf(weatherObject.weatherWind.windSpeed),
                weatherObject.weatherStatus[0].description);

    }
}
