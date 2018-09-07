package com.example.admin.akash.common;




import java.util.ArrayList;


public class ProductHandler {
    private  static ProductHandler productHandler;
    private   ArrayList<Product> productList = new ArrayList<>(); // This variable stores complete list of products

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<ProductGroup> getProductGroupList() {
        return productGroupList;
    }

    public void setProductGroupList(ArrayList<ProductGroup> productGroupList) {
        this.productGroupList = productGroupList;
    }

    private   ArrayList<ProductGroup> productGroupList = new ArrayList<>(); // This variable stores complete list of product group


    private ProductHandler(){

    }

    public  static   ProductHandler getInstance(){
        if(productHandler == null){
            productHandler = new ProductHandler();
        }
        return productHandler;
    }
    public static ArrayList<Product>  getProductListByProductGrooup (String categary, String productGroup){
        return  null;

    }
    public   void addProduct(Product product) {
        productList.add(product);
    }

    public   void addProductGroup (ProductGroup productGroup) {
        productGroupList.add(productGroup);
    }
    public   ArrayList<String> getProductGroupByCategary(final String categary){
        ArrayList<String> productGroupNames = new ArrayList<>();
        for ( int i=0; i < productGroupList.size();i ++ ){
            if(productGroupList.get(i).getCatagoryName().equals(categary)) {
                productGroupNames.add(productGroupList.get(i).getProductGroupName());
            }
        }
        return productGroupNames ;
    }
}
