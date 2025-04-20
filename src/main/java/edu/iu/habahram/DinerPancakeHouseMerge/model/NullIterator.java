package edu.iu.habahram.DinerPancakeHouseMerge.model;
import java.util.Iterator;


public class NullIterator implements Iterator<MenuComponent> {
    public boolean hasNext() {
        return false;
    }

    public MenuComponent next() {
        return null;
    }

    public void remove() {
        Iterator.super.remove();
    }
}
