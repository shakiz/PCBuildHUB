package com.shakil.pcbuildhub.utils;

import android.content.Context;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.model.dashboard.ItemModel;
import java.util.ArrayList;

public class DumpDummyData {
    private Context context;

    public DumpDummyData(Context context) {
        this.context = context;
    }

    public ArrayList<ItemModel> setData(int contextId) {
        ArrayList<ItemModel> list = new ArrayList<>();
        switch (contextId){
            case R.string.cpu:
                list.add(new ItemModel("AMD Athlon 200GE AM4 Socket Desktop Processor with Radeon Vega 3 Graphics",5299,"21 Jun,2019","AMD Ryzen"));
                list.add(new ItemModel("Intel Pentium Gold G5400 8th Gen Processor",5800,"13 July,2018","Intel"));
                return list;
            case R.string.motherboard:
                list.add(new ItemModel("ASRock A320M-HDV R4.0 AMD Motherboard",5600,"21 Oct,2019","AMD Ryzen"));
                list.add(new ItemModel("MSI B450M-A PRO MAX AMD AM4 Motherboard",7000,"22 Dec,2019","MSI"));
                list.add(new ItemModel("MSI B450M PRO-M2 MAX AMD AM4 Gaming Motherboard",5600,"21 Oct,2019","MSI"));
                return list;
            case R.string.ram1:
                list.add(new ItemModel("TwinMOS 4GB DDR3 1600MHz",1700,"21 Oct,2019","TwinMOS"));
                list.add(new ItemModel("Corsair Vengeance LPX 4GB (1x4GB) DDR4 DRAM 2400MHz",1800,"22 Dec,2019","Corsair"));
                list.add(new ItemModel("Geil 4GB 1600mhz DDR3 Desktop Ram",1800,"21 Oct,2019","Geil"));
                return list;
            case R.string.ram2:
                list.add(new ItemModel("Kingston DDR4 2400MHz 4GB Ram",1900,"21 Oct,2019","Kingston"));
                list.add(new ItemModel("Team Elite Plus 4GB 2400MHz DDR4 Ram",1950,"22 Dec,2019","Elite"));
                list.add(new ItemModel("Transcend 4GB DDR3 1333 MHz Desktop RAM",2000,"21 Oct,2019","Transcend"));
                return list;
            case R.string.storage_1:
                list.add(new ItemModel("PNY CS900 120GB 2.5 inch SATA III Internal SSD",1800,"22 Jan,2017","PNY"));
                list.add(new ItemModel("Gigabyte 120GB Solid State Drive (SSD)",1950,"25 Jan,2017","Gigabyte"));
                list.add(new ItemModel("Adata SU 650 120 GB Solid State Drive",1800,"22 Jan,2017","Adata"));
                return list;
            case R.string.storage_2:
                list.add(new ItemModel("Seagate Internal 1TB SATA Barracuda HDD",3750,"21 Feb 2019","Seagate"));
                list.add(new ItemModel("Transcend J25A3K 1TB USB 3.0 Black External HDD",5000,"21 Feb 2019","Transcend"));
                list.add(new ItemModel("Transcend StoreJet J25C3N 1TB External Hard Disk Drive (HDD)",5500,"21 Feb 2019","Transcend"));
                return list;
            case R.string.graphics_card:
                list.add(new ItemModel("GALAX GeForce GT 1030 EXOC White 2GB GDDR5 Graphics Card",7500,"21 Feb 2019","Galax"));
                list.add(new ItemModel("XFX AMD Radeon RX 570 RS 8GB XXX Edition Graphics Card",15800,"21 Feb 2019","AMD"));
                list.add(new ItemModel("Gigabyte GeForce GTX 1650 OC 4GB Graphics Card",17200,"21 Feb 2019","Gigabyte"));
                return list;
            case R.string.power_supply:
                list.add(new ItemModel("MaxGreen 500 Watt power supply",750,"21 Feb 2019","MaxGreen"));
                list.add(new ItemModel("Lian Li Strimer RGB 8 Pin Cable",5000,"21 Feb 2019","Lian"));
                list.add(new ItemModel("Gamdias Kratos E1-500 500 Watt RGB Power Supply",500,"21 Feb 2019","Gamidas"));
                return list;
            case R.string.casing:
                list.add(new ItemModel("MaxGreen 2809BK Casing",2050,"21 Feb 2019","MaxGreen"));
                list.add(new ItemModel("KWG VELA M1 Mid Tower PC Case",3000,"21 Feb 2019","KWG"));
                list.add(new ItemModel("MaxGreen 2810BG ATX Casing",2500,"21 Feb 2019","MaxGreen"));
                return list;
            case R.string.monitor:
                list.add(new ItemModel("ESONIC ES1701 17 Inch Square LED Monitor",7500,"21 Feb 2019","ESONIC"));
                list.add(new ItemModel("Samsung S19F350HNW 18.5 Inch LED Monitor (VGA)",7500,"21 Feb 2019","Samsung"));
                return list;
            case R.string.keyboard:
                list.add(new ItemModel("Dell Wired Keyboard KB216-Black",750,"21 Feb 2019","Dell"));
                list.add(new ItemModel("A4tech KR-92 Wired Keyboard",750,"21 Feb 2019","A4tech"));
                return list;
            case R.string.mouse:
                list.add(new ItemModel("A4TECH OP-730D 2X CLICK OPTICAL WIRED MOUSE",2050,"21 Feb 2019","A4tech"));
                list.add(new ItemModel("Delux DLM 363BU Optical Mouse",2050,"21 Feb 2019","Delux"));
                return list;
            case R.string.operating_system:
                list.add(new ItemModel("WIN Pro 10 64bit Eng INTL 1PK DSP OEM DVD",750,"21 Feb 2019","Microsoft"));
                return list;
            case R.string.ups:
                list.add(new ItemModel("Digital X 650VA Offline UPS",2050,"21 Feb 2019","Digital"));
                list.add(new ItemModel("Power Pac 650VA Offline UPS",2050,"21 Feb 2019","Power"));
                return list;
            default:
                break;
        }
        return list;
    }
}
