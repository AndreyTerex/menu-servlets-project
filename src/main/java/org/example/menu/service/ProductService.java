package org.example.menu.service;

import org.example.menu.dao.ProductDao;
import org.example.menu.entity.Product;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.UUID;

public class ProductService {
    ProductDao productDao;
    BCryptPasswordEncoder encoder;

    public ProductService(ProductDao productDao, BCryptPasswordEncoder encoder) {
        this.productDao = productDao;
        this.encoder = encoder;
    }

    public void save(String productName, UUID userid, String productPrice, String productImage) {
        productDao.save(Product.builder()
                .productName(productName)
                .userId(userid)
                .productPrice(productPrice)
                .productImageUrl(productImage)
                .productId(UUID.randomUUID())
                .build());
    }

    public List<Product> FindProductsByUserId(UUID id) {
        return productDao.findAll().stream().filter(product -> product.getUserId().equals(id)).toList();
    }

    public void removeByID(UUID productId) {
        List<Product> productAll = productDao.findAll();
        List<Product> listProductsWithOutRemovedProduct = productAll.stream().filter(product -> !product.getProductId().equals(productId)).toList();
        productDao.SaveAll(listProductsWithOutRemovedProduct);
    }
}
