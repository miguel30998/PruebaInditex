package org.example.PruebaInditex.domain.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.PruebaInditex.controller.dao.PricesDao;
import org.example.PruebaInditex.controller.dto.PricesDto;
import org.example.PruebaInditex.domain.exceptions.BadDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Prices {

    String idBrand;

    String iDProduct;

    Date startDate;

    Date endDate;

    int priceList;

    int priority;

    Float price;

    String Curr;

    public Prices(PricesDto pricesDto) {
        this.idBrand = pricesDto.getIdBrand();
        try {
            this.startDate = goodDate(pricesDto.getStartDate());
            this.endDate = goodDate(pricesDto.getEndDate());
        } catch (BadDateException e) {
            this.startDate = null;
            this.endDate = null;
        }
        this.priceList = pricesDto.getPriceList();
        this.iDProduct = pricesDto.getIDProduct();
        this.price = pricesDto.getPrice();
    }
    public Prices(PricesDao pricesDao){
        this.iDProduct= String.valueOf(pricesDao.getIdProduct());
        this.price=pricesDao.getPrice();
        this.priceList=pricesDao.getPriceList();
        this.idBrand=pricesDao.getIdBrand();
        this.Curr=pricesDao.getCurr();
        this.priority=pricesDao.getPriority();
        this.startDate=pricesDao.getStartDate();
        this.endDate=pricesDao.getEndDate();
    }

    private Date goodDate(String date) throws BadDateException {
        try {
            String patter = ("yyyy-MM-dd-HH-mm-ss");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
            Date date1 = simpleDateFormat.parse(date);
            return date1;
        } catch (ParseException e) {
            throw new BadDateException("Bad date while building a domain object");
        }
    }
}


