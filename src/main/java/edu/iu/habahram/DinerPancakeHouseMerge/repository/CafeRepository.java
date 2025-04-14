package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CafeMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Map;

@Repository
public class CafeRepository {

    public MenuItem[] getTheMenu() {
        CafeMenu cafeMenu = new CafeMenu();
        Map<String, MenuItem> itemsMap = cafeMenu.getItems();
        return itemsMap.values().toArray(new MenuItem[0]);
    }

    public Iterator<MenuItem> getIterator() {
        CafeMenu cafeMenu = new CafeMenu();
        return cafeMenu.createIterator();
    }
}