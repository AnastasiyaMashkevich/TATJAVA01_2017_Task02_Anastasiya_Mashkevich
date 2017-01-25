package epam;

import java.util.ArrayList;

public class RentUnit {
    private static ArrayList<SportEquipment> units = new ArrayList<SportEquipment>();

    public ArrayList<SportEquipment> getUnits() {
        return units;
    }

    public int sizeOf() {
        return this.units.size();
    }

    public void inRent() {
        if (sizeOf() == 0) {
            System.out.println("The goods were not are rented");
        }
        if (sizeOf() > 3) {
            System.out.println("You can't buy more than 3 items");
        }
        else {
            for (int i = 0; i < sizeOf(); i++) {
                String goodsInRent = getUnits().get(i).getTitle();
                int priceInRent = getUnits().get(i).getPrice();
                System.out.println("\n"+ "In rent " + goodsInRent + " by price " + priceInRent);
            }

        }

    }
}