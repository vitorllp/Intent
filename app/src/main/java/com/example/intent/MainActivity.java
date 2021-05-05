package com.example.intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.intent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    //const
    public static final String PARAMETRO = "PARAMETRO";
    private final int OUTRA_ACTIVITY_REQUEST_CODE = 0;
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
                //Intent outraActivityIntent = new Intent(this,OutraActivity.class);
                Intent outraActivityIntent = new Intent("RECEBER_E_RETORNAR_ACTION");
                // Bundle parametrosBundle = new Bundle();
                //parametrosBundle.putString(PARAMETRO,activityMainBinding.paremetroEt.getText().toString());
                //outraActivityIntent.putExtras(parametrosBundle);

                outraActivityIntent.putExtra(PARAMETRO,activityMainBinding.paremetroEt.getText().toString());
                startActivityForResult(outraActivityIntent,OUTRA_ACTIVITY_REQUEST_CODE);
                return true;
            case R.id.viewMi:
                Intent abrirNavegadorIntent = new Intent(Intent.ACTION_VIEW);
                abrirNavegadorIntent.setData(Uri.parse("http://scl.ifsp.edu.br"));
                startActivity(abrirNavegadorIntent);
                return true;
            case R.id.callMi:
                verifyCallPhonePermission();
                return true;
        }
        return false;
    }

    private void verifyCallPhonePermission(){
        Intent ligarIntent = new Intent(Intent.ACTION_CALL);
        ligarIntent.setData(Uri.parse("tel:"+activityMainBinding.paremetroEt.getText().toString()));
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){
                startActivity(ligarIntent);
            } else {

            }
        } else {
            startActivity(ligarIntent);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == OUTRA_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Toast.makeText(this,"voltou para a main",Toast.LENGTH_SHORT).show();
            String retorno = data.getStringExtra(OutraActivity.RETORNO);
            if(retorno != null){
                activityMainBinding.retornoTv.setText(retorno);
            }
        }
    }
}