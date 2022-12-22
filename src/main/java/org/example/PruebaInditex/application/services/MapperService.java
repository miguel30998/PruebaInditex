package org.example.PruebaInditex.application.services;

import org.example.PruebaInditex.controller.dao.PricesDao;
import org.example.PruebaInditex.controller.dto.PricesDto;
import org.example.PruebaInditex.domain.core.Prices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MapperService {

    public List<Prices> daoToDomain(List<PricesDao>pricesDaoList){
        List<Prices>pricesList= new ArrayList<>();
        for (PricesDao pricesDao : pricesDaoList) {
            Prices prices =new Prices(pricesDao);
            pricesList.add(prices);
        }
        return pricesList;
    }
    public List<PricesDto>dtoToDomain(List<Prices>pricesList){
        List<PricesDto>pricesDtoList= new ArrayList<>();
        pricesList.forEach(prices -> pricesDtoList.add(PricesDto.builder()
                .price(prices.getPrice())
                .endDate(prices.getEndDate().toString())
                .startDate(prices.getStartDate().toString())
                .idBrand(prices.getIdBrand())
                .iDProduct(prices.getIDProduct())
                .priceList(prices.getPriceList())
                .curr(prices.getCurr())
                .priority(prices.getPriority())
                .build()));
        return pricesDtoList;
    }
}
