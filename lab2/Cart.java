package ooplab2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOrdered.add(disc);
        System.out.println("Added: " + disc.getTitle());
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (itemsOrdered.remove(disc)) {
            System.out.println("Removed: " + disc.getTitle());
        } else {
            System.out.println("Not found!");
        }
    }

    public float totalCost() {
        float total = 0;
        for (DigitalVideoDisc disc : itemsOrdered) {
            total += disc.getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Cart Contents:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + " " + itemsOrdered.get(i).getTitle() + " $" + itemsOrdered.get(i).getCost());
        }
        System.out.println("Total Cost: $" + totalCost());
    }
}
