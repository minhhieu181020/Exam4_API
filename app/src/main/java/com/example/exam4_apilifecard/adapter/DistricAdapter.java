package com.example.exam4_apilifecard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam4_apilifecard.R;
import com.example.exam4_apilifecard.model.ListArea;

import java.util.List;

public class DistricAdapter extends RecyclerView.Adapter<DistricAdapter.ViewHolder> {

    private List<ListArea> listAreas;
    private Context context;

    public DistricAdapter(List<ListArea> listAreas, Context context) {
        this.listAreas = listAreas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.distric_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListArea listArea = listAreas.get(position);
        holder.tvDistric.setText(listArea.getAreaName());
    }

    @Override
    public int getItemCount() {
        if (listAreas == null)
            return 0;
        return listAreas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDistric;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDistric = itemView.findViewById(R.id.tvDistric);
        }
    }
}
