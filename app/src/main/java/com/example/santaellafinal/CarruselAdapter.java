package com.example.santaellafinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarruselAdapter extends RecyclerView.Adapter<CarruselAdapter.CarruselViewHolder> {

    private List<Integer> imagenes;

    public CarruselAdapter(List<Integer> imagenes) {
        this.imagenes = imagenes;
    }

    @NonNull
    @Override
    public CarruselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carrusel, parent, false);
        return new CarruselViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarruselViewHolder holder, int position) {
        holder.imagen.setImageResource(imagenes.get(position));
    }

    @Override
    public int getItemCount() {
        return imagenes.size();
    }

    public static class CarruselViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;

        public CarruselViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenCarrusel);
        }
    }
}