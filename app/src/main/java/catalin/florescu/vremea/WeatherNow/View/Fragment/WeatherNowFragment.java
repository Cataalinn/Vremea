package catalin.florescu.vremea.WeatherNow.View.Fragment;


import android.animation.Animator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import java.util.ArrayList;

import catalin.florescu.vremea.R;
import catalin.florescu.vremea.Utils.AnimationUtils;
import catalin.florescu.vremea.WeatherNow.AsyncTasks.GetWeatherNowAsyncTask;
import catalin.florescu.vremea.WeatherNow.Interfaces.IGetWeatherNow;
import catalin.florescu.vremea.WeatherNow.Utils.ConvertRespIntoAdapter;
import catalin.florescu.vremea.WeatherNow.View.Adapter.WeatherNowAdapter;
import catalin.florescu.vremea.WeatherNow.View.Adapter.WeatherNowRecycleViewAdapter;
import catalin.florescu.vremea.WeatherObjects.WeatherObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherNowFragment extends Fragment implements IGetWeatherNow, View.OnClickListener {

    public static final String TAG = "WeatherNowFragment";

    private View mView;
    private WeatherNowRecycleViewAdapter weatherNowRecycleViewAdapter;
    private RecyclerView mRecyclerView;
    private FloatingActionButton floatingActionButton;

    public WeatherNowFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_weather_now, container, false);
        initView(mView);

        new GetWeatherNowAsyncTask(getContext(), WeatherNowFragment.this).execute("Brasov");

        return mView;
    }

    private void initView(View view) {

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);
        ArrayList<WeatherNowAdapter> weatherNowArray = new ArrayList<>(100);
        weatherNowRecycleViewAdapter = new WeatherNowRecycleViewAdapter(weatherNowArray);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycleView);

        mRecyclerView.setAdapter(weatherNowRecycleViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onSuccessWeatherNowResponse(final WeatherObject weatherObject) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                weatherNowRecycleViewAdapter.add(ConvertRespIntoAdapter.convertResponse(weatherObject), weatherNowRecycleViewAdapter.getItemCount());
                AnimationUtils.createRevealEffect(mRecyclerView);
                AnimationUtils.createRevealEffect(floatingActionButton);
            }
        }, 1000);
    }

    @Override
    public void onFailedWeatherNowResponse() {
        Snackbar.make(mView, "Failed to get weather predictions", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                AnimationUtils.hideRevealEffect(mRecyclerView);
                AnimationUtils.hideRevealEffect(floatingActionButton);
                new GetWeatherNowAsyncTask(getContext(), WeatherNowFragment.this).execute("Brasov");
                break;
        }
    }
}
