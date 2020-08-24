package com.ferreteria.app.service;

import com.ferreteria.app.model.Items;
import com.ferreteria.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Items> findAll() {
        List<Product> products = Arrays
                .asList(clientRest
                        .getForObject("http://localhost:8001/api/products", Product[].class));
        return products
                .stream()
                .map(p -> new Items(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Items findById(Long id, Integer amount) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Product product = clientRest
                .getForObject("http://localhost:8001/api/product/{id}", Product.class, pathVariables);
        return new Items(product,amount);
    }
}
