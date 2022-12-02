package org.example.PruebaInditex.controller.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "PRICES")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PricesDao {

    @Column(name = "BRAND_ID")
    String idBrand;
    @Id
    @Column(name = "PRODUCT_ID")
    int iDProduct;
    @Column(name = "START_DATE")
    Date startDate;
    @Column(name = "END_DATE")
    Date endDate;
    @Column(name = "PRICE_LIST")
    int priceList;
    @Column(name = "PRIORITY")
    int priority;
    @Column(name = "PRICE")
    Float price;
    @Column(name = "CURR")
    String curr;
}
