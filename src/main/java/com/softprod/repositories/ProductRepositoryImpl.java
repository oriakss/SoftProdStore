package com.softprod.repositories;

import com.softprod.entities.Product;
import com.softprod.mappers.ProductMapper;
import com.softprod.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.softprod.entities.ProductCategory.*;
import static com.softprod.utils.Constants.*;

public class ProductRepositoryImpl implements ProductRepository {

    private static ProductRepository productRepository;
    private final EntityManager entityManager = JPAUtil.getEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();
    private final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    private List<Product> products;

    @Override
    public Optional<Product> createProduct(Product product) {
        transaction.begin();
        entityManager.persist(product);

        CriteriaQuery<Long> productCriteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Product> productRoot = productCriteriaQuery.from(Product.class);

        productCriteriaQuery
                .select(productRoot.get(ID))
                .where(criteriaBuilder.equal(productRoot.get(PRODUCT_NAME), product.getName()));
        Long productId = entityManager
                .createQuery(productCriteriaQuery)
                .getResultList()
                .stream()
                .findAny()
                .orElseThrow();

        transaction.commit();

        product.setId(productId);
        products.add(product);
        return Optional.of(product);
    }

    @Override
    public Optional<List<Product>> readProducts() {
        if (products == null || products.isEmpty()) {
            transaction.begin();

            CriteriaQuery<Product> productCriteriaQuery = criteriaBuilder.createQuery(Product.class);
            Root<Product> productRoot = productCriteriaQuery.from(Product.class);

            productCriteriaQuery.select(productRoot);
            products = entityManager.createQuery(productCriteriaQuery).getResultList();

            transaction.commit();
        }
        return Optional.of(products);
    }

    @Override
    public Optional<Product> updateProduct(Product updatedProduct) {
        transaction.begin();

        CriteriaUpdate<Product> productCriteriaUpdate = criteriaBuilder.createCriteriaUpdate(Product.class);
        Root<Product> productRoot = productCriteriaUpdate.from(Product.class);

        productCriteriaUpdate
                .set(PRODUCT_NAME, updatedProduct.getName())
                .set(PRODUCT_BRAND, updatedProduct.getBrand())
                .set(PRODUCT_CATEGORY, updatedProduct.getCategory())
                .set(PRODUCT_PRICE, updatedProduct.getPrice())
                .where((criteriaBuilder.equal(productRoot.get(ID), updatedProduct.getId())));
        entityManager.createQuery(productCriteriaUpdate).executeUpdate();

        transaction.commit();

        Product product = products.stream()
                .filter(item -> Objects.equals(item.getId(), updatedProduct.getId()))
                .findAny()
                .orElseThrow();
        int ind = products.indexOf(product);
        products.remove(product);
        products.add(ind, updatedProduct);
        return Optional.of(product);
    }

    @Override
    public Optional<Product> deleteProduct(Long productId) {
        transaction.begin();

        CriteriaDelete<Product> productCriteriaDelete = criteriaBuilder.createCriteriaDelete(Product.class);
        Root<Product> productRootDelete = productCriteriaDelete.from(Product.class);

        productCriteriaDelete.where(criteriaBuilder.equal(productRootDelete.get(ID), productId));
        entityManager.createQuery(productCriteriaDelete).executeUpdate();

        transaction.commit();

        Product product = products.stream()
                .filter(item -> Objects.equals(item.getId(), productId))
                .findAny()
                .orElseThrow();
        products.remove(product);
        return Optional.of(product);
    }

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }

    private ProductRepositoryImpl() {
        if (readProducts().orElseThrow().isEmpty()) {
            ProductMapper productMapper = ProductMapper.getInstance();
            transaction.begin();

            entityManager.persist(productMapper.buildProductManually("product1", "brand1", MOTHERBOARD, new BigDecimal(600)));
            entityManager.persist(productMapper.buildProductManually("product2", "brand2", CPU, new BigDecimal(300)));
            entityManager.persist(productMapper.buildProductManually("product3", "brand3", MEMORY, new BigDecimal(700)));
            entityManager.persist(productMapper.buildProductManually("product4", "brand4", GPU, new BigDecimal(900)));

            transaction.commit();
        }
    }
}