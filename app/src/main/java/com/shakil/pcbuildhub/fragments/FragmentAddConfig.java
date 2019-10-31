package com.shakil.pcbuildhub.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.adapter.ItemRecyclerAdapter;
import com.shakil.pcbuildhub.model.ItemModel;
import java.util.ArrayList;
import java.util.HashMap;

public class FragmentAddConfig extends Fragment implements View.OnClickListener {

    private static final FragmentAddConfig FRAGMENT_ADD_CONFIG = null;
    private Button chooseMotherBoard , cpuButton;
    private Context context;
    private ItemRecyclerAdapter itemRecyclerAdapter;
    private ArrayList<ItemModel> motherboardList , cpuList;
    private HashMap<String,String> itemNameHashMap;
    private RecyclerView itemRecyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayout dialogLayout;
    private RelativeLayout parentLayout;
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
        parentLayout = view.findViewById(R.id.parent_container);
        chooseMotherBoard = view.findViewById(R.id.motherboardButton);
        cpuButton = view.findViewById(R.id.cpuButton);
        itemNameHashMap = new HashMap<>();
    }

    private void customViewInit(Dialog itemDialog) {
        itemRecyclerview = itemDialog.findViewById(R.id.genericRecyclerView);
        dialogLayout = itemDialog.findViewById(R.id.dialogLinearLayout);
        motherboardList = new ArrayList<>();
        cpuList = new ArrayList<>();
    }

    private void bindUiWithComponents() {
        cpuButton.setOnClickListener(this);
        chooseMotherBoard.setOnClickListener(this);
        getAndSetItemValue(R.id.Cpu,R.string.cpu);
        getAndSetItemValue(R.id.Motherboard,R.string.motherboard);
    }

    private void getAndSetItemValue(int resID,int valueResID) {

        try { getBundleValue(resID,valueResID); }
        catch (Exception e){ e.printStackTrace();}
    }

    private void getBundleValue(int resID,int valueResID) {
        TextView textView = parentLayout.findViewById(resID);
        String value = "";
        switch (valueResID){
            case R.string.cpu:
                value = getArguments().getString("cpu");
                break;
            case R.string.motherboard:
                value = getArguments().getString("motherboard");
                break;
            default:
                value = "";
        }
        itemNameHashMap.put(getResources().getString(valueResID),value);
        Log.i("itemName",value);
        if (!value.isEmpty()){
            textView.setVisibility(View.VISIBLE);
            textView.setText(itemNameHashMap.get(getResources().getString(valueResID)));
        }
    }

    private ArrayList<ItemModel> setData(int itemNameResId) {
        motherboardList.clear();
        cpuList.clear();
        switch (itemNameResId){
            case R.string.cpu:
                cpuList.add(new ItemModel("AMD Athlon 200GE AM4 Socket Desktop Processor with Radeon Vega 3 Graphics",5299,"21 Jun,2019","AMD Ryzen"));
                cpuList.add(new ItemModel("Intel Pentium Gold G5400 8th Gen Processor",5800,"13 July,2018","Intel"));
                return cpuList;
            case R.string.motherboard:
                motherboardList.add(new ItemModel("ASRock A320M-HDV R4.0 AMD Motherboard",5600,"21 Oct,2019","AMD Ryzen"));
                motherboardList.add(new ItemModel("MSI B450M-A PRO MAX AMD AM4 Motherboard",7000,"22 Dec,2019","MSI"));
                motherboardList.add(new ItemModel("MSI B450M PRO-M2 MAX AMD AM4 Gaming Motherboard",5600,"21 Oct,2019","MSI"));
                return motherboardList;
            default:
                break;
        }
        return null;
    }

    private void setBuildItemAdapter(int itemResId) {
        itemRecyclerAdapter = new ItemRecyclerAdapter(context,setData(itemResId),itemDialog,itemResId);
        layoutManager = new LinearLayoutManager(context);
        itemRecyclerview.setLayoutManager(layoutManager);
        itemRecyclerview.setAdapter(itemRecyclerAdapter);
        itemRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cpuButton:
                showDialog();
                setBuildItemAdapter(R.string.cpu);
                break;
            case R.id.motherboardButton:
                showDialog();
                setBuildItemAdapter(R.string.motherboard);
                break;
        }
    }

    private void showDialog() {
        itemDialog = new Dialog(context);
        itemDialog.setContentView(R.layout.generic_list_layout);
        customViewInit(itemDialog);
        itemDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Animation a = AnimationUtils.loadAnimation(itemDialog.getContext(), R.anim.push_up_in);
        dialogLayout.startAnimation(a);
        itemDialog.show();
    }

    private void setLayoutVisibility(int layoutResId, ArrayList<?> dataList){
        LinearLayout linearLayout = (LinearLayout)parentLayout.findViewById(layoutResId);
        if (dataList.size() > 0)linearLayout.setVisibility(View.VISIBLE);
    }
}
