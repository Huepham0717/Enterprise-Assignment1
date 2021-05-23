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
            Product AirPodsMax = new Product(
            "AirPods Max",
            "Apple",
            "Headphones",
            "12 Months",
            "issa pair of headphones",
            "https://cdn.tgdd.vn/Products/Images/54/236331/bluetooth-airpods-max-apple-1-1-org.jpg",
            "No Discount",
                    12690000
            );

            Product AirPodsPro = new Product(
                    "AirPods Pro",
                    "Apple",
                    "Headphones",
                    "12 Months",
                    "issa pair of headphones",
                    "https://cdn.tgdd.vn/Products/Images/54/236026/airpods-pro-wireless-charge-apple-mwp22-ava-1-org.jpg",
                    "No Discount",
                    5300000
            );

            Product AirPods2 = new Product(
                    "AirPods 2",
                    "Apple",
                    "Headphones",
                    "12 Months",
                    "issa pair of headphones",
                    "https://cdn.tgdd.vn/Products/Images/54/236025/airpods-2-wireless-charge-apple-mrxj2-1-org.jpg",
                    "No Discount",
                    4460000
            );

            Product BeatsSoloPro = new Product(
                    "Beats Solo Pro",
                    "Beats",
                    "Headphones",
                    "12 Months",
                    "issa pair of headphones",
                    "https://tainghe.com.vn/media/product/2830_51rpzy6uual__ac_sl1000_.jpg",
                    "No Discount",
                    7290000
            );

            Product BeatsStudio3Wireless = new Product(
                    "Beats Studio 3 Wireless",
                    "Beats",
                    "Headphones",
                    "12 Months",
                    "issa pair of headphones",
                    "https://tainghe.com.vn/media/product/1615_tai_nghe_beats_studio_3_wireless___sand_dune.jpg",
                    "No Discount",
                    7290000
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
                            AirPodsMax,
                            AirPodsPro,
                            AirPods2,
                            BeatsSoloPro,
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
