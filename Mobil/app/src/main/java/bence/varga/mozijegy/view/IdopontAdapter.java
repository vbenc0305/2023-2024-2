package bence.varga.mozijegy.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bence.varga.mozijegy.R;
import bence.varga.mozijegy.model.Vetites;

public class IdopontAdapter extends RecyclerView.Adapter<IdopontAdapter.ViewHolder> {
    private ArrayList<Vetites> vetiteslista;
    private Context context;
    private int lastPos = -1;

    public IdopontAdapter(Context context, ArrayList<Vetites> vetitesData) {
        if (context == null || vetitesData == null) {
            throw new IllegalArgumentException("Context or vetitesData cannot be null");
        }
        this.context = context;
        this.vetiteslista = vetitesData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.vetites_movies, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull IdopontAdapter.ViewHolder holder, int position) {
        Vetites currentvetites = vetiteslista.get(position);
        holder.bindTo(currentvetites);

        if(holder.getAdapterPosition()>lastPos){
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.sliderow);
            holder.itemView.startAnimation(animation);
            lastPos = holder.getAdapterPosition();
        }
    }

    @Override
    public int getItemCount() {
        return vetiteslista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView vetitesideje;
        private TextView szekekszama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vetitesideje = itemView.findViewById(R.id.vetitesideje);
            szekekszama = itemView.findViewById(R.id.szekekszama);

            itemView.findViewById(R.id.foglalasbtn).setOnClickListener(v -> {
                Log.d("IdopontAdapter", "button clicked");
            });
        }

        public void bindTo(Vetites currentvetites) {
            if (currentvetites.getVetitesIdeje() != null) {
                vetitesideje.setText(currentvetites.getVetitesIdeje().toString());
            }

            szekekszama.setText(String.valueOf(currentvetites.getSzekek_szama()));
        }

    }
}
