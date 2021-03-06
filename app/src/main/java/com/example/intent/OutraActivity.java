package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.intent.databinding.ActivityOutraBinding;

public class OutraActivity extends AppCompatActivity {

    private ActivityOutraBinding activityOutraBinding;

    public static final String RETORNO = "RETORNO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOutraBinding = ActivityOutraBinding.inflate(getLayoutInflater());
        setContentView(activityOutraBinding.getRoot());
        //recebendo
        //Bundle parametrosBundle = getIntent().getExtras();
        String parametro= getIntent().getStringExtra(MainActivity.PARAMETRO);
        if(parametro != null){
            //String parametro = parametrosBundle.getString(MainActivity.PARAMETRO,"");
            activityOutraBinding.recebidoTv.setText(parametro);
        }
        Log.v(getString(R.string.app_name)+"/"+getLocalClassName(),"OnCreate:iniciando ciclo completo");

    }

    public void onClick(View view){
        //retornando para main activity
        Intent retornoIntent = new Intent();
        retornoIntent.putExtra(RETORNO,activityOutraBinding.retornoEt.getText().toString());
        setResult(RESULT_OK,retornoIntent);
        finish();//chama na sequencia on pause, onstop, ondestroy
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(getString(R.string.app_name)+"/"+getLocalClassName(),"OnCreate:iniciando ciclo completo");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(getString(R.string.app_name)+"/"+getLocalClassName(),"OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(getString(R.string.app_name)+"/"+getLocalClassName(),"OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(getString(R.string.app_name)+"/"+getLocalClassName(),"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(getString(R.string.app_name)+"/"+getLocalClassName(),"destroy");
    }
}