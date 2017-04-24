package ru.digdes.steammarketparser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.repository.ItemRepository;
import ru.digdes.steammarketparser.service.ItemService;

/**
 * TODO javadoc
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;


    @Override
    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }
}
