package com.ferreteria.app.controller;

import com.ferreteria.app.model.Items;
import com.ferreteria.app.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("serviceFeing")
    private IItemService service;

    @GetMapping("/items")
    public List<Items> list(){
        return service.findAll();
    }

    @GetMapping("/item/{id}/amount/{amount}")
    public Items detail(@PathVariable Long id, @PathVariable Integer amount){
        return service.findById(id,amount);
    }
}
