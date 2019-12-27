package com.shakil.pcbuildhub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.model.buildyourpc.BuildYourPc;
import com.shakil.pcbuildhub.model.dashboard.ItemModel;
import com.shakil.pcbuildhub.model.post.PostModel;

import java.util.ArrayList;

public class BuildYourPcAdapter extends RecyclerView.Adapter<BuildYourPcAdapter.ViewHolder> {

    private ArrayList<BuildYourPc> buildYourPcList;
    private Context context;
    private onItemClickListener onItemClickListener;

    public BuildYourPcAdapter(ArrayList<BuildYourPc> buildYourPcList, Context context ,onItemClickListener onItemClickListener) {
        this.buildYourPcList = buildYourPcList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout_build_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BuildYourPc buildYourPc = buildYourPcList.get(position);
        holder.Title.setText(buildYourPc.getTitle());
        holder.PostDate.setText(buildYourPc.getPostDate());
        holder.Category.setText(buildYourPc.getCategory());
        holder.TotalAmount.setText("Total :: "+buildYourPc.getTotalAmount());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.respond(buildYourPc);
            }
        });
    }

    @Override
    public int getItemCount() {
        return buildYourPcList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Title , PostDate , Category , TotalAmount;
        LinearLayout linearLayout;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.Title);
            PostDate = itemView.findViewById(R.id.PostDate);
            Category = itemView.findViewById(R.id.Category);
            TotalAmount = itemView.findViewById(R.id.TotalAmount);
            linearLayout = itemView.findViewById(R.id.adapter_main_layout);
            cardView = itemView.findViewById(R.id.adapter_cardview);
        }
    }

    public interface onItemClickListener {
        void respond(BuildYourPc buildYourPc);
    }
}
