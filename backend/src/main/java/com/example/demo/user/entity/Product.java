package com.example.demo.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "products",uniqueConstraints={@UniqueConstraint(columnNames ={"productId"})})
public class Product {
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long productId;
    private String productName;
    private String brand;
    private String type;
    private String productWarrantyPeriod;
    private String description;
    private String imgURL;
    private String discount;
    private float price;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductWarrantyPeriod() {
        return productWarrantyPeriod;
    }

    public void setProductWarrantyPeriod(String productWarrantyPeriod) {
        this.productWarrantyPeriod = productWarrantyPeriod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", productWarrantyPeriod='" + productWarrantyPeriod + '\'' +
                ", description='" + description + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", discount='" + discount + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(Long productId, String productName, String brand, String type, String productWarrantyPeriod, String description, String imgURL, String discount, float price) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.type = type;
        this.productWarrantyPeriod = productWarrantyPeriod;
        this.description = description;
        this.imgURL = imgURL;
        this.discount = discount;
        this.price = price;
    }

    @Id
    public Long getProductId() {
        return productId;
    }
}
