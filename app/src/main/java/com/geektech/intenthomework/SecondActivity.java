package com.geektech.intenthomework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {

    public static final int Pick_image = 1;
    private ImageView image;
    private Button btn;
    private EditText txt;
    private Uri imageUri;
    public static final String KEYS="keys";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        btn = findViewById(R.id.setLogic);
        txt = findViewById(R.id.txtInput);
        image=findViewById(R.id.imageInGallery);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT).setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), Pick_image);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("text", txt.getText().toString());
                intent.putExtra(KEYS, imageUri);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Pick_image && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            image.setImageURI(imageUri);
            txt.setText("");
        }
    }
}