package com.example.demo.product.productEntity;

import javax.persistence.*;

@Entity
@Table(name = "products",uniqueConstraints={@UniqueConstraint(columnNames ={"productSKU", "productName"})})
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long productSKU;
    private String productName;
    private String productBrand;
    private String productType;
    private String productWarrantyPeriod;
    private Long productStock;
    private String productDescription;
    private String productImageURL;
    private Float productPriceOriginal;
    private Float productPriceMultiplier;
    @Transient
    private Float productPriceAdjusted;

    public Product() {
    }

    public Product(Long productSKU,
                   String productName,
                   String productBrand,
                   String productType,
                   String productWarrantyPeriod,
                   Long productStock,
                   String productDescription,
                   String productImageURL,
                   Float productPriceOriginal,
                   Float productPriceMultiplier) {
        this.productSKU = productSKU;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productType = productType;
        this.productWarrantyPeriod = productWarrantyPeriod;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productImageURL = productImageURL;
        this.productPriceOriginal = productPriceOriginal;
        this.productPriceMultiplier = productPriceMultiplier;
    }

    public Product(String productName,
                   String productBrand,
                   String productType,
                   String productWarrantyPeriod,
                   Long productStock,
                   String productDescription,
                   String productImageURL,
                   Float productPriceOriginal,
                   Float productPriceMultiplier) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productType = productType;
        this.productWarrantyPeriod = productWarrantyPeriod;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productImageURL = productImageURL;
        this.productPriceOriginal = productPriceOriginal;
        this.productPriceMultiplier = productPriceMultiplier;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public Float getProductPriceOriginal() {
        return productPriceOriginal;
    }

    public void setProductPriceOriginal(Float productPriceOriginal) {
        this.productPriceOriginal = productPriceOriginal;
    }

    public Float getProductPriceMultiplier() {
        return productPriceMultiplier;
    }

    public void setProductPriceMultiplier(Float productPriceMultiplier) {
        this.productPriceMultiplier = productPriceMultiplier;
    }

    public Float getProductPriceAdjusted() {
        return (this.productPriceOriginal*this.productPriceMultiplier);
    }

    public void setProductPriceAdjusted(Float productPriceAdjusted) {
        this.productPriceAdjusted = productPriceAdjusted;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productSKU=" + productSKU +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productType='" + productType + '\'' +
                ", productWarrantyPeriod='" + productWarrantyPeriod + '\'' +
                ", productStock=" + productStock +
                ", productDescription='" + productDescription + '\'' +
                ", productImageURL='" + productImageURL + '\'' +
                ", productPriceOriginal=" + productPriceOriginal +
                ", productPriceMultiplier=" + productPriceMultiplier +
                ", productPriceAdjusted=" + productPriceAdjusted +
                '}';
    }
}
