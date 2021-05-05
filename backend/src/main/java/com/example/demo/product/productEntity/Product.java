package com.example.demo.product.productEntity;

//@Entity
//@Embeddable
public class Product {
    private Long productSKU;
    private String productName;
    private String productBrand;
    private Float productPrice;
    private String productWarrantyPeriod;
    private Long productStock;
    private String productDescription;
    private String productImageURL;
    private Boolean productDiscountFlag;

    public Product() {
    }

    public Product(Long productSKU,
                   String productName,
                   String productBrand,
                   Float productPrice,
                   String productWarrantyPeriod,
                   Long productStock,
                   String productDescription,
                   String productImageURL,
                   Boolean productDiscountFlag) {
        this.productSKU = productSKU;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.productWarrantyPeriod = productWarrantyPeriod;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productImageURL = productImageURL;
        this.productDiscountFlag = productDiscountFlag;
    }

    public Product(String productName,
                   String productBrand,
                   Float productPrice,
                   String productWarrantyPeriod,
                   Long productStock,
                   String productDescription,
                   String productImageURL,
                   Boolean productDiscountFlag) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.productWarrantyPeriod = productWarrantyPeriod;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productImageURL = productImageURL;
        this.productDiscountFlag = productDiscountFlag;
    }

    public Long getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(Long productSKU) {
        this.productSKU = productSKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductWarrantyPeriod() {
        return productWarrantyPeriod;
    }

    public void setProductWarrantyPeriod(String productWarrantyPeriod) {
        this.productWarrantyPeriod = productWarrantyPeriod;
    }

    public Long getProductStock() {
        return productStock;
    }

    public void setProductStock(Long productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    public Boolean getProductDiscountFlag() {
        return productDiscountFlag;
    }

    public void setProductDiscountFlag(Boolean productDiscountFlag) {
        this.productDiscountFlag = productDiscountFlag;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productSKU=" + productSKU +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productPrice=" + productPrice +
                ", productWarrantyPeriod='" + productWarrantyPeriod + '\'' +
                ", productStock=" + productStock +
                ", productDescription='" + productDescription + '\'' +
                ", productImageURL='" + productImageURL + '\'' +
                ", productDiscountFlag=" + productDiscountFlag +
                '}';
    }
}
