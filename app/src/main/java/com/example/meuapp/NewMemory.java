package com.example.meuapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.model.myMemory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NewMemory extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_VOICE_CAPTURE = 2;

    private myMemory myMemory = new myMemory();

    String currentPhotoPath;
    Button btnTalk, btnTakePicture;
    EditText textCatch;
    ImageView imagePreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memory);

        textCatch = findViewById(R.id.title);
        btnTalk = (Button) findViewById(R.id.btn_talk);
        btnTakePicture = (Button) findViewById(R.id.btn_take_picture);
        imagePreview = (ImageView) findViewById(R.id.image_preview);

        btnTalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iVoice = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                iVoice.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

                iVoice.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

                iVoice.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale algo");

                try {
                    startActivityForResult(iVoice, REQUEST_VOICE_CAPTURE);

                }catch(ActivityNotFoundException a){

                }

            }
        });
    }


    public void takePicture(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.meuapp",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    public void saveMemory(View view){
        EditText description = findViewById(R.id.description);

        myMemory.setTitle(textCatch.getText().toString());
        myMemory.setDescription(description.getText().toString());


        myMemory.save();


        Toast.makeText(this, "Memória adiconada com sucesso "+myMemory.getTitle(), Toast.LENGTH_SHORT).show();

        finish();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case REQUEST_VOICE_CAPTURE:
                if(resultCode == RESULT_OK){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textCatch.setText(result.get(0).toString());
                }
                break;
            case REQUEST_IMAGE_CAPTURE:
                if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                    try{
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 3;
                        Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath, options);

                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);
                        byte[] binario = outputStream.toByteArray();
                        String fotoString = Base64.encodeToString(binario, Base64.DEFAULT);

                        imagePreview.setImageBitmap(bitmap);
                        imagePreview.setBackground(null);
                        myMemory.setImage_1(currentPhotoPath);

                    }catch(Exception i){

                    }

                }

        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}
