package com.shakil.pcbuildhub.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.shakil.pcbuildhub.HomeActivity;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.adapter.ItemRecyclerAdapter;
import com.shakil.pcbuildhub.databinding.ActivityAddNewConfigBinding;
import com.shakil.pcbuildhub.model.ItemModel;
import java.util.ArrayList;

public class AddNewConfigActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private ItemRecyclerAdapter itemRecyclerAdapter;
    private ArrayList<ItemModel> motherboardList , cpuList , ram1List , ram2List, storage1List , storage2List;
    private RecyclerView itemRecyclerView;
    private LinearLayout dialogLayout;
    private Dialog itemDialog;
    private ActivityAddNewConfigBinding newConfigBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newConfigBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_config);
        init();

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNewConfigActivity.this, HomeActivity.class));
            }
        });

        bindUiWithComponents();
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
    }

    private void customViewInit(Dialog itemDialog) {
        itemRecyclerView = itemDialog.findViewById(R.id.genericRecyclerView);
        dialogLayout = itemDialog.findViewById(R.id.dialogLinearLayout);
        motherboardList = new ArrayList<>();
        cpuList = new ArrayList<>();
        ram1List = new ArrayList<>();
        ram2List = new ArrayList<>();
        storage1List = new ArrayList<>();
        storage2List = new ArrayList<>();
    }

    private void bindUiWithComponents() {
        newConfigBinding.cpuButton.setOnClickListener(this);
        newConfigBinding.motherboardButton.setOnClickListener(this);
        newConfigBinding.ram1Button.setOnClickListener(this);
        newConfigBinding.ram2Button.setOnClickListener(this);
        newConfigBinding.storage1Button.setOnClickListener(this);
        newConfigBinding.storage2Button.setOnClickListener(this);
    }


    private void setData(int contextId) {
        switch (contextId){
            case R.string.cpu:
                cpuList.add(new ItemModel("AMD Athlon 200GE AM4 Socket Desktop Processor with Radeon Vega 3 Graphics",5299,"21 Jun,2019","AMD Ryzen"));
                cpuList.add(new ItemModel("Intel Pentium Gold G5400 8th Gen Processor",5800,"13 July,2018","Intel"));
                setBuildItemAdapter(newConfigBinding.Cpu, cpuList);
                return;
            case R.string.motherboard:
                motherboardList.add(new ItemModel("ASRock A320M-HDV R4.0 AMD Motherboard",5600,"21 Oct,2019","AMD Ryzen"));
                motherboardList.add(new ItemModel("MSI B450M-A PRO MAX AMD AM4 Motherboard",7000,"22 Dec,2019","MSI"));
                motherboardList.add(new ItemModel("MSI B450M PRO-M2 MAX AMD AM4 Gaming Motherboard",5600,"21 Oct,2019","MSI"));
                setBuildItemAdapter(newConfigBinding.Motherboard, motherboardList);
                return;
            case R.string.ram1:
                ram1List.add(new ItemModel("TwinMOS 4GB DDR3 1600MHz",1700,"21 Oct,2019","TwinMOS"));
                ram1List.add(new ItemModel("Corsair Vengeance LPX 4GB (1x4GB) DDR4 DRAM 2400MHz",1800,"22 Dec,2019","Corsair"));
                ram1List.add(new ItemModel("Geil 4GB 1600mhz DDR3 Desktop Ram",1800,"21 Oct,2019","Geil"));
                setBuildItemAdapter(newConfigBinding.RAM1, ram1List);
                return;
            case R.string.ram2:
                ram2List.add(new ItemModel("Kingston DDR4 2400MHz 4GB Ram",1900,"21 Oct,2019","Kingston"));
                ram2List.add(new ItemModel("Team Elite Plus 4GB 2400MHz DDR4 Ram",1950,"22 Dec,2019","Elite"));
                ram2List.add(new ItemModel("Transcend 4GB DDR3 1333 MHz Desktop RAM",2000,"21 Oct,2019","Transcend"));
                setBuildItemAdapter(newConfigBinding.RAM2, ram2List);
                return;
            case R.string.storage_1:
                storage1List.add(new ItemModel("PNY CS900 120GB 2.5 inch SATA III Internal SSD",1800,"22 Jan,2017","PNY"));
                storage1List.add(new ItemModel("Gigabyte 120GB Solid State Drive (SSD)",1950,"25 Jan,2017","Gigabyte"));
                storage1List.add(new ItemModel("Adata SU 650 120 GB Solid State Drive",1800,"22 Jan,2017","Adata"));
                setBuildItemAdapter(newConfigBinding.Storage1, storage1List);
                return;
            case R.string.storage_2:
                storage2List.add(new ItemModel("Seagate Internal 1TB SATA Barracuda HDD",3750,"21 Feb 2019","Seagate"));
                storage2List.add(new ItemModel("Transcend J25A3K 1TB USB 3.0 Black External HDD",5000,"21 Feb 2019","Transcend"));
                storage2List.add(new ItemModel("Transcend StoreJet J25C3N 1TB External Hard Disk Drive (HDD)",5500,"21 Feb 2019","Transcend"));
                setBuildItemAdapter(newConfigBinding.Storage2, storage2List);
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
                if (valueTXT.getVisibility() == View.GONE)valueTXT.setVisibility(View.VISIBLE);
                valueTXT.setText(itemModel.getTitle());
            }
        });
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemRecyclerView.setAdapter(itemRecyclerAdapter);
        itemRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        showDialog();
        switch (view.getId()){
            case R.id.cpuButton:
                setData(R.string.cpu);
                break;
            case R.id.motherboardButton:
                setData(R.string.motherboard);
                break;
            case R.id.ram1Button:
                setData(R.string.ram1);
                break;
            case R.id.ram2Button:
                setData(R.string.ram2);
                break;
            case R.id.storage1Button:
                setData(R.string.storage_1);
                break;
            case R.id.storage2Button:
                setData(R.string.storage_2);
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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AddNewConfigActivity.this, HomeActivity.class));
    }
}
