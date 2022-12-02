package org.example.PruebaInditex.config;


import org.example.PruebaInditex.controller.dao.PricesDao;
import org.example.PruebaInditex.controller.repositories.PricesDaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class DataBaseConfig {

    @Bean("DataBaseConfig")
    CommandLineRunner commandLineRunner(PricesDaoRepository pricesDaoRepository){
        return args -> {
            String pattern=("yyyy-MM-dd-HH.mm.ss");
            SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern);
            Date startDate1 = simpleDateFormat.parse("2020-06-14-00.00.00");
            Date endDate1 = simpleDateFormat.parse("2020-12-31-23.59.59");
            PricesDao pricesDao1= PricesDao.builder()
                    .idBrand("1")
                    .startDate(startDate1)
                    .endDate(endDate1)
                    .curr("EUR")
                    .priceList(1)
                    .idProduct(35455)
                    .priority(0)
                    .price(35.50f)
                    .build();
            Date startDate2=simpleDateFormat.parse("2020-06-14-15.00.00");
            Date endDate2= simpleDateFormat.parse("2020-06-14-18.30.00");
            PricesDao pricesDao2= PricesDao.builder()
                    .idBrand("1")
                    .startDate(startDate2)
                    .endDate(endDate2)
                    .priceList(2)
                    .idProduct(35455)
                    .priority(1)
                    .price(25.45f)
                    .curr("EUR")
                    .build();
            Date startDate3=simpleDateFormat.parse("2020-06-15-00.00.00");
            Date endDate3= simpleDateFormat.parse("2020-06-15-11.00.00");
            PricesDao pricesDao3= PricesDao.builder()
                    .idBrand("1")
                    .startDate(startDate3)
                    .endDate(endDate3)
                    .priceList(3)
                    .idProduct(35455)
                    .priority(1)
                    .price(30.50f)
                    .curr("EUR")
                    .build();
            Date startDate4=simpleDateFormat.parse("2020-06-15-16.00.00");
            Date endDate4= simpleDateFormat.parse("2020-12-31-23.59.59");
            PricesDao pricesDao4= PricesDao.builder()
                    .idBrand("1")
                    .startDate(startDate4)
                    .endDate(endDate4)
                    .priceList(4)
                    .idProduct(35455)
                    .priority(1)
                    .price(38.95f)
                    .curr("EUR")
                    .build();
            pricesDaoRepository.saveAllAndFlush(List.of(pricesDao1,pricesDao2,pricesDao3,pricesDao4));

        };
    }



}
