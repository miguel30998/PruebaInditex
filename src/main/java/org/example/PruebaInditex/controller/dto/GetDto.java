package org.example.PruebaInditex.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class GetDto {

    @JsonProperty(value = "date")
    String Date;
    @JsonProperty(value = "idProduct")
    int idProduct;
    @JsonProperty(value ="brandId")
    String brandId;
}
