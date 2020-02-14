package com.shakil.pcbuildhub.activities.addnewpost;

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
import com.shakil.pcbuildhub.activities.onboard.HomeActivity;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.adapter.ItemRecyclerAdapter;
import com.shakil.pcbuildhub.databinding.ActivityAddNewConfigBinding;
import com.shakil.pcbuildhub.model.dashboard.ItemModel;
import com.shakil.pcbuildhub.utils.DumpDummyData;
import com.shakil.pcbuildhub.utils.Ux;
import java.util.ArrayList;

public class AddNewPostActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private ItemRecyclerAdapter itemRecyclerAdapter;
    private ArrayList<ItemModel> osList , upsList , motherboardList , cpuList , ram1List , ram2List, storage1List , storage2List ,graphicsCardList , powerSupplyList , casingList
            ,monitorList , keyboardList , mouseList;
    private RecyclerView itemRecyclerView;
    private LinearLayout dialogLayout;
    private Dialog itemDialog;
    private int TotalAmount = 0;
    private ActivityAddNewConfigBinding newConfigBinding;
    private DumpDummyData dumpDummyData;
    private Ux ux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newConfigBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_config);
        init();

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNewPostActivity.this, HomeActivity.class));
            }
        });

        bindUiWithComponents();
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
        ux = new Ux(this);
    }

    private void customViewInit(Dialog itemDialog) {
        itemRecyclerView = itemDialog.findViewById(R.id.genericRecyclerView);
        dialogLayout = itemDialog.findViewById(R.id.dialogLinearLayout);
        dumpDummyData = new DumpDummyData(this);
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

        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        newConfigBinding.parentContainer.startAnimation(a);

        //region set spinnerAdapter start
        ux.setSpinnerAdapter(newConfigBinding.Category,new String[]{"Gaming","Production","Streaming"});
        //region spinnerAdapter end

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

        newConfigBinding.saveConfig.setOnClickListener(this);
        newConfigBinding.refreshConfig.setOnClickListener(this);
    }

    private void setBuildItemAdapter(final TextView valueTXT, ArrayList<ItemModel> dataList) {
        itemRecyclerAdapter = new ItemRecyclerAdapter(this, dataList, itemDialog, new ItemRecyclerAdapter.onAddClickListener() {
            @Override
            public void respond(ItemModel itemModel) {
                if (valueTXT.getVisibility() == View.GONE)valueTXT.setVisibility(View.VISIBLE);
                valueTXT.setText(itemModel.getTitle());
                TotalAmount += itemModel.getPrice();
                newConfigBinding.TotalAmount.setText("Total Amount : "+TotalAmount);
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
                setBuildItemAdapter(newConfigBinding.Cpu, dumpDummyData.setData(R.string.cpu));
                break;
            case R.id.motherboardButton:
                setBuildItemAdapter(newConfigBinding.Motherboard, dumpDummyData.setData(R.string.motherboard));
                break;
            case R.id.ram1Button:
                setBuildItemAdapter(newConfigBinding.RAM1, dumpDummyData.setData(R.string.ram1));
                break;
            case R.id.ram2Button:
                setBuildItemAdapter(newConfigBinding.RAM2, dumpDummyData.setData(R.string.ram2));
                break;
            case R.id.storage1Button:
                setBuildItemAdapter(newConfigBinding.Storage1, dumpDummyData.setData(R.string.storage_1));
                break;
            case R.id.storage2Button:
                setBuildItemAdapter(newConfigBinding.Storage2, dumpDummyData.setData(R.string.storage_2));
                break;
            case R.id.graphicsCardButton:
                setBuildItemAdapter(newConfigBinding.GraphicsCard, dumpDummyData.setData(R.string.graphics_card));
                break;
            case R.id.powerSupplyButton:
                setBuildItemAdapter(newConfigBinding.PowerSupply, dumpDummyData.setData(R.string.power_supply));
                break;
            case R.id.casingButton:
                setBuildItemAdapter(newConfigBinding.Casing, dumpDummyData.setData(R.string.casing));
                break;
            case R.id.monitorButton:
                setBuildItemAdapter(newConfigBinding.Monitor, dumpDummyData.setData(R.string.monitor));
                break;
            case R.id.keyboardButton:
                setBuildItemAdapter(newConfigBinding.Keyboard, dumpDummyData.setData(R.string.keyboard));
                break;
            case R.id.mouseButton:
                setBuildItemAdapter(newConfigBinding.Mouse, dumpDummyData.setData(R.string.mouse));
                break;
            case R.id.osButton:
                setBuildItemAdapter(newConfigBinding.OperatingSystem, dumpDummyData.setData(R.string.operating_system));
                break;
            case R.id.upsButton:
                setBuildItemAdapter(newConfigBinding.UPS, dumpDummyData.setData(R.string.ups));
                break;
            case R.id.saveConfig:
                Toast.makeText(getApplicationContext(),R.string.saved,Toast.LENGTH_SHORT).show();
                clearUI();
                itemDialog.dismiss();
                break;
            case R.id.refreshConfig:
                clearUI();
                itemDialog.dismiss();
                break;
        }
    }

    private void clearUI() {
        int[] configTextResIds = new int[]{R.id.Cpu,R.id.Motherboard,R.id.RAM1,R.id.RAM2, R.id.Storage1,R.id.Storage2,R.id.GraphicsCard,R.id.PowerSupply,R.id.Casing,R.id.Monitor,
                    R.id.Keyboard,R.id.Mouse,R.id.OperatingSystem,R.id.UPS};
        ux.clearDetailsUI(configTextResIds,getWindow().getDecorView());
        newConfigBinding.title.setText("");
        newConfigBinding.TotalAmount.setText("Total here");
        //region set spinnerAdapter start
        ux.setSpinnerAdapter(newConfigBinding.Category,new String[]{"Gaming","Production","Streaming"});
        //region spinnerAdapter end
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
        startActivity(new Intent(AddNewPostActivity.this, HomeActivity.class));
    }
}
