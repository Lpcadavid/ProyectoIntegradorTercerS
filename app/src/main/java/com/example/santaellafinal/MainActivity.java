package com.example.santaellafinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import com.example.santaellafinal.PromoModalDialogFragment;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar botones
        Button btnNosotros = findViewById(R.id.btnNosotros);
        Button btnCatalogo = findViewById(R.id.btnCatalogo);
        Button btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnNosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NosotrosActivity.class);
                startActivity(intent);
            }
        });

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CatalogoActivity.class);
                startActivity(intent);
            }
        });

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IniciarsActivity.class);
                startActivity(intent);
            }
        });

        videoView = findViewById(R.id.videoView); // Inicializa videoView
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videosantaella5);
        videoView.setVideoURI(videoUri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();

        PromoModalDialogFragment promoModal = new PromoModalDialogFragment();
        promoModal.show(getSupportFragmentManager(), "promo_modal");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (videoView != null) {
            videoView.pause(); // Pausa el video cuando la actividad se reanuda
        }
    }
}