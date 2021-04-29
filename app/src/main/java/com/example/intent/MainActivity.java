package com.example.intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.intent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    //const
    public static final String PARAMETRO = "PARAMETRO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        getSupportActionBar().setTitle("Tratando intents");
        getSupportActionBar().setSubtitle("Tem subtitulo tambem");
        setContentView(activityMainBinding.getRoot());
        Log.v(getString(R.string.app_name)+"/"+getLocalClassName(),"OnCreate:iniciando ciclo completo");

    }

    public void onClick(View view){

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.outraActivityMi:
                Intent outraActivityIntent = new Intent(this,OutraActivity.class);

                Bundle parametrosBundle = new Bundle();
                parametrosBundle.putString(PARAMETRO,activityMainBinding.paremetroEt.getText().toString());
                outraActivityIntent.putExtras(parametrosBundle);
                startActivity(outraActivityIntent);
                return true;
            case R.id.viewMi:
                return true;
        }
        return false;
    }
}