package com.example.santaellafinal;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarritoActivity extends AppCompatActivity {

    private List<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_carrito);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        productos = new ArrayList<>();


        productos.add(new Producto(R.drawable.promo, "Collar Elegante", "Promoción de 3 collares, 5 earcuff, 2 pares de candongas, 2 pares de aretas tejidas en mostacilla, 2 pulseras con dije en rodio (Todos nuestros accesorios tiene un baño en oro golfi)", 100000.00));
        productos.add(new Producto(R.drawable.collar_6, "Collar en mostacilla checa","Collar en mostacilla checa, perlas de vidrio, estrella fosi, cadena y dije en oro golfi", 18000.00));
        productos.add(new Producto(R.drawable.collar_1, "Collar en perlas de vidrio" ,"Collar en perlas de vidrio, cadena y dijen candado en oro golfi", 10500.00));
        productos.add(new Producto(R.drawable.collarcaracolas, "Collar en caracolas", "dije de estrella en oro golfi, balines en oro golfi y terminación en oro golfi", 10500.00));
        productos.add(new Producto(R.drawable.collarperla, "Collar en perlas", "simulacion piedra de rio, chaquira checa y terminación en oro golfi", 18000.00));
        productos.add(new Producto(R.drawable.collar_2, "Collar en perlas de vidrio"," Con balines en oro golfi", 18000.00));

        productos.add(new Producto(R.drawable.pulsera_1, "Pulsera en chaquira china", "canotillos, cadena en oro golfi, hilo coreano, murano y dijes en oro golfi", 8000.00));
        productos.add(new Producto(R.drawable.pulsera_2, "Pulsera en mostacilla checa", "separador en oro golfi y murano", 5500.00));
        productos.add(new Producto(R.drawable.pulserapiedra, "Pulsera en piedra de vidrio", "balines y terminacion en baño de oro golfi", 10000.00));
        productos.add(new Producto(R.drawable.pulseradije, "Pulsera en murano","perla de vidrio, corazón nacar, dije, balines y serparadores en oro golfi", 12000.00));
        productos.add(new Producto(R.drawable.pulsera_3, "Pulsera en chaquira china", "murano, hilo coreano, dijes y separadores en oro golfi", 6500.00));

        productos.add(new Producto(R.drawable.aretas_1, "Areta en mostacilla checa", "murano, topos y herraje en baño de bronce", 13500.00));
        productos.add(new Producto(R.drawable.aretas_2, "Topo"," en baño de rodio", 7500.00));
        productos.add(new Producto(R.drawable.aretas_3, "Areta" ,"gota en plastimetal con baño de rodio", 8000.00));
        productos.add(new Producto(R.drawable.aretas_4, "Areta"," en mostacilla checa, herraje en baño de bronce", 12000.00));
        productos.add(new Producto(R.drawable.aretas_5, "Areta"," en perla plastica y topo en rodio", 11500.00));

        productos.add(new Producto(R.drawable.candonga1, "Candonga"," en plastimetal con baño de rodio", 7300.00));
        productos.add(new Producto(R.drawable.candonga2, "Candonga"," en plastimetal con baño de rodio", 8500.00));
        productos.add(new Producto(R.drawable.candongas_3, "Candonga", " en plastimetal con baño de rodio", 7200.00));

        productos.add(new Producto(R.drawable.ear_1, "Earcuff", " media perla en oro golfi", 3500.00));
        productos.add(new Producto(R.drawable.e1, "Herraje", " earcuff envuelto en balines de oro golfi con alambre", 5200.00));
        productos.add(new Producto(R.drawable.e2, "Earcuff", " con baño de oro golfi", 1800.00));

        productos.add(new Producto(R.drawable.joyeros_1, "Joyero", " en cuero sintetico viajero", 15000.00));
        productos.add(new Producto(R.drawable.joye1, "Joyero", " en cuero sintetico con espejo", 50000.00));
        productos.add(new Producto(R.drawable.joyeros_2, "Joyero", " en cuero sintetico 3 puestos, multifuncional", 35000.00));

        RecyclerView recyclerView = findViewById(R.id.productosRecyclerView);
        ProductoAdapter adapter = new ProductoAdapter(productos, producto -> {
            double total = calcularTotal();
            Toast.makeText(this, "Total: $" + total + "\nCompra exitosa", Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }
}