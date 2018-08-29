package com.example.admin.akash.util;

import java.util.ArrayList;
import java.util.Arrays;

public class   AccessoryList {

    private AccessoryList(){

    }
    private static AccessoryList accessoryList;
    public static AccessoryList getInstance(){
        if(accessoryList == null){
            accessoryList = new AccessoryList();
        }
        return accessoryList;
    }
    public String[] getShoeList() {
        return shoeList;
    }

    public String[] getGarmentList() {
        return garmentList;
    }

    private static  String[] shoeList = {"Fancy Trims",
            "Rings and Loops",
            "Shoes Buckle",
            "Shoes Rivet",
            "Trims"} ;
    private static    String[]  garmentList =     {
            "Garment Buckle",
            "Garment Buttons",
            "Garment Loop",
            "Garment Ring",
            "Garment Rivet",
            "Puller"};


}
