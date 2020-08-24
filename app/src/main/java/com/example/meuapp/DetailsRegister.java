package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meuapp.model.myMemory;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class DetailsRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_register);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null && bundle.containsKey("id")){
            Long id = bundle.getLong("id");

            myMemory myMemorie = myMemory.findById(myMemory.class, id);

            TextView textView = (TextView) findViewById(R.id.textTitle);
            textView.setText(myMemorie.getTitle());

            TextView textView2 = (TextView) findViewById(R.id.textDescription);
            textView2.setText(myMemorie.getDescription());

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 3;
            Bitmap bitmap = BitmapFactory.decodeFile(myMemorie.getImage_1(), options);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);
            byte[] binario = outputStream.toByteArray();
            String fotoString = Base64.encodeToString(binario, Base64.DEFAULT);

            ImageView imageView = (ImageView) findViewById(R.id.imageViewDetails);
            imageView.setImageBitmap(bitmap);
            imageView.setBackground(null);
        }
    }
}