package catalin.florescu.vremea.WeatherNow.Utils;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Florescu George Cătălin on 24.10.2015.
 * Build request and get weather response from service
 */
public class CallWeatherNow {

    private static final String URL1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String URL2 = ",ro&units=metric&appid=c007306f537b5c5b9fb21f04d819e45e&lang=ro";

    /**
     * Create new call to get weather json response from searched searchedPlace from OpenWeatherMap service
     *
     * @param searchedPlace - searched searchedPlace
     * @return response from service with weather
     */
    public static Response getWeatherResponse(String searchedPlace) {
        OkHttpClient client = new OkHttpClient();

        String finalUrl = URL1 + searchedPlace + URL2;

        // after 10 seconds with no response, throw SocketTimeOutException
        int CONNECTION_TIMEOUT = 10;
        client.setConnectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        Request request = new Request.Builder().url(finalUrl).build();
        Response response = null;

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
