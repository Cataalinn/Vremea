package catalin.florescu.vremea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import catalin.florescu.vremea.Utils.CreateFragment;
import catalin.florescu.vremea.WeatherNow.View.Fragment.WeatherNowFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CreateFragment.addFragment(this, R.id.frame_layout, new WeatherNowFragment(), WeatherNowFragment.TAG);
    }
}
