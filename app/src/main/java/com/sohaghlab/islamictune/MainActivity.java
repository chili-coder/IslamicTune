package com.sohaghlab.islamictune;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView movetext;
    TextView changeLanguage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);

        movetext= findViewById(R.id.movetext);
        movetext.setSelected(true);

       // ActionBar actionBar = getSupportActionBar();
      //  actionBar.setTitle(getResources().getString(R.string.app_name));



        changeLanguage=findViewById(R.id.enChange);

        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showChangeLaguageDialog();


            }
        });



    }

    private void showChangeLaguageDialog() {

        final String[] listItems = {"English","বাংলা"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language ...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0){

                    //english
                    setLocale("en");
                    recreate();








                    Toast.makeText(MainActivity.this, "English", Toast.LENGTH_SHORT).show();




                }else
                     if (which==1){

                    //bangla
                    setLocale("bn");
                    recreate();






                         Toast.makeText(MainActivity.this, "বাংলা", Toast.LENGTH_SHORT).show();

                }

                    dialog.dismiss();

            }

        });

        AlertDialog mDialog= mBuilder.create();
        mDialog.show();

    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);


        Configuration config =new Configuration();
        config.locale =locale;

        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        //set data shared preferences

        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();


    }

    //load language save in shared preferences

    public  void  loadLocale(){

        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language= preferences.getString("My_Lang","");
        setLocale(language);
    }
}