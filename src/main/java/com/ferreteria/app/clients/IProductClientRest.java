package com.ferreteria.app.clients;


import com.ferreteria.app.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(name = "service-products")
public interface IProductClientRest {

    @GetMapping("/products")
    public List<Product> index();

    @GetMapping("/product/{id}")
    public Product detail(@PathVariable Long id);
}
