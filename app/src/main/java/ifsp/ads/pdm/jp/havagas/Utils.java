package ifsp.ads.pdm.jp.havagas;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.SystemClock;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final int YEARS_RANGE = 100;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static List<String> returnYears() {
        int i = 0;
        List<String> yearsList = new ArrayList<>();
        int year = LocalDate.now().getYear();
        while(i < YEARS_RANGE) yearsList.add(String.valueOf(year-(++i)));
        return yearsList;
    }
}
