package com.example.traspasoimg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imagen1;
    ImageView imagen2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imagen1=(ImageView) findViewById(R.id.imageView);
        imagen2=(ImageView) findViewById(R.id.imageView2);

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamar(""+R.drawable.ic_launcher_foreground,""+R.color.white);
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamar(""+R.drawable.ic_bote_foreground,""+R.color.blue);
            }
        });
    }

    // metodo afuera del onCreate
    protected void llamar(String image, String color){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("image", image);
        intent.putExtra("color", color);
        startActivity(intent);

    }
}