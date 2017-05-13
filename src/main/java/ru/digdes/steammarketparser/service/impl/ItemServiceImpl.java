package ru.digdes.steammarketparser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.dto.ItemDTO;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.repository.ItemRepository;
import ru.digdes.steammarketparser.service.ItemService;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Iterable<ItemDTO> getAllInDTOFormat() {
        Iterable<Item> allItems = itemRepository.findAll();
        List<ItemDTO> allItemsDTO = new ArrayList<>();

        for (Item item : allItems) {
            allItemsDTO.add(new ItemDTO(item));
        }
        return allItemsDTO;
    }
}
