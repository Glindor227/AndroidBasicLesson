package com.geekbrains.androidlesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityParams sap = (SecondActivityParams) Objects.requireNonNull(getIntent().getExtras()).getSerializable(CommonActivityParam.KeyIntent);
        if (sap !=null)
            SetLocalDate(sap);

    }

    private void SetLocalDate(SecondActivityParams sap){
        TextView tvTownName = findViewById(R.id.textView_townName);
        tvTownName.setText(sap.getName());
        TextView tvTemp = findViewById(R.id.textView_Temp);
        tvTemp.setText("21"+"\u2103");

        TextView tvHum = findViewById(R.id.textView_humidity);
        tvHum.setText("60%");
        tvHum.setVisibility(sap.getHum() ? View.VISIBLE : View.INVISIBLE);
        ((TextView)findViewById(R.id.textView4)).setVisibility( sap.getHum() ? View.VISIBLE : View.INVISIBLE );


        TextView tvOver = findViewById(R.id.textView_overcast);
        tvOver.setVisibility(sap.getOverc()?View.VISIBLE:View.INVISIBLE);
        tvOver.setText("Облачно");
        ((TextView)findViewById(R.id.textView6)).setVisibility( sap.getOverc() ? View.VISIBLE : View.INVISIBLE );


        TextView tvSpeed = findViewById(R.id.textView_speed);
        tvSpeed.setText("5-7м/с");
        tvSpeed.setVisibility(sap.getSpeed()?View.VISIBLE:View.INVISIBLE);
        ((TextView)findViewById(R.id.textView8)).setVisibility( sap.getSpeed() ? View.VISIBLE : View.INVISIBLE );

    }

}
