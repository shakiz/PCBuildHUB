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
    private ArrayList<ItemModel> osList , upsList , motherboardList , cpuList , ram1List , ram2List, storage1List , storage2List ,graphicsCardList , powerSupplyList , casingList
            ,monitorList , keyboardList , mouseList;
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
        graphicsCardList = new ArrayList<>();
        powerSupplyList = new ArrayList<>();
        casingList = new ArrayList<>();
        monitorList = new ArrayList<>();
        keyboardList = new ArrayList<>();
        mouseList = new ArrayList<>();
        upsList = new ArrayList<>();
        osList = new ArrayList<>();
    }

    private void bindUiWithComponents() {
        newConfigBinding.cpuButton.setOnClickListener(this);
        newConfigBinding.motherboardButton.setOnClickListener(this);
        newConfigBinding.ram1Button.setOnClickListener(this);
        newConfigBinding.ram2Button.setOnClickListener(this);
        newConfigBinding.storage1Button.setOnClickListener(this);
        newConfigBinding.storage2Button.setOnClickListener(this);
        newConfigBinding.graphicsCardButton.setOnClickListener(this);
        newConfigBinding.powerSupplyButton.setOnClickListener(this);
        newConfigBinding.casingButton.setOnClickListener(this);
        newConfigBinding.monitorButton.setOnClickListener(this);
        newConfigBinding.keyboardButton.setOnClickListener(this);
        newConfigBinding.mouseButton.setOnClickListener(this);
        newConfigBinding.osButton.setOnClickListener(this);
        newConfigBinding.upsButton.setOnClickListener(this);
    }


    private void setData(int contextId) {
        switch (contextId){
            case R.string.cpu:
                cpuList.add(new ItemModel("AMD Athlon 200GE AM4 Socket Desktop Processor with Radeon Vega 3 Graphics",5299,"21 Jun,2019","AMD Ryzen"));
                cpuList.add(new ItemModel("Intel Pentium Gold G5400 8th Gen Processor",5800,"13 July,2018","Intel"));
                setBuildItemAdapter(newConfigBinding.Cpu, cpuList);
                break;
            case R.string.motherboard:
                motherboardList.add(new ItemModel("ASRock A320M-HDV R4.0 AMD Motherboard",5600,"21 Oct,2019","AMD Ryzen"));
                motherboardList.add(new ItemModel("MSI B450M-A PRO MAX AMD AM4 Motherboard",7000,"22 Dec,2019","MSI"));
                motherboardList.add(new ItemModel("MSI B450M PRO-M2 MAX AMD AM4 Gaming Motherboard",5600,"21 Oct,2019","MSI"));
                setBuildItemAdapter(newConfigBinding.Motherboard, motherboardList);
                break;
            case R.string.ram1:
                ram1List.add(new ItemModel("TwinMOS 4GB DDR3 1600MHz",1700,"21 Oct,2019","TwinMOS"));
                ram1List.add(new ItemModel("Corsair Vengeance LPX 4GB (1x4GB) DDR4 DRAM 2400MHz",1800,"22 Dec,2019","Corsair"));
                ram1List.add(new ItemModel("Geil 4GB 1600mhz DDR3 Desktop Ram",1800,"21 Oct,2019","Geil"));
                setBuildItemAdapter(newConfigBinding.RAM1, ram1List);
                break;
            case R.string.ram2:
                ram2List.add(new ItemModel("Kingston DDR4 2400MHz 4GB Ram",1900,"21 Oct,2019","Kingston"));
                ram2List.add(new ItemModel("Team Elite Plus 4GB 2400MHz DDR4 Ram",1950,"22 Dec,2019","Elite"));
                ram2List.add(new ItemModel("Transcend 4GB DDR3 1333 MHz Desktop RAM",2000,"21 Oct,2019","Transcend"));
                setBuildItemAdapter(newConfigBinding.RAM2, ram2List);
                break;
            case R.string.storage_1:
                storage1List.add(new ItemModel("PNY CS900 120GB 2.5 inch SATA III Internal SSD",1800,"22 Jan,2017","PNY"));
                storage1List.add(new ItemModel("Gigabyte 120GB Solid State Drive (SSD)",1950,"25 Jan,2017","Gigabyte"));
                storage1List.add(new ItemModel("Adata SU 650 120 GB Solid State Drive",1800,"22 Jan,2017","Adata"));
                setBuildItemAdapter(newConfigBinding.Storage1, storage1List);
                break;
            case R.string.storage_2:
                storage2List.add(new ItemModel("Seagate Internal 1TB SATA Barracuda HDD",3750,"21 Feb 2019","Seagate"));
                storage2List.add(new ItemModel("Transcend J25A3K 1TB USB 3.0 Black External HDD",5000,"21 Feb 2019","Transcend"));
                storage2List.add(new ItemModel("Transcend StoreJet J25C3N 1TB External Hard Disk Drive (HDD)",5500,"21 Feb 2019","Transcend"));
                setBuildItemAdapter(newConfigBinding.Storage2, storage2List);
                break;
            case R.string.graphics_card:
                graphicsCardList.add(new ItemModel("GALAX GeForce GT 1030 EXOC White 2GB GDDR5 Graphics Card",7500,"21 Feb 2019","Galax"));
                graphicsCardList.add(new ItemModel("XFX AMD Radeon RX 570 RS 8GB XXX Edition Graphics Card",15800,"21 Feb 2019","AMD"));
                graphicsCardList.add(new ItemModel("Gigabyte GeForce GTX 1650 OC 4GB Graphics Card",17200,"21 Feb 2019","Gigabyte"));
                setBuildItemAdapter(newConfigBinding.GraphicsCard, graphicsCardList);
                break;
            case R.string.power_supply:
                powerSupplyList.add(new ItemModel("MaxGreen 500 Watt power supply",750,"21 Feb 2019","MaxGreen"));
                powerSupplyList.add(new ItemModel("Lian Li Strimer RGB 8 Pin Cable",5000,"21 Feb 2019","Lian"));
                powerSupplyList.add(new ItemModel("Gamdias Kratos E1-500 500 Watt RGB Power Supply",500,"21 Feb 2019","Gamidas"));
                setBuildItemAdapter(newConfigBinding.PowerSupply, powerSupplyList);
                break;
            case R.string.casing:
                casingList.add(new ItemModel("MaxGreen 2809BK Casing",2050,"21 Feb 2019","MaxGreen"));
                casingList.add(new ItemModel("KWG VELA M1 Mid Tower PC Case",3000,"21 Feb 2019","KWG"));
                casingList.add(new ItemModel("MaxGreen 2810BG ATX Casing",2500,"21 Feb 2019","MaxGreen"));
                setBuildItemAdapter(newConfigBinding.Casing, casingList);
                break;
            case R.string.monitor:
                monitorList.add(new ItemModel("ESONIC ES1701 17 Inch Square LED Monitor",7500,"21 Feb 2019","ESONIC"));
                monitorList.add(new ItemModel("Samsung S19F350HNW 18.5 Inch LED Monitor (VGA)",7500,"21 Feb 2019","Samsung"));
                setBuildItemAdapter(newConfigBinding.Monitor, monitorList);
                break;
            case R.string.keyboard:
                keyboardList.add(new ItemModel("Dell Wired Keyboard KB216-Black",750,"21 Feb 2019","Dell"));
                keyboardList.add(new ItemModel("A4tech KR-92 Wired Keyboard",750,"21 Feb 2019","A4tech"));
                setBuildItemAdapter(newConfigBinding.Keyboard, keyboardList);
                break;
            case R.string.mouse:
                mouseList.add(new ItemModel("A4TECH OP-730D 2X CLICK OPTICAL WIRED MOUSE",2050,"21 Feb 2019","A4tech"));
                mouseList.add(new ItemModel("Delux DLM 363BU Optical Mouse",2050,"21 Feb 2019","Delux"));
                setBuildItemAdapter(newConfigBinding.Mouse, mouseList);
                break;
            case R.string.operating_system:
                osList.add(new ItemModel("WIN Pro 10 64bit Eng INTL 1PK DSP OEM DVD",750,"21 Feb 2019","Microsoft"));
                setBuildItemAdapter(newConfigBinding.OperatingSystem, osList);
                break;
            case R.string.ups:
                upsList.add(new ItemModel("Digital X 650VA Offline UPS",2050,"21 Feb 2019","Digital"));
                upsList.add(new ItemModel("Power Pac 650VA Offline UPS",2050,"21 Feb 2019","Power"));
                setBuildItemAdapter(newConfigBinding.UPS, upsList);
                break;
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
            case R.id.graphicsCardButton:
                setData(R.string.graphics_card);
                break;
            case R.id.powerSupplyButton:
                setData(R.string.power_supply);
                break;
            case R.id.casingButton:
                setData(R.string.casing);
                break;
            case R.id.monitorButton:
                setData(R.string.monitor);
                break;
            case R.id.keyboardButton:
                setData(R.string.keyboard);
                break;
            case R.id.mouseButton:
                setData(R.string.mouse);
                break;
            case R.id.osButton:
                setData(R.string.operating_system);
                break;
            case R.id.upsButton:
                setData(R.string.ups);
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
