package com.sohaghlab.adminislamicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.ArrayList;
import java.util.List;

public class AddItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner;
    TextView audio_title, audio_album,audio_category,audio_durition,upload_audio_title_view;
    byte[] ctgory;
    String title, category ,album ="", durition;

    ImageView album_ctgry;

    TextView textViewImage;
    ProgressBar progressBar;
    Uri audioUri;
    StorageReference mStorageRef;
    StorageTask mUploadTask;
    DatabaseReference referenceAudio;
    String audioItem;
    LinearLayout upload_audio_file;

    MediaMetadataRetriever mediaMetadataRetriever;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        audio_title=findViewById(R.id.audio_title);
        audio_album=findViewById(R.id.audio_album);
        audio_category=findViewById(R.id.addio_categroy);
        audio_durition=findViewById(R.id.audio_durition);
        audio_title=findViewById(R.id.audio_title);
        upload_audio_title_view =findViewById(R.id.upload_audio_title);
        spinner=findViewById(R.id.spinner);
        progressBar=findViewById(R.id.progressBar);
        upload_audio_file=findViewById(R.id.upload_audio_file);

        mediaMetadataRetriever = new MediaMetadataRetriever();
        referenceAudio= FirebaseDatabase.getInstance().getReference().child("audios");
        mStorageRef= FirebaseStorage.getInstance().getReference().child("audios");

        spinner.setOnItemSelectedListener(this);


        List<String> items = new ArrayList<>();
        items.add("quran");
        items.add("shura");
        items.add("arabic ring tone");
        items.add("bangla islamic tone");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        audioItem=parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "Selected"+audioItem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void openAudioFiles (View view){

        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("audio/*");
        startActivityForResult(i,101);


    }
}