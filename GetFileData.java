package RestaurantManagementProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetFileData {

    static String menulistfile = "RestaurantManagementProject/menuitem.csv";
    static String orderfile = "RestaurantManagementProject/order.csv";

    public static List<RestaurantManagementProject.MenuItem> menuItems = new ArrayList<>();
    public static List<RestaurantManagementProject.Order> orderDetails = new ArrayList<>();

    public GetFileData() {
        loadCompleteMenuList();
        loadCompleteOrderDetails();
    }

    public List<MenuItem> loadCompleteMenuList() {
        menuItems.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(menulistfile));

            String line;

            br.readLine();
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                // "MID101,Berries,102.0,BreakFast,veryosm"

                String menuID = arr[0];
                String name = arr[1];
                double price = Double.parseDouble(arr[2].trim());
                String category = arr[3];
                String description = arr[4];
                menuItems.add(new RestaurantManagementProject.MenuItem(menuID, name, price, category, description));

            }

            br.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return menuItems;
    }

    public List<Order> loadCompleteOrderDetails() {
        orderDetails.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(orderfile));

            String line;

            br.readLine();
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                // OrderID, MenuItemName, Quantities, total bill amount, Date, Status,UserName
                // ODR101,Gobi Manchurian,4,40.0,2023-08-17,OrderPlaced,Vaibhav
                String orderID = arr[0];
                String menuItemName = arr[1];
                int quantity = Integer.parseInt(arr[2].trim());
                double totalBillAmount = Double.parseDouble(arr[3].trim());
                LocalDate date = LocalDate.parse(arr[4]);
                String status = arr[5];
                String UserName = arr[6];
                orderDetails.add(new Order(orderID, menuItemName, quantity, totalBillAmount, date, status, UserName));

            }

            br.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return orderDetails;
    }

    
    public static String[][] getFileDatainto2DArray() {

        String[][] fileData = new String[GetFileData.menuItems.size()][];
        int index = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(menulistfile));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                fileData[index] = arr;
                index++;

            }
            // printing data
            // for (int i = 0; i < fileData.length; i++) {
            // for (int j = 0; j < fileData[i].length; j++) {
            // System.out.print(fileData[i][j] + " ");
            // }
            // System.out.println();
            // }

        } catch (Exception e) {
            e.getMessage();
        }
        return fileData;

    }

    
    public static void loadMenuDataIntoFile() {
        String updatedData = "";
        for (MenuItem menuItem : menuItems) {
            updatedData += System.lineSeparator() + menuItem.getMenuID() + "," + menuItem.getName() + ","
                    + menuItem.getPrice() + "," + menuItem.getCategory() + "," + menuItem.getDescription();

        }
        try {
            FileWriter fw = new FileWriter(menulistfile);
            fw.write("MenuID,Name,Prize,Category,Description");
            fw.append(updatedData);
            fw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    
    public static void loadOrderDetailsIntoFile() {
        //
        String updatedData = "";
        for (Order order : orderDetails) {
            updatedData += System.lineSeparator() + order.getOrderID() + "," + order.getMenuitemName() + ","
                    + order.getQuantities() + "," + order.getTotalbillamount() + "," + order.getDate() + ","
                    + order.getStatus() + "," + order.getUserName();

        }
        // System.out.println(updatedData);
        try {
            FileWriter fw = new FileWriter(orderfile);
            fw.write("OrderID, MenuItemName, Quantities, total bill amount, Date, Status,UserName");
            fw.append(updatedData);
            fw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
