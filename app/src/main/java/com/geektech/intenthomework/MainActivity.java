package com.geektech.intenthomework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private ImageView imageView;
    Button open_a, open_g;
    TextView input_text;
    public static final String EXTRA_KEY = "textKey";

    private static String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageInGalleryResult);
        open_a = findViewById(R.id.open_activity);
        open_g = findViewById(R.id.open_gmail);
        open_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        open_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "sayevnur@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, value);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Send Email"));
                }
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            imageView.setImageURI(data.getParcelableExtra(SecondActivity.KEYS));
            value = data.getStringExtra("text");
        }
    }
}