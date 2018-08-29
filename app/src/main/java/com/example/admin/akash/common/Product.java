package com.example.admin.akash.common;

public class Product {
    public Product(String catagory, String productGroupName, String productName, String productDescription, String productImageURL) {
        this.catagory = catagory;
        this.productGroupName = productGroupName;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImageURL = productImageURL;
    }

    public String getCatagory() {

        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String prudctGroupName) {
        this.productGroupName = prudctGroupName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescrption) {
        this.productDescription = productDescrption;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    private String catagory;
    private String productGroupName ;
    private String productName  ;
    private String productDescription ;
    private String productImageURL ;


}
