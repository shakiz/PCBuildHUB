package com.shakil.pcbuildhub.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.adapter.ItemRecyclerAdapter;
import com.shakil.pcbuildhub.model.ItemModel;
import java.util.ArrayList;

public class AddNewConfigActivity extends AppCompatActivity implements View.OnClickListener{

    private Button chooseMotherBoard , cpuButton;
    private ItemRecyclerAdapter itemRecyclerAdapter;
    private ArrayList<ItemModel> motherboardList , cpuList;
    private RecyclerView itemRecyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayout dialogLayout;
    private Dialog itemDialog;
    private TextView cpuTXT , motherboardTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_config);
        init();
        bindUiWithComponents();
    }

    private void init() {
        chooseMotherBoard = findViewById(R.id.motherboardButton);
        cpuButton = findViewById(R.id.cpuButton);
        cpuTXT = findViewById(R.id.Cpu);
        motherboardTXT = findViewById(R.id.Motherboard);
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
    }


    private void setData(int itemNameResId) {
        motherboardList.clear();
        cpuList.clear();
        switch (itemNameResId){
            case R.string.cpu:
                cpuList.add(new ItemModel("AMD Athlon 200GE AM4 Socket Desktop Processor with Radeon Vega 3 Graphics",5299,"21 Jun,2019","AMD Ryzen"));
                cpuList.add(new ItemModel("Intel Pentium Gold G5400 8th Gen Processor",5800,"13 July,2018","Intel"));
                setBuildItemAdapter(cpuTXT, cpuList);
                cpuTXT.setVisibility(View.VISIBLE);
                return;
            case R.string.motherboard:
                motherboardList.add(new ItemModel("ASRock A320M-HDV R4.0 AMD Motherboard",5600,"21 Oct,2019","AMD Ryzen"));
                motherboardList.add(new ItemModel("MSI B450M-A PRO MAX AMD AM4 Motherboard",7000,"22 Dec,2019","MSI"));
                motherboardList.add(new ItemModel("MSI B450M PRO-M2 MAX AMD AM4 Gaming Motherboard",5600,"21 Oct,2019","MSI"));
                setBuildItemAdapter(motherboardTXT, motherboardList);
                return;
            default:
                break;
        }
    }

    private void setBuildItemAdapter(final TextView valueTXT, ArrayList<ItemModel> dataList) {
        itemRecyclerAdapter = new ItemRecyclerAdapter(this, dataList, itemDialog, new ItemRecyclerAdapter.onAddClickListener() {
            @Override
            public void respond(ItemModel itemModel) {
                Toast.makeText(getApplicationContext(),""+itemModel.getTitle(),Toast.LENGTH_SHORT).show();
                valueTXT.setVisibility(View.VISIBLE);
                valueTXT.setText(itemModel.getTitle());
            }
        });
        layoutManager = new LinearLayoutManager(this);
        itemRecyclerview.setLayoutManager(layoutManager);
        itemRecyclerview.setAdapter(itemRecyclerAdapter);
        itemRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cpuButton:
                showDialog();
                setData(R.string.cpu);
                break;
            case R.id.motherboardButton:
                showDialog();
                setData(R.string.motherboard);
                break;
        }
    }

    private void showDialog() {
        itemDialog = new Dialog(this);
        itemDialog.setContentView(R.layout.generic_list_layout);
        customViewInit(itemDialog);
        itemDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Animation a = AnimationUtils.loadAnimation(itemDialog.getContext(), R.anim.push_up_in);
        dialogLayout.startAnimation(a);
        itemDialog.show();
    }
}
