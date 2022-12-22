package org.example.PruebaInditex.application.services;


import org.example.PruebaInditex.controller.dao.PricesDao;
import org.example.PruebaInditex.controller.dto.ParamDto;
import org.example.PruebaInditex.controller.dto.PricesDto;
import org.example.PruebaInditex.controller.repositories.PricesDaoRepository;
import org.example.PruebaInditex.domain.core.Prices;
import org.example.PruebaInditex.domain.exceptions.BadDateException;
import org.example.PruebaInditex.domain.exceptions.NoElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricesService {


    @Autowired
    PricesDaoRepository pricesDaoRepository;

    @Autowired
    MapperService mapperService;

    public List<PricesDto> getByDate(ParamDto paramDto) throws BadDateException {
        List<PricesDao> pricesDaoList = pricesDaoRepository.findByIdBrandAndIdProduct(paramDto.getBrandId(), paramDto.getIdProduct());
        PricesDao pricesDao= new PricesDao();
        Date date = new Date();
        try {
            date = dateConverse(paramDto.getDate());
        } catch (BadDateException e) {
            throw new BadDateException("Bad date while conversion");
        }
        pricesDaoList = getPricesBetweenDates(pricesDaoList, date);
        pricesDaoList = getTheHighestPriority(pricesDaoList);
        List<Prices> pricesList = mapperService.daoToDomain(pricesDaoList);
        return mapperService.dtoToDomain(pricesList);

    }

    private List<PricesDao> getTheHighestPriority(List<PricesDao> pricesDaoList) {
        return pricesDaoList.stream().max(Comparator.comparing(PricesDao::getPriority)).stream().collect(Collectors.toList());
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
        return pricesDaoList.stream().filter(pricesDao -> date.before(pricesDao.getEndDate())&&date.after(pricesDao.getStartDate())).collect(Collectors.toList());
    }

}



