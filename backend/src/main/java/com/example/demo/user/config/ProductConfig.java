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
    CommandLineRunner productCommandLineRunner(ProductRepository repository) {
        return args -> {
            Product AirPodsMax = new Product(
                    "AirPods Max",
                    "Apple",
                    "Headphones",
                    "12 Months",
                    "issa pair of AirPods Max",
                    "https://cdn.tgdd.vn/Products/Images/54/236331/bluetooth-airpods-max-apple-1-1-org.jpg",
                    "No Discount",
                    12690000
            );

            Product AirPodsPro = new Product(
                    "AirPods Pro",
                    "Apple",
                    "Headphones",
                    "12 Months",
                    "issa pair of AirPods Pro",
                    "https://cdn.tgdd.vn/Products/Images/54/236026/airpods-pro-wireless-charge-apple-mwp22-ava-1-org.jpg",
                    "No Discount",
                    5300000
            );

            Product AirPods2 = new Product(
                    "AirPods 2",
                    "Apple",
                    "Headphones",
                    "12 Months",
                    "issa pair of AirPods 2",
                    "https://cdn.tgdd.vn/Products/Images/54/236025/airpods-2-wireless-charge-apple-mrxj2-1-org.jpg",
                    "No Discount",
                    4460000
            );

            Product BeatsSolo3Wireless = new Product(
                    "Beats Solo 3 Wireless",
                    "Beats",
                    "Headphones",
                    "12 Months",
                    "issa pair of Beats Solo 3 Wireless",
                    "https://cdn.tgdd.vn/Products/Images/54/228488/tai-nghe-chup-tai-beats-solo3-wireless-mx432-mv8t2-1-1-org.jpg",
                    "No Discount",
                    5490000
            );

            Product BeatsStudio3Wireless = new Product(
                    "Beats Studio 3 Wireless",
                    "Beats",
                    "Headphones",
                    "12 Months",
                    "issa pair of Beats Studio 3 Wireless",
                    "https://cdn.tgdd.vn/Products/Images/54/228486/tai-nghe-chup-tai-beats-studio3-mx422-mx432-1-1-org.jpg",
                    "No Discount",
                    7490000
            );

            Product SamsungGalaxyZFold25G = new Product(
                    "Samsung Galaxy Z Fold 2 5G",
                    "Samsung",
                    "Smartphone",
                    "12 Months",
                    "issa Samsung Galaxy Z Fold 2 5G",
                    "https://cdn.tgdd.vn/Products/Images/42/226099/samsung-galaxy-z-fold-2-den-1-org.jpg",
                    "No Discount",
                    50000000
            );

            Product iPhone12ProMax = new Product(
                    "iPhone 12 Pro Max",
                    "Apple",
                    "Smartphone",
                    "12 Months",
                    "issa iPhone 12 Pro Max",
                    "https://cdn.tgdd.vn/Products/Images/42/228743/iphone-12-pro-max-256gb-bac-1-org.jpg",
                    "No Discount",
                    35990000
            );

            Product XiaomiMi115G = new Product(
                    "Xiaomi Mi 11 5G",
                    "Xiaomi",
                    "Smartphone",
                    "12 Months",
                    "issa Xiaomi Mi 11 5G",
                    "https://cdn.tgdd.vn/Products/Images/42/226264/xiaomi-mi-11-xanhduong-1-org.jpg",
                    "No Discount",
                    20990000
            );

            Product iPhoneXR64GB = new Product(
                    "iPhone XR 64GB",
                    "Apple",
                    "Smartphone",
                    "12 Months",
                    "issa iPhone XR 64GB",
                    "https://cdn.tgdd.vn/Products/Images/42/190325/iphone-xr-do-1-1-org.jpg",
                    "No Discount",
                    13490000
            );

            Product LenovoTabM10FHDPlus = new Product(
                    "Lenovo Tab M10 - FHD Plus",
                    "Lenovo",
                    "Tablet",
                    "12 Months",
                    "issa Lenovo Tab M10 - FHD Plus",
                    "https://cdn.tgdd.vn/Products/Images/522/235365/lenovo-tab-m10-fhd-plus-1-1-org.jpg",
                    "No Discount",
                    5390000
            );

            Product iPadPro12point9inch128GB = new Product(
                    "iPad Pro 12.9 inch 128GB",
                    "Apple",
                    "Tablet",
                    "12 Months",
                    "issa iPad Pro 12.9 inch 128GB",
                    "https://cdn.tgdd.vn/Products/Images/522/221776/ipad-pro-12-9-inch-wifi-128gb-2020-1020x680-org-1-org.jpg",
                    "No Discount",
                    31190000
            );

            Product SamsungGalaxyTabS6Lite = new Product(
                    "Samsung Galaxy Tab S6 Lite",
                    "Samsung",
                    "Tablet",
                    "12 Months",
                    "issa Samsung Galaxy Tab S6 Lite",
                    "https://cdn.tgdd.vn/Products/Images/522/219912/samsung-galaxy-tab-s6-lite-xanh-1-org.jpg",
                    "No Discount",
                    9990000
            );

            Product HuaweiMediapadT5 = new Product(
                    "Huawei Mediapad T5",
                    "Huawei",
                    "Tablet",
                    "12 Months",
                    "issa Huawei Mediapad T5",
                    "https://cdn.tgdd.vn/Products/Images/522/232266/huawei-mediapad-t5-101-inch-3gb-32gb-vang-1-org.jpg",
                    "No Discount",
                    5190000
            );

            Product HuaweiMatePad = new Product(
                    "Huawei MatePad",
                    "Huawei",
                    "Tablet",
                    "12 Months",
                    "issa Huawei MatePad",
                    "https://cdn.tgdd.vn/Products/Images/522/236953/huawei-matepad-128gb-1-org.jpg",
                    "No Discount",
                    7490000
            );

            repository.saveAll(
                    List.of(
                            AirPodsMax,
                            AirPodsPro,
                            AirPods2,
                            BeatsSolo3Wireless,
                            BeatsStudio3Wireless,
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
