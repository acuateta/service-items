package com.ferreteria.app.service;

import com.ferreteria.app.model.Items;

import java.util.List;

public interface IItemService {

    public List<Items> findAll();

    public Items findById(Long id, Integer amount);
}
