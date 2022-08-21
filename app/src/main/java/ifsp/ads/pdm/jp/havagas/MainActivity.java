package ifsp.ads.pdm.jp.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import ifsp.ads.pdm.jp.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.mobilePhoneCb.setOnClickListener( view -> {
                activityMainBinding.mobilePhoneEt.setVisibility(View.GONE);
                activityMainBinding.monographTitleEt.setText("");
                if(activityMainBinding.mobilePhoneCb.isChecked())
                    activityMainBinding.mobilePhoneEt.setVisibility(View.VISIBLE);
            }
        );

        activityMainBinding.educationSp.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        activityMainBinding.monographTitleEt.setVisibility(View.GONE);
                        activityMainBinding.monographTitleEt.setText("");
                        activityMainBinding.advisorEt.setVisibility(View.GONE);
                        activityMainBinding.advisorEt.setText("");
                        if (i >= 3) activityMainBinding.institutionEt.setVisibility(View.VISIBLE);
                        if (i >= 4) {
                            activityMainBinding.monographTitleEt.setVisibility(View.VISIBLE);
                            activityMainBinding.advisorEt.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) { }
                }
        );


    }

    private void showFormData() {

    }

    private void resetForm() {
        activityMainBinding.nameEt.setText("");
        activityMainBinding.phoneEt.setText("");
        activityMainBinding.emailEt.setText("");
        activityMainBinding.emailListCb.setChecked(true);
        activityMainBinding.birthDateEt.setText("");
        activityMainBinding.femaleRb.setChecked(true);
        activityMainBinding.mobilePhoneCb.setChecked(false);
        activityMainBinding.mobilePhoneEt.setText("");
        activityMainBinding.institutionEt.setText("");
        activityMainBinding.conclusionEt.setText("");
        activityMainBinding.monographTitleEt.setText("");
        activityMainBinding.educationSp.setSelection(0);
        activityMainBinding.mobilePhoneEt.setVisibility(View.GONE);
        activityMainBinding.advisorEt.setVisibility(View.GONE);
        activityMainBinding.monographTitleEt.setVisibility(View.GONE);
    }
}