package org.example.menu.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.crudmenu.entity.Product;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDao {
    private ObjectMapper objectMapper;
    private File file;


    @SneakyThrows
    public void save(Product product) {
        List<Product> products = findAll();
        products.add(product);
        objectMapper.writeValue(file, products);
    }

    @SneakyThrows
    public List<Product> findAll() {
        return objectMapper.readValue(file, new TypeReference<List<Product>>(){});
    }
    @SneakyThrows
    public void SaveAll(List<Product> products) {
    objectMapper.writeValue(file, products);
    }
}
