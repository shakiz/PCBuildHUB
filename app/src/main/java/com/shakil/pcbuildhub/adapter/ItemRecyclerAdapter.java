package com.shakil.pcbuildhub.adapter;

import android.app.AppComponentFactory;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.fragments.FragmentAddConfig;
import com.shakil.pcbuildhub.model.ItemModel;
import java.util.ArrayList;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ItemModel> itemModelList;
    private Dialog dialog;

    public ItemRecyclerAdapter(Context context, ArrayList<ItemModel> itemModelList, Dialog dialog) {
        this.context = context;
        this.itemModelList = itemModelList;
        this.dialog = dialog;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout_recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemModel itemModel = itemModelList.get(position);
        holder.title.setText(itemModel.getTitle());
        holder.price.setText("Price : "+itemModel.getPrice());
        holder.companyName.setText("Company : "+itemModel.getCompanyName());
        holder.arrivedDate.setText("Arrived On : "+itemModel.getArrivedDate());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("motherboard",itemModel.getTitle());
                dialog.dismiss();
                navigate(bundle);
            }
        });
    }

    private void navigate(Bundle bundle) {
        FragmentAddConfig addConfig = new FragmentAddConfig();
        addConfig.setArguments(bundle);
        FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container,addConfig).commit();
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,companyName,price,arrivedDate;
        Button add,details;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            companyName = itemView.findViewById(R.id.companyName);
            arrivedDate = itemView.findViewById(R.id.arrivedDate);
            add = itemView.findViewById(R.id.addItem);
            details = itemView.findViewById(R.id.details);
        }
    }
}
