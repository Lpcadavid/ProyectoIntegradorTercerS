package com.example.santaellafinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CatalogoAdapter extends RecyclerView.Adapter<CatalogoAdapter.CatalogoViewHolder> {

    private Context context;
    private List<Producto> productos;
    private int itemLayoutId;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Producto producto);
    }

    public CatalogoAdapter(Context context, List<Producto> productos, int itemLayoutId, OnItemClickListener listener) {
        this.context = context;
        this.productos = productos;
        this.itemLayoutId = itemLayoutId;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CatalogoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(itemLayoutId, parent, false);
        return new CatalogoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogoViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.imagenProducto.setImageResource(producto.getImagen());
        holder.tituloProducto.setText(producto.getTitulo());
        holder.precioProducto.setText(String.format("$%.2f", producto.getPrecio()));


        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(producto);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

   
    public static class CatalogoViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagenProducto;
        public TextView tituloProducto;
        public TextView precioProducto;

        public CatalogoViewHolder(View itemView) {
            super(itemView);
            imagenProducto = itemView.findViewById(R.id.imagenProductoCatalogo);
            tituloProducto = itemView.findViewById(R.id.tituloProductoCatalogo);
            precioProducto = itemView.findViewById(R.id.precioProductoCatalogo);
        }
    }
}