package com.ferreteria.app.service;


import com.ferreteria.app.clients.IProductClientRest;
import com.ferreteria.app.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeing")
@Primary
public class ItemServiceFeing implements IItemService {

    @Autowired
    private IProductClientRest clientRest;

    @Override
    public List<Items> findAll() {
        return clientRest.index()
                .stream()
                .map(p -> new Items(p, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Items findById(Long id, Integer amount) {
        return new Items(clientRest.detail(id), amount);
    }
}
