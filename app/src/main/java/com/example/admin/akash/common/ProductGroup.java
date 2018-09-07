package com.example.admin.akash.common;

/****
 *  This class is used to navigate through product list
 *  It has only one entry for each productgroup
 *
 */
public class ProductGroup {
    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public int getStartId() {
        return startId;
    }

    public void setStartId(int startId) {
        this.startId = startId;
    }

    public int getEndId() {
        return endId;
    }

    public void setEndId(int endId) {
        this.endId = endId;
    }

    private String productGroupName  ;
    private  String catagoryName ;
    private  int startId ;
    private int endId  ;
}
