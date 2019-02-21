package com.geekbrains.androidlesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Boolean existDate = false;
    private void SetLocalDate(){
        TextView tvTemp = findViewById(R.id.textView_Temp);
        tvTemp.setText("21C");
        TextView tvHum = findViewById(R.id.textView_humidity);
        tvHum.setText("60%");
        TextView tvOver = findViewById(R.id.textView_overcast);
        tvOver.setText("Облачно");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);         // Кнопка
        button.setOnClickListener(new View.OnClickListener() {      // Обработка нажатий
            @Override
            public void onClick(View v) {
                existDate=true;
                SetLocalDate();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putBoolean("ExistDate", existDate);               // Сохраняем признак, что данные показаны
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        existDate = saveInstanceState.getBoolean("ExistDate");              // Восстанавливаем признак, что данные показаны
        if(existDate){
            SetLocalDate();
        }
    }


}
