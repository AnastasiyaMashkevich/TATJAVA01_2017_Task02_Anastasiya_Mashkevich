package epam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws Exception {

        Shop shop = new Shop();
        HashMap<SportEquipment, Integer> goods = shop.getMap();
        RentUnit rentUnit = new RentUnit();
        ArrayList<SportEquipment> units = rentUnit.getUnits();
        String path = "C:\\Users\\Anastasiya_Mashkevic\\IdeaProjects\\Task_2_OOP\\list.txt";
        shop.readFile(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the product category, name, price. ");

        while (true) {
            String line = reader.readLine();
            if (line.equals("finish")) {
                break;
            }
            String type = line;
            String name = reader.readLine();
            String priceStr = reader.readLine();
            int price = Integer.parseInt(priceStr);
            units.add(new SportEquipment(new Category(type), name, price));
            System.out.println("---------Enter next goods or 'finish'----------");
        }

        for (Map.Entry<SportEquipment, Integer> pair : goods.entrySet()) {
            for (int i = 0; i < units.size(); i++) {
                if (pair.getKey().getTitle().equals(units.get(i).getTitle())) {
                    System.out.println("Item " + units.get(i).getTitle() + " is in stock.  Quantity " + pair.getValue());
                    goods.put(pair.getKey(), pair.getValue() - 1);
                }
            }
        }
        rentUnit.inRent();
        shop.allGoods();
        shop.search();
    }
}