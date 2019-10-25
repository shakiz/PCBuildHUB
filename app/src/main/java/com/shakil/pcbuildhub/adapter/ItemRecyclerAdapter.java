package com.shakil.pcbuildhub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.model.ItemModel;
import java.util.ArrayList;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ItemModel> itemModelList;

    public ItemRecyclerAdapter(Context context, ArrayList<ItemModel> itemModelList) {
        this.context = context;
        this.itemModelList = itemModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout_recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel itemModel = itemModelList.get(position);
        holder.title.setText(itemModel.getTitle());
        holder.price.setText("Price : "+itemModel.getPrice());
        holder.companyName.setText("Company : "+itemModel.getCompanyName());
        holder.arrivedDate.setText("Arrived On : "+itemModel.getArrivedDate());
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,companyName,price,arrivedDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            companyName = itemView.findViewById(R.id.companyName);
            arrivedDate = itemView.findViewById(R.id.arrivedDate);
        }
    }
}
