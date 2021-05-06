package com.example.demo.product.productEntity;

import javax.persistence.*;

@Entity
@Table(name = "products",uniqueConstraints={@UniqueConstraint(columnNames ={"productSKU"})})
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
    private Float productPriceOriginal;
    private Float productPriceMultiplier;
    private Float productPriceAdjusted;
    private String productWarrantyPeriod;
    private Long productStock;
    private String productDescription;
    private String productImageURL;

    public Product() {
    }

    public Product(Long productSKU,
                   String productName,
                   String productBrand,
                   Float productPriceOriginal,
                   Float productPriceMultiplier,
                   Float productPriceAdjusted,
                   String productWarrantyPeriod,
                   Long productStock,
                   String productDescription,
                   String productImageURL) {
        this.productSKU = productSKU;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPriceOriginal = productPriceOriginal;
        this.productPriceMultiplier = productPriceMultiplier;
        this.productPriceAdjusted = productPriceAdjusted;
        this.productWarrantyPeriod = productWarrantyPeriod;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productImageURL = productImageURL;
    }

    public Product(String productName,
                   String productBrand,
                   Float productPriceOriginal,
                   Float productPriceMultiplier,
                   Float productPriceAdjusted,
                   String productWarrantyPeriod,
                   Long productStock,
                   String productDescription,
                   String productImageURL) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPriceOriginal = productPriceOriginal;
        this.productPriceMultiplier = productPriceMultiplier;
        this.productPriceAdjusted = productPriceAdjusted;
        this.productWarrantyPeriod = productWarrantyPeriod;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productImageURL = productImageURL;
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
        return productPriceAdjusted;
    }

    public void setProductPriceAdjusted(Float productPriceAdjusted) {
        this.productPriceAdjusted = productPriceAdjusted;
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

    @Override
    public String toString() {
        return "Product{" +
                "productSKU=" + productSKU +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productPriceOriginal=" + productPriceOriginal +
                ", productPriceMultiplier=" + productPriceMultiplier +
                ", productPriceAdjusted=" + productPriceAdjusted +
                ", productWarrantyPeriod='" + productWarrantyPeriod + '\'' +
                ", productStock=" + productStock +
                ", productDescription='" + productDescription + '\'' +
                ", productImageURL='" + productImageURL + '\'' +
                '}';
    }
}
