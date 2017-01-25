package epam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Shop {
    private HashMap<SportEquipment, Integer> goods = new HashMap<SportEquipment, Integer>();

    public HashMap<SportEquipment, Integer> getMap() {
        return goods;
    }

    public String[] mas;
    public String line;

    public void readFile(String path) {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            line = "";
            while ((line = bufferedReader.readLine()) != null) {
                splitText(line);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void splitText(String line) {
        mas = line.split(",");
        Category category = new Category(mas[0]);
        String title = mas[1];
        String tmp = mas[2];
        Integer price = Integer.parseInt(tmp);
        SportEquipment equipment = new SportEquipment(category, title, price);
        goods.put(equipment, Integer.parseInt(mas[3]));
    }

    public void allGoods() {
        System.out.println("Products, that are in store: ");
        System.out.println(" ");
        Iterator<SportEquipment> sportEquipmentIterator = goods.keySet().iterator();
        while (sportEquipmentIterator.hasNext()) {
            SportEquipment spObj = sportEquipmentIterator.next();
            int numberOfGoods = goods.get(spObj);
            System.out.println(spObj.getTitle() + ": in quantity " + numberOfGoods);
        }
    }

    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which product would you like to find?");
            String search = " ";
            try {
                search = sc.nextLine();
            } catch (Exception e) {
                System.out.println("You haven't printed the product");
            }
            for (Map.Entry<SportEquipment, Integer> pair : getMap().entrySet()) {
                if (pair.getKey().getTitle().equals(search)) {
                    System.out.println("Item " + pair.getKey().getTitle() + " is in store . In quantity  " + pair.getValue());
                } else if (pair.getValue() == 0) {
                    System.out.println("The item " + search + " is not in the store. ");
                }
            }
        }
    }
