package com.softprod.store.services;

import com.softprod.store.dto.responses.ProductDtoResponse;
import com.softprod.store.entities.Product;
import com.softprod.store.mappers.ProductMapper;
import com.softprod.store.mappers.ProductMapperImpl;
import com.softprod.store.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static com.softprod.store.enums.ProductCategory.CPU;
import static com.softprod.store.enums.ProductCategory.GPU;
import static com.softprod.store.enums.ProductStatus.AVAILABLE;
import static com.softprod.store.enums.ProductStatus.NOT_AVAILABLE;
import static java.util.UUID.fromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Spy
    private ProductMapper productMapper = new ProductMapperImpl();

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testFindAllProducts() {
        when(productRepository.findAll()).thenReturn(getPreparedProducts());
        List<ProductDtoResponse> productsDto = productService.findAllProducts();
        assertEquals(getPreparedProductsDto(), productsDto);
    }

    private List<Product> getPreparedProducts() {
        Product product1 = Product.builder()
                .id(fromString("7a67854d-b8d6-419a-92f0-7c2abbf7a258"))
                .name("Core i7")
                .brand("Intel")
                .category(CPU)
                .price(new BigDecimal("789.49"))
                .status(AVAILABLE)
                .build();
        Product product2 = Product.builder()
                .id(fromString("ffffcabf-a6f3-4181-bcfb-f3e9450a6459"))
                .name("2060 Super")
                .brand("Palit")
                .category(GPU)
                .price(new BigDecimal("1349.99"))
                .status(NOT_AVAILABLE)
                .build();
        return List.of(product1, product2);
    }

    private List<ProductDtoResponse> getPreparedProductsDto() {
        List<Product> products = getPreparedProducts();
        Product product1 = products.get(0);
        Product product2 = products.get(1);
        ProductDtoResponse productDtoResponse1 = ProductDtoResponse.builder()
                .id(product1.getId())
                .name(product1.getName())
                .brand(product1.getBrand())
                .category(product1.getCategory())
                .price(product1.getPrice())
                .status(product1.getStatus())
                .build();
        ProductDtoResponse productDtoResponse2 = ProductDtoResponse.builder()
                .id(product2.getId())
                .name(product2.getName())
                .brand(product2.getBrand())
                .category(product2.getCategory())
                .price(product2.getPrice())
                .status(product2.getStatus())
                .build();
        return List.of(productDtoResponse1, productDtoResponse2);
    }
}