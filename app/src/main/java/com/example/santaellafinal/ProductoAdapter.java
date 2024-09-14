package com.example.santaellafinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private List<Producto> productos;
    private OnItemClickListener listener; // Para manejar clics en el botón "Comprar"

    // Interfaz para manejar clics en los items
    public interface OnItemClickListener {
        void onItemClick(Producto producto);
    }

    public ProductoAdapter(List<Producto> productos, OnItemClickListener listener) {
        this.productos = productos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item_producto, parent, false);
        return new ProductoViewHolder(itemView, listener); // Pasa el listener al ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.imagenProducto.setImageResource(producto.getImagen());
        holder.tituloProducto.setText(producto.getTitulo());
        holder.descripcionProducto.setText(producto.getDescripcion());
        holder.precioProducto.setText(String.format("$%.2f", producto.getPrecio())); // Formatear el precio

        // Manejar clics en el botón "Comprar"
        holder.botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                producto.setCantidad(producto.getCantidad() + 1); // Incrementa la cantidad
                notifyItemChanged(position); // Notifica al adaptador del cambio
                if (listener != null) {
                    listener.onItemClick(producto);
                }
            } // Cierra el método onClick
        }); // Cierra el setOnClickListener
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    // ViewHolder para cada item del RecyclerView
    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagenProducto;
        public TextView tituloProducto;
        public TextView descripcionProducto;
        public TextView precioProducto;
        public Button botonComprar;

        public ProductoViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            imagenProducto = itemView.findViewById(R.id.imagenProducto);
            tituloProducto = itemView.findViewById(R.id.tituloProducto);
            descripcionProducto = itemView.findViewById(R.id.descripcionProducto);
            precioProducto = itemView.findViewById(R.id.precioProducto);
            botonComprar = itemView.findViewById(R.id.botonComprar);

            // Manejar clics en el item (opcional)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(productos.get(position));
                    }
                }
            });
        }
    }
}