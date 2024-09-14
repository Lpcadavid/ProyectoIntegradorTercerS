package com.example.santaellafinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Arrays;
import java.util.List;

public class NosotrosActivity extends AppCompatActivity {

    private ViewPager2 carruselImagenes;
    private CarruselAdapter carruselAdapter;
    private Handler handler = new Handler(Looper.getMainLooper());
    private long intervaloCambioImagen = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosotros);

        List<Integer> imagenes = Arrays.asList(
                R.drawable.collar,
                R.drawable.ear_1,
                R.drawable.pulsera,
                R.drawable.candonga1,
                R.drawable.promo,
                R.drawable.aretas_1,
                R.drawable.pulseradije

        );

        carruselImagenes = findViewById(R.id.carruselImagenes);
        carruselAdapter = new CarruselAdapter(imagenes);
        carruselImagenes.setAdapter(carruselAdapter);

        // Inicia el cambio automático de imágenes
        iniciarCambioAutomatico();
    }

    private void iniciarCambioAutomatico() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int paginaActual = carruselImagenes.getCurrentItem();
                int siguientePagina = (paginaActual + 1) % carruselAdapter.getItemCount();
                carruselImagenes.setCurrentItem(siguientePagina, true); // true para animación suave
                handler.postDelayed(this, intervaloCambioImagen);
            }
        };
        handler.postDelayed(runnable, intervaloCambioImagen);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Detiene el cambio automático cuando la Activity está en pausa
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reinicia el cambio automático cuando la Activity se reanuda
        iniciarCambioAutomatico();
    }
}