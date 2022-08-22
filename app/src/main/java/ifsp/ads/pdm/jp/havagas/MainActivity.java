package ifsp.ads.pdm.jp.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


import com.google.android.material.snackbar.Snackbar;

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
                        activityMainBinding.institutionEt.setVisibility(View.GONE);
                        activityMainBinding.institutionEt.setText("");
                        activityMainBinding.monographTitleEt.setVisibility(View.GONE);
                        activityMainBinding.monographTitleEt.setText("");
                        activityMainBinding.advisorEt.setVisibility(View.GONE);
                        activityMainBinding.advisorEt.setText("");
                        if (i >= 2) activityMainBinding.institutionEt.setVisibility(View.VISIBLE);
                        if (i >= 4) {
                            activityMainBinding.monographTitleEt.setVisibility(View.VISIBLE);
                            activityMainBinding.advisorEt.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) { }
                }
        );
        activityMainBinding.clearBt.setOnClickListener(view -> {
                resetForm();
            }
        );

        activityMainBinding.saveBt.setOnClickListener( view -> {
            Toast.makeText(this,showFormData(), Toast.LENGTH_LONG).show();
        });

    }

    private String showFormData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nome: " + activityMainBinding.nameEt.getText().toString());
        stringBuilder.append("\nEmail: " + activityMainBinding.emailEt.getText().toString());

        if(activityMainBinding.emailListCb.isChecked())
            stringBuilder.append("\nEmail adicionado à lista de e-mails!");

        if(activityMainBinding.homePhoneRb.isChecked())
            stringBuilder.append("\nTelefone Residencial: " + activityMainBinding.phoneEt.getText().toString());
        else
            stringBuilder.append("\nTelefone Comercial: " + activityMainBinding.phoneEt.getText().toString());

        if(activityMainBinding.mobilePhoneCb.isChecked())
            stringBuilder.append("\nTelefone Celular: " + activityMainBinding.mobilePhoneEt.getText().toString());

        if(activityMainBinding.femaleRb.isChecked())
            stringBuilder.append("\nSexo: Feminino");
        else
            stringBuilder.append("\nSexo: Masculino");

        stringBuilder.append("\nAno de conclusão: " + activityMainBinding.conclusionEt.getText().toString());

        if(activityMainBinding.educationSp.getSelectedItemPosition() >= 2)
            stringBuilder.append("\nInstituição: " + activityMainBinding.institutionEt.getText().toString());

        if(activityMainBinding.educationSp.getSelectedItemPosition() >= 4) {
            stringBuilder.append("\nTítulo monografia: " + activityMainBinding.monographTitleEt.getText().toString());
            stringBuilder.append("\nOrientador: " + activityMainBinding.advisorEt.getText().toString());
        }

        return stringBuilder.toString();
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
        activityMainBinding.institutionEt.setVisibility(View.GONE);
        activityMainBinding.mobilePhoneEt.setVisibility(View.GONE);
        activityMainBinding.advisorEt.setVisibility(View.GONE);
        activityMainBinding.monographTitleEt.setVisibility(View.GONE);
    }
}