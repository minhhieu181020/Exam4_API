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

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder> {
    private List<ListArea> listAreas;
    private Context context;

    public ProvinceAdapter(List<ListArea> listAreas, Context context) {
        this.listAreas = listAreas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.province_list, parent, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvProvince;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProvince=itemView.findViewById(R.id.tvProvince);
        }
    }
}
