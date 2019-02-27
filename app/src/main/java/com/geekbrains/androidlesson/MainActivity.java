package com.geekbrains.androidlesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Boolean existDate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btnSendData);         // Кнопка
        button.setOnClickListener(new View.OnClickListener() {      // Обработка нажатий
            @Override
            public void onClick(View v) {
                existDate=true;
                SecondActivityParams sap = new SecondActivityParams(((EditText)findViewById(R.id.editTextTown)).getText().toString(),
                        ((CheckBox)findViewById(R.id.checkBox)).isChecked(),
                        ((CheckBox)findViewById(R.id.checkBox2)).isChecked(),
                        ((CheckBox)findViewById(R.id.checkBox3)).isChecked());
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(CommonActivityParam.KeyIntent,sap);
                startActivity(intent);
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
//        if(existDate){
//        }
    }


}
