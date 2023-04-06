package com.ching.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.CountryViewHolder> {

    private ArrayList<String> countryNameList ;
    private ArrayList<String> detailList;
    private ArrayList<Integer> imageList;
    private Context context;

    public RecyclerAdapter(ArrayList<String> countryNameList, ArrayList<String> detailList, ArrayList<Integer> imageList, Context context) {
        this.countryNameList = countryNameList;
        this.detailList = detailList;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        holder.textViewCountryName.setText(countryNameList.get(position));
        holder.textViewDetails.setText(detailList.get(position));
        holder.imageView.setImageResource(imageList.get(position));

        holder.cardView.setOnClickListener(view -> {
            if (position == 0) {
                Toast.makeText(context, "You selected the Philippines", Toast.LENGTH_SHORT).show();
            } else if (position == 1) {
                Toast.makeText(context, "You selected the Indonesia", Toast.LENGTH_SHORT).show();
            } else if (position == 2) {
                Toast.makeText(context, "You selected the Vietnam", Toast.LENGTH_SHORT).show();
            } else if (position == 3) {
                Toast.makeText(context, "You selected the Taiwan", Toast.LENGTH_SHORT).show();
            } else if (position == 4) {
                Toast.makeText(context, "You selected the Malaysia", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryNameList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCountryName, textViewDetails;
        private ImageView imageView;
        private CardView cardView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewCountryName);
            textViewDetails = itemView.findViewById(R.id.textViewDetails);
            imageView = itemView.findViewById(R.id.imageV);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
