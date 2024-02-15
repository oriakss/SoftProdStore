package com.softprod.market.mappers;

import com.softprod.market.dto.requests.ProductDtoRequest;
import com.softprod.market.dto.responses.ProductDtoResponse;
import com.softprod.market.entities.Product;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = SPRING)
public interface ProductMapper {

    Product convertProductDtoRequestToProduct(ProductDtoRequest request);

    ProductDtoResponse convertProductToProductDtoResponse(Product product);
}