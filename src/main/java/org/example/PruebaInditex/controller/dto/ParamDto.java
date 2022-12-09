package org.example.PruebaInditex.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class ParamDto {

    @JsonProperty(value = "date")
    String Date;
    @JsonProperty(value = "idProduct")
    int idProduct;
    @JsonProperty(value ="brandId")
    String brandId;
}
