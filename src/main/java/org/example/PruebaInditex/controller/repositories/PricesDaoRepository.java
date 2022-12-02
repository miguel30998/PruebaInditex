package org.example.PruebaInditex.controller.repositories;

import org.example.PruebaInditex.controller.dao.PricesDao;
import org.example.PruebaInditex.domain.core.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PricesDaoRepository extends JpaRepository<PricesDao,String> {

    List<PricesDao> findByIdBrandAndIdProduct(@Param("idBrand")String idBrand,@Param("idProduct")int idProduct);


}
