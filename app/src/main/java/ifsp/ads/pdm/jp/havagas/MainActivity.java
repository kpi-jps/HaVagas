package ifsp.ads.pdm.jp.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ifsp.ads.pdm.jp.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
    }
}