package com.example.exam4_apilifecard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        View view = LayoutInflater.from(context).inflate(R.layout.province_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListArea listArea = listAreas.get(position);
        holder.tvProvince.setText(listArea.getAreaName());
        holder.tvProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, holder.tvProvince.getText().toString(), Toast.LENGTH_SHORT).show();
                holder.tvProvince.setBackgroundColor(2);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (listAreas == null)
            return 0;
        return listAreas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvProvince;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProvince = itemView.findViewById(R.id.tvProvince);
        }
    }
}
