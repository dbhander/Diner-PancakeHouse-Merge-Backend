package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.Iterator;
public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public MenuItem[] getItems() {
        ArrayList<MenuItem> allItems = new ArrayList<>();
        for (MenuComponent component : menuComponents) {
            for (MenuItem item : component.getItems()) {
                allItems.add(item);
            }
        }
        return allItems.toArray(new MenuItem[0]);
    }

    public Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }

}
