package org.example.PruebaInditex.config;


import org.example.PruebaInditex.controller.dao.PricesDao;
import org.example.PruebaInditex.controller.repositories.PricesDaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DataBaseConfig {

    @Bean("DataBaseConfig")
    CommandLineRunner commandLineRunner(PricesDaoRepository pricesDaoRepository){
        return args -> {
            Date startDate1 = new Date("2020-06-14-00.00.00");
            Date endDate1= new Date("2020-12-31-23.59.59");
            PricesDao pricesDao= PricesDao.builder()
                    .idBrand("1")
                    .startDate(startDate1)
                    .endDate(endDate1)
                    .curr("EUR")
                    .priceList(1)
                    .iDProduct(35455)
                    .priority(0)
                    .price(35.50f)
                    .build();
            PricesDao pricesDao1= PricesDao.builder()
                    .idBrand()
        }
    }



}
