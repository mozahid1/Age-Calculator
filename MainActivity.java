 package com.example.agecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    EditText day,mnth,year;
    TextView result, resultfinal;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);

        day = findViewById( R.id.day );
        mnth = findViewById( R.id.mnth );
        year = findViewById( R.id.year );
        btn = findViewById( R.id.btn );
        result = findViewById( R.id.result );
        resultfinal = findViewById( R.id.resultfinalId );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(Integer.parseInt( day.getText().toString() ),Integer.parseInt( mnth.getText().toString() ),Integer.parseInt( year.getText().toString() ));
            }
        } );


    }

    private void calculate(int d, int m, int y) {
        int fday,fmonth,fyear;
        //Scanner input = new Scanner(System.in);
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int iday = d;
        int imnth = m;
        int iyear = y;

        fday = day-iday;
        if(fday<0){
            fday = (day+30)-iday;
            month--;
        }
        fmonth = month-imnth;
        if(fmonth<0){
            fmonth = (month+12)-imnth;
            year--;
        }
        fyear = year-iyear;

        result.setText(fyear+" Years \n"+fmonth+" months \n"+fday+" days \n"+date.getHours()+" hours \n"+date.getMinutes()+" minuites \n"+date.getSeconds()+" seconeds");

        int yearToDay = fyear * 365;
        int monthToDay = fmonth * 30;
        int DayToDay = fday;
        int finalDay = (yearToDay + monthToDay + DayToDay);
        int finalHour = (((yearToDay + monthToDay + DayToDay) *24) +  date.getHours());
        int finalMin = (((((yearToDay + monthToDay + DayToDay) *24) +  date.getHours())*3600) + date.getMinutes());
        int finalSce = (((((((yearToDay + monthToDay + DayToDay) *24) +  date.getHours())*3600) + date.getMinutes()) * 60) + date.getSeconds());

        resultfinal.setText("Or "+finalDay+" Days \n"+"Or "+finalHour+" Hours \n"+"Or "+finalMin+" Minutes \n"+"Or "+finalSce+" Seconds");


    }
}
