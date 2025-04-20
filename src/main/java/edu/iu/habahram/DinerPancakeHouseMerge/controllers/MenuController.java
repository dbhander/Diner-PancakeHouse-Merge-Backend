package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class MenuController {

    MenuComponent allMenus;

    public MenuController() {
        allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianItems() {
        return filterMenuItems(item -> item.isVegetarian());
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastItems() {
        return filterMenuItems(item -> item.getDescription().toLowerCase().contains("egg") || item.getName().toLowerCase().contains("pancake"));
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunchItems() {
        return filterMenuItems(item -> item.getDescription().toLowerCase().contains("sandwich") || item.getName().toLowerCase().contains("blt"));
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getDinnerItems() {
        return filterMenuItems(item -> item.getDescription().toLowerCase().contains("burrito") || item.getDescription().toLowerCase().contains("soup"));
    }

    private List<MenuItemRecord> filterMenuItems(java.util.function.Predicate<MenuItem> predicate) {
        List<MenuItemRecord> result = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            try {
                if (component instanceof MenuItem item && predicate.test(item)) {
                    result.add(new MenuItemRecord(
                            item.getName(),
                            item.getDescription(),
                            item.isVegetarian(),
                            item.getPrice()
                    ));
                }
            } catch (UnsupportedOperationException ignored) {}
        }
        return result;
    }
}
