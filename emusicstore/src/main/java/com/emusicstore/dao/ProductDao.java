package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by grgbibek22 on 6/27/2017.
 */
public interface ProductDao {
    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(String Id);

    List<Product> getAllProduct();

    void deleteProduct(String Id);


}
