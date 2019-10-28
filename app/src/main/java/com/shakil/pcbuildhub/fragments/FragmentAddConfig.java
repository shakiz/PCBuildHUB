package com.shakil.pcbuildhub.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.adapter.ItemRecyclerAdapter;
import com.shakil.pcbuildhub.model.ItemModel;
import java.util.ArrayList;

public class FragmentAddConfig extends Fragment implements View.OnClickListener {

    private static final FragmentAddConfig FRAGMENT_ADD_CONFIG = null;
    private Button chooseMotherBoard;
    private Context context;
    private ItemRecyclerAdapter itemRecyclerAdapter;
    private ArrayList<ItemModel> motherboardList;
    private RecyclerView motherboardRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayout dialogLayout;
    private TextView motherboardTXTview;
    private Dialog itemDialog;

    public static synchronized FragmentAddConfig getInstance(){
        if (FRAGMENT_ADD_CONFIG == null) return new FragmentAddConfig();
        else return FRAGMENT_ADD_CONFIG;
    }

    public FragmentAddConfig() {
        
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_config, container, false);
        init(view);
        bindUiWithComponents();
        return view;
    }

    private void init(View view) {
        chooseMotherBoard = view.findViewById(R.id.motherboardButton);
        motherboardTXTview = view.findViewById(R.id.selectedMotherboard);
    }

    private void customViewInit(Dialog itemDialog) {
        motherboardRecyclerView = itemDialog.findViewById(R.id.genericRecyclerView);
        dialogLayout = itemDialog.findViewById(R.id.dialogLinearLayout);
        motherboardList = new ArrayList<>();
    }

    private void bindUiWithComponents() {
        chooseMotherBoard.setOnClickListener(this);
        getAndSetItemValue();
    }

    private void getAndSetItemValue() {
        try {
            if (!getArguments().getString("motherboard").isEmpty()){
                motherboardTXTview.setVisibility(View.VISIBLE);
                motherboardTXTview.setText(getArguments().getString("motherboard"));
            }}
        catch (Exception e){ e.printStackTrace();}
    }

    private ArrayList<ItemModel> setData() {
        motherboardList.add(new ItemModel("ASRock A320M-HDV R4.0 AMD Motherboard",5600,"21 Oct,2019","AMD"));
        motherboardList.add(new ItemModel("MSI B450M-A PRO MAX AMD AM4 Motherboard",7000,"22 Dec,2019","MSI"));
        motherboardList.add(new ItemModel("MSI B450M PRO-M2 MAX AMD AM4 Gaming Motherboard",5600,"21 Oct,2019","MSI"));
        motherboardList.add(new ItemModel("Asrock B450M Pro4 AMD Motherboard",8000,"21 Jun,2019","AMD"));
        motherboardList.add(new ItemModel("ASRock X399 Taichi USB 3.1 ATX AMD Motherboard",36000,"21 Oct,2019","AMD"));
        motherboardList.add(new ItemModel("MSI X570-A Pro DDR4 AMD AM4 Socket Motherboard",17500,"21 Feb,2019","MSI"));
        motherboardList.add(new ItemModel("ASRock A320M-HDV R4.0 AMD Motherboard",5600,"21 Oct,2019","AMD"));
        return motherboardList;
    }

    private void setMotherboardAdapter() {
        itemRecyclerAdapter = new ItemRecyclerAdapter(context,setData(),itemDialog);
        layoutManager = new LinearLayoutManager(context);
        motherboardRecyclerView.setLayoutManager(layoutManager);
        motherboardRecyclerView.setAdapter(itemRecyclerAdapter);
        itemRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.motherboardButton:
                showDialog();
        }
    }

    private void showDialog() {
        itemDialog = new Dialog(context);
        itemDialog.setContentView(R.layout.generic_list_layout);
        customViewInit(itemDialog);
        itemDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setMotherboardAdapter();
        Animation a = AnimationUtils.loadAnimation(itemDialog.getContext(), R.anim.push_up_in);
        dialogLayout.startAnimation(a);
        itemDialog.show();
    }
}
