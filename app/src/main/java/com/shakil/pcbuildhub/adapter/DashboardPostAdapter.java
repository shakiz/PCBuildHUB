package com.shakil.pcbuildhub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.model.PostModel;
import java.util.ArrayList;
import java.util.Random;

public class DashboardPostAdapter extends RecyclerView.Adapter<DashboardPostAdapter.ViewHolder> {

    private ArrayList<PostModel> postModelList;
    private Context context;
    private Random random = new Random();

    public DashboardPostAdapter(ArrayList<PostModel> postModelList, Context context) {
        this.postModelList = postModelList;
        this.context = context;
    }

    public DashboardPostAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout_post_dashboard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostModel postModel = postModelList.get(position);
        holder.title.setText(postModel.getTitle());
        holder.postBy.setText(postModel.getPostBy());
        holder.date.setText(postModel.getDate());
        holder.linearLayout.getLayoutParams().height = getRandomIntInRange(200,150);
    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    // Custom method to get a random number between a range
    protected int getRandomIntInRange(int max, int min){
        return random.nextInt((max-min)+min)+min;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,postBy,date;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            postBy = itemView.findViewById(R.id.postBy);
            date = itemView.findViewById(R.id.date);
            linearLayout = itemView.findViewById(R.id.content_layout);
        }
    }
}
