package org.example.PruebaInditex.controller.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;
import java.util.Date;

@Table(name = "PRICES")
@Entity
public class PricesDao {

    @Column(name = "BRAND_ID")
    String idBrand;
    @Id
    @Column(name = "PRODUCT_ID")
    String iDProduct;
    @Column(name = "START_DATE")
    Date startDate;
    @Column(name = "END_DATE")
    Date endDate;
    @Column(name = "PRICE_LIST")
    int priceList;
    @Column(name = "PRICE")
    Float price;
}
