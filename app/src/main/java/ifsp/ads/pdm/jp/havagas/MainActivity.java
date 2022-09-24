package ifsp.ads.pdm.jp.havagas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


import com.google.android.material.snackbar.Snackbar;

import ifsp.ads.pdm.jp.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private static final String LOG = "Log";
    private static final String NAME = "Name";
    private static final String IN_EMAIL_LIST = "In Email List";
    private static final String EMAIL = "Email";
    private static final String HAS_HOME_PHONE = "Has home phone";
    private static final String PHONE = "Phone";
    private static final String HAS_MOBILE_PHONE = "Has mobile phone";
    private static final String MOBILE = "Mobile";
    private static final String FEMALE = "Is female";
    private static final String BIRTHDATE = "Birthdate";
    private static final String EDUCATION_SP_INDEX = "Education SP index";
    private static final String CONCLUSION = "Conclusion";
    private static final String INSTITUTION = "Institution";
    private static final String MONOGRAPH = "Monograph";
    private static final String ADVISOR = "Advisor";

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
                        toggleSpinnerItemsVisibility(i);
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
    private void toggleSpinnerItemsVisibility(int index) {
        activityMainBinding.institutionEt.setVisibility(View.GONE);
        activityMainBinding.institutionEt.setText("");
        activityMainBinding.monographTitleEt.setVisibility(View.GONE);
        activityMainBinding.monographTitleEt.setText("");
        activityMainBinding.advisorEt.setVisibility(View.GONE);
        activityMainBinding.advisorEt.setText("");
        if (index >= 2) activityMainBinding.institutionEt.setVisibility(View.VISIBLE);
        if (index >= 4) {
            activityMainBinding.monographTitleEt.setVisibility(View.VISIBLE);
            activityMainBinding.advisorEt.setVisibility(View.VISIBLE);
        }
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

        stringBuilder.append("\nData de nascimento: " + activityMainBinding.birthDateEt.getText().toString());

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
        activityMainBinding.advisorEt.setText("");
        activityMainBinding.educationSp.setSelection(0);
        activityMainBinding.institutionEt.setVisibility(View.GONE);
        activityMainBinding.mobilePhoneEt.setVisibility(View.GONE);
        activityMainBinding.advisorEt.setVisibility(View.GONE);
        activityMainBinding.monographTitleEt.setVisibility(View.GONE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NAME, activityMainBinding.nameEt.getText().toString());
        outState.putString(EMAIL, activityMainBinding.emailEt.getText().toString());
        outState.putBoolean(IN_EMAIL_LIST, activityMainBinding.emailListCb.isChecked());
        outState.putBoolean(HAS_HOME_PHONE, activityMainBinding.homePhoneRb.isChecked());
        outState.putString(PHONE, activityMainBinding.phoneEt.getText().toString());
        outState.putBoolean(HAS_MOBILE_PHONE, activityMainBinding.mobilePhoneCb.isChecked());
        outState.putString(MOBILE, activityMainBinding.mobilePhoneEt.getText().toString());
        outState.putBoolean(FEMALE,activityMainBinding.femaleRb.isChecked());
        outState.putString(BIRTHDATE, activityMainBinding.birthDateEt.getText().toString());
        outState.putString(CONCLUSION,activityMainBinding.conclusionEt.getText().toString());
        outState.putInt(EDUCATION_SP_INDEX, activityMainBinding.educationSp.getSelectedItemPosition());
        outState.putString(INSTITUTION,activityMainBinding.institutionEt.getText().toString());
        outState.putString(MONOGRAPH, activityMainBinding.monographTitleEt.getText().toString());
        outState.putString(ADVISOR,activityMainBinding.advisorEt.getText().toString());
        Log.v(LOG, "onSaveInstanceState: Saving form state!");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        activityMainBinding.nameEt.setText(savedInstanceState.getString(NAME));
        activityMainBinding.phoneEt.setText(savedInstanceState.getString(PHONE));
        activityMainBinding.emailEt.setText(savedInstanceState.getString(EMAIL));
        activityMainBinding.emailListCb.setChecked(savedInstanceState.getBoolean((IN_EMAIL_LIST)));
        activityMainBinding.birthDateEt.setText(savedInstanceState.getString(BIRTHDATE));
        activityMainBinding.femaleRb.setChecked(savedInstanceState.getBoolean(FEMALE));
        activityMainBinding.mobilePhoneCb.setChecked(savedInstanceState.getBoolean(HAS_MOBILE_PHONE));
        activityMainBinding.mobilePhoneEt.setText(savedInstanceState.getString(MOBILE));
        activityMainBinding.institutionEt.setText(savedInstanceState.getString(INSTITUTION));
        activityMainBinding.conclusionEt.setText(savedInstanceState.getString(CONCLUSION));
        activityMainBinding.monographTitleEt.setText(savedInstanceState.getString(MONOGRAPH));
        activityMainBinding.advisorEt.setText(savedInstanceState.getString(ADVISOR));
        activityMainBinding.educationSp.setSelection(savedInstanceState.getInt(EDUCATION_SP_INDEX));
        toggleSpinnerItemsVisibility(savedInstanceState.getInt(EDUCATION_SP_INDEX));
        Log.v(LOG, "onRestoreInstanceState: Restoring form state!");
    }
}