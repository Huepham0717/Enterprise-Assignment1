package com.example.demo.user.config;

import com.example.demo.user.entity.Product;
import com.example.demo.user.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner productCommandLineRunner(ProductRepository repository){
        return args -> {
            Product LenovoIdeaPadS14515i3 = new Product(
            "Lenovo IdeaPad S145 15 i3",
            "Lenovo",
            "Laptop",
            "12 Months",
            "issa laptop",
            "https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2019/11/5/637085681382679339_lenovo-ideapad-s145-bac-1.png",
            "No Discount",
                    11490000
            );

            Product OMENLaptop15 = new Product(
                    "OMEN Laptop 15",
                    "HP",
                    "Laptop",
                    "12 Months",
                    "issa laptop",
                    "https://www.hp.com/us-en/shop/app/assets/images/product/3G346UA%23ABA/center_facing.png?_=1595580794761&imwidth=75&imdensity=1",
                    "No Discount",
                    23059000
            );

            Product LGGram14 = new Product(
                    "LG Gram 14",
                    "LG",
                    "Laptop",
                    "12 Months",
                    "issa laptop",
                    "https://www.lg.com/vn/images/laptops/md07530543/gallery/S-1.jpg",
                    "No Discount",
                    29500000
            );

            Product AcerAspire5A514i3 = new Product(
                    "Acer Aspire 5 A514 i3",
                    "Acer",
                    "Laptop",
                    "12 Months",
                    "issa laptop",
                    "https://cdn.tgdd.vn/Products/Images/44/231082/acer-aspire-5-a514-54-33wy-i3-nxa23sv00j-2-org.jpg",
                    "No Discount",
                    13590000
            );

            Product SamsungGalaxyZFold25G = new Product(
                    "Samsung Galaxy Z Fold2 5G",
                    "Samsung",
                    "Phone",
                    "12 Months",
                    "issa phone",
                    "https://cdn.tgdd.vn/Products/Images/42/226099/samsung-galaxy-z-fold-2-den-1-org.jpg",
                    "No Discount",
                    50000000
            );

            Product iPhone12ProMax = new Product(
                    "iPhone 12 Pro Max",
                    "Apple",
                    "Phone",
                    "12 Months",
                    "issa phone",
                    "https://cdn.tgdd.vn/Products/Images/42/228743/iphone-12-pro-max-256gb-bac-1-org.jpg",
                    "No Discount",
                    35990000
            );

            Product XiaomiMi115G = new Product(
                    "Xiaomi Mi 11 5G",
                    "Xiaomi",
                    "Phone",
                    "12 Months",
                    "issa phone",
                    "https://cdn.tgdd.vn/Products/Images/42/226264/xiaomi-mi-11-xanhduong-1-org.jpg",
                    "No Discount",
                    20990000
            );

            Product iPhoneXR64GB = new Product(
                    "iPhone XR 64GB",
                    "Apple",
                    "Phone",
                    "12 Months",
                    "issa phone",
                    "https://cdn.tgdd.vn/Products/Images/42/190325/iphone-xr-do-1-1-org.jpg",
                    "No Discount",
                    13490000
            );

            Product LenovoTabM10FHDPlus = new Product(
                    "Lenovo Tab M10 - FHD Plus",
                    "Lenovo",
                    "Tablet",
                    "12 Months",
                    "issa tablet",
                    "https://cdn.tgdd.vn/Products/Images/522/235365/lenovo-tab-m10-fhd-plus-1-1-org.jpg",
                    "No Discount",
                    5390000
            );

            Product iPadPro12point9inch128GB = new Product(
                    "iPad Pro 12.9 inch 128GB",
                    "Apple",
                    "Tablet",
                    "12 Months",
                    "issa tablet",
                    "https://cdn.tgdd.vn/Products/Images/522/221776/ipad-pro-12-9-inch-wifi-128gb-2020-1020x680-org-1-org.jpg",
                    "No Discount",
                    31190000
            );

            Product SamsungGalaxyTabS6Lite = new Product(
                    "Samsung Galaxy Tab S6 Lite",
                    "Samsung",
                    "Tablet",
                    "12 Months",
                    "issa tablet",
                    "https://cdn.tgdd.vn/Products/Images/522/219912/samsung-galaxy-tab-s6-lite-xanh-1-org.jpg",
                    "No Discount",
                    9990000
            );

            Product HuaweiMediapadT5 = new Product(
                    "Huawei Mediapad T5",
                    "Huawei",
                    "Tablet",
                    "12 Months",
                    "issa tablet",
                    "https://cdn.tgdd.vn/Products/Images/522/232266/huawei-mediapad-t5-101-inch-3gb-32gb-vang-1-org.jpg",
                    "No Discount",
                    5190000
            );

            Product HuaweiMatePad = new Product(
                    "Huawei MatePad",
                    "Huawei",
                    "Tablet",
                    "12 Months",
                    "issa tablet",
                    "https://cdn.tgdd.vn/Products/Images/522/236953/huawei-matepad-128gb-1-org.jpg",
                    "No Discount",
                    7490000
            );

            repository.saveAll(
                    List.of(
                            LenovoIdeaPadS14515i3,
                            OMENLaptop15,
                            LGGram14,
                            AcerAspire5A514i3,
                            SamsungGalaxyZFold25G,
                            iPhone12ProMax,
                            XiaomiMi115G,
                            iPhoneXR64GB,
                            LenovoTabM10FHDPlus,
                            iPadPro12point9inch128GB,
                            SamsungGalaxyTabS6Lite,
                            HuaweiMediapadT5,
                            HuaweiMatePad
                    )
            );
        };
    }
}
