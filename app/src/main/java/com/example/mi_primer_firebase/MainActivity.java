package com.example.mi_primer_firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void clickParte1 (View view){
        Intent i= new Intent(getApplicationContext(),Parte1Activity.class);
        startActivity(i);

    }

    public  void clickParte2 (View view){
        Intent i= new Intent(getApplicationContext(),Parte2Activity.class);
        startActivity(i);

    }

}
