package com.softprod.store.mappers;

import com.softprod.store.dto.requests.ProductDtoRequest;
import com.softprod.store.dto.responses.ProductDtoResponse;
import com.softprod.store.entities.Product;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface ProductMapper {

    Product convertProductDtoRequestToProduct(ProductDtoRequest request);

    ProductDtoResponse convertProductToProductDtoResponse(Product product);
}