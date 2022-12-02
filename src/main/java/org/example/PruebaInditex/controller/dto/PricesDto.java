package org.example.PruebaInditex.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PricesDto {

    @JsonProperty(value = "BRAND_ID")
    String idBrand;
    @JsonProperty(value = "PRODUCT_ID")
    String iDProduct;
    @JsonProperty(value = "START_DATE")
    String startDate;
    @JsonProperty(value = "END_DATE")
    String endDate;
    @JsonProperty(value = "PRICE_LIST")
    int priceList;
    @JsonProperty(value = "PRICE")
    Float price;
    @JsonProperty(value = "CURR")
    String curr;
    @JsonProperty(value = "PRIORITY")
    int priority;

}

