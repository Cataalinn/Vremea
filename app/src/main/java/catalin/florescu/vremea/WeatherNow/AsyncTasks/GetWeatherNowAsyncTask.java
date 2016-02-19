package catalin.florescu.vremea.WeatherNow.AsyncTasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Response;

import java.io.IOException;

import catalin.florescu.vremea.WeatherNow.Interfaces.IGetWeatherNow;
import catalin.florescu.vremea.WeatherNow.Utils.CallWeatherNow;
import catalin.florescu.vremea.WeatherObjects.WeatherObject;

/**
 * Created by Florescu George Cătălin on 24.10.2015.
 * Start asyncTask to get weather information from searched searchedPlace
 */
public class GetWeatherNowAsyncTask extends AsyncTask<String, Void, WeatherObject> {

    private IGetWeatherNow serverResponse;
    private Context context;
    private ProgressDialog progressDialog;

    public GetWeatherNowAsyncTask(Context context, IGetWeatherNow senderController) {
        this.serverResponse = senderController;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Asteptati");
        progressDialog.setMessage("Preluam datele despre vreme...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Toast.makeText(context, "Operatie oprita de utilizator", Toast.LENGTH_LONG).show();
    }

    @Override
    protected final WeatherObject doInBackground(String... params) {
        WeatherObject weatherObject = null;

        try {
            //response from server
            Response response = CallWeatherNow.getWeatherResponse(params[0]);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String re = response.body().string();
            weatherObject = objectMapper.readValue(re, WeatherObject.class);

        } catch (IOException e) {
            e.printStackTrace();
            //something was wrong here

        }
        return weatherObject;
    }

    @Override
    protected void onPostExecute(WeatherObject weatherObject) {
        super.onPostExecute(weatherObject);
        if (weatherObject != null) {
            serverResponse.onSuccessWeatherNowResponse(weatherObject);
        } else {
            serverResponse.onFailedWeatherNowResponse();
        }
        progressDialog.cancel();
    }
}
