package org.example.PruebaInditex.application.services;


import org.example.PruebaInditex.controller.dao.PricesDao;
import org.example.PruebaInditex.controller.dto.GetDto;
import org.example.PruebaInditex.controller.dto.PricesDto;
import org.example.PruebaInditex.controller.repositories.PricesDaoRepository;
import org.example.PruebaInditex.domain.core.Prices;
import org.example.PruebaInditex.domain.exceptions.BadDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricesService {


    @Autowired
    PricesDaoRepository pricesDaoRepository;

    public List<PricesDto> getByDate(GetDto getDto) throws BadDateException {
        List<PricesDao> pricesDaoList2=pricesDaoRepository.findAll();
        List<PricesDao> pricesDaoList = pricesDaoRepository.findByIdBrandAndIdProduct(getDto.getBrandId(),getDto.getIdProduct());
        Date date = new Date();
        try {
            date = dateConverse(getDto.getDate());
        } catch (BadDateException e) {
            throw new BadDateException("Bad date while conversion");
        }
        pricesDaoList = getPricesBetweenDates(pricesDaoList, date);
        List<Prices> pricesList = daoToDomain(pricesDaoList);
        return dtoToDomain(pricesList);

    }


    private Date dateConverse(String stringDate) throws BadDateException {
        try {
            String patter = ("yyyy-MM-dd-HH.mm.ss");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
            Date date = simpleDateFormat.parse(stringDate);
            return date;
        } catch (ParseException e) {
            throw new BadDateException("");
        }
    }
    private List<PricesDao>getPricesBetweenDates(List<PricesDao> pricesDaoList,Date date){
        Date startDate=pricesDaoList.get(0).getStartDate();
        Date endDate=pricesDaoList.get(0).getEndDate();
        if(date.after(startDate)&&date.before(endDate)){
            int cont=20;
        }
        return pricesDaoList.stream().filter(pricesDao -> date.before(pricesDao.getEndDate())&&date.after(pricesDao.getStartDate())).collect(Collectors.toList());
    }

    private List<Prices>daoToDomain(List<PricesDao>pricesDaoList){
        List<Prices>pricesList= new ArrayList<>();
        for (PricesDao pricesDao : pricesDaoList) {
            Prices prices =new Prices(pricesDao);
            pricesList.add(prices);
        }
        return pricesList;
    }
    private List<PricesDto>dtoToDomain(List<Prices>pricesList){
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



