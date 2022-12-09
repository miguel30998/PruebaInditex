package org.example.PruebaInditex.controller.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "PRICES")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PricesIdClass.class)
public class PricesDao implements Serializable {

    @Column(name = "BRAND_ID")
    String idBrand;
    @Id
    @Column(name = "PRODUCT_ID")
    int idProduct;
    @Id
    @Column(name = "START_DATE")
    Date startDate;
    @Id
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
