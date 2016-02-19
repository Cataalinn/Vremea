package catalin.florescu.vremea.WeatherNow.View.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import catalin.florescu.vremea.R;

/**
 * Created by Florescu George Cătălin on 24.10.2015.
 */
public class WeatherNowRecycleViewAdapter extends RecyclerView.Adapter<WeatherNowRecycleViewAdapter.ViewHolder> {

    private ArrayList<WeatherNowAdapter> weatherNowAdapterList;

    public WeatherNowRecycleViewAdapter(ArrayList<WeatherNowAdapter> weatherNowAdapterList) {
        this.weatherNowAdapterList = weatherNowAdapterList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final WeatherNowAdapter weatherNowAdapter = weatherNowAdapterList.get(position);
        holder.itemView.setTag(weatherNowAdapter);

        holder.searchedPlace.setText(weatherNowAdapter.getPlace());
        holder.temperature.setText(weatherNowAdapter.getTemperature());
        holder.maxTemperature.setText(weatherNowAdapter.getMaxTemperature());
        holder.minTemperature.setText(weatherNowAdapter.getMinTemperature());
        holder.pressure.setText(weatherNowAdapter.getPressure());
        holder.humidity.setText(weatherNowAdapter.getHumidity());
        holder.altitude.setText(weatherNowAdapter.getAltitude());
        holder.description.setText(weatherNowAdapter.getDescription().replace(weatherNowAdapter.getDescription().charAt(0),
                weatherNowAdapter.getDescription().toUpperCase().charAt(0)));

        if (position == getItemCount() - 1) {
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(holder.description.getPaddingLeft(),
                    holder.description.getPaddingTop(),
                    holder.description.getPaddingRight(), holder.description.getPaddingTop());
            holder.description.setLayoutParams(llp);
        }
    }

    @Override
    public int getItemCount() {
        return weatherNowAdapterList.size();
    }

    public void add(WeatherNowAdapter item, int position) {
        weatherNowAdapterList.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        weatherNowAdapterList.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView searchedPlace, temperature, maxTemperature, minTemperature, pressure, humidity, altitude, description;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.weather_card_view);
            altitude = (TextView) itemView.findViewById(R.id.altitude);
            humidity = (TextView) itemView.findViewById(R.id.humidity);
            searchedPlace = (TextView) itemView.findViewById(R.id.searchedPlace);
            temperature = (TextView) itemView.findViewById(R.id.temperature);
            minTemperature = (TextView) itemView.findViewById(R.id.min_temperature);
            maxTemperature = (TextView) itemView.findViewById(R.id.max_temperature);
            pressure = (TextView) itemView.findViewById(R.id.pressure);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
