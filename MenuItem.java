package RestaurantManagementProject;

import java.util.Scanner;

public class MenuItem {
    private String MenuID;
    private String name;
    private double price;
    private String category;
    private String description;

    @Override
    public String toString() {
        return "MenuItem [MenuID=" + MenuID + ", name=" + name + ", price=" + price + ", category=" + category
                + ", description=" + description + "]";
    }

    public MenuItem(String menuID, String name, double price, String category, String description) {
        this.MenuID = menuID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void showMenuList(Scanner sc) {

        boolean cont = true;
        while (cont) {
            System.out.println("------------------------------------------------------------------ -");
            System.out.println("<-----------------@@ MenuItems Page @@----------------------->");
            System.out.println("------------------------------------------------------------------ -");
            System.out.println("******* Select Your Favourite MenuItem Category *******");
            System.out.println("1. View All Menu items");
            System.out.println("2. View BreakFast Menu");
            System.out.println("3. View Veg Menu");
            System.out.println("4. View Non Veg Menu");
            System.out.println("5. View Cake Menu");
            System.out.println("6. View Juice Menu");
            System.out.println("7. Find Last MenuItem");
            System.out.println("8. Exit");
            System.out.println("-----------------@@---------------------");
            System.out.print("Enter your choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    getCompleteMenu();
                    break;
                case 2:
                    getBreakFastMenu();
                    break;
                case 3:
                    getVegMenu();
                    break;
                case 4:
                    getNonVegMenu();
                    break;
                case 5:
                    getCakeMenu();
                    break;
                case 6:
                    getJuiceMenu();
                    break;
                case 7:
                    MenuItem.getLastMenuItem();
                    break;
                case 8:
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("<-------@@ Thank you for Visiting Manu Item Page @@-------->");
                    System.out.println("-----------------------------------------------------------");

                    cont = false;
                    break;

                default:
                    System.out.println("Please select right option ...");
                    break;
            }
        }
    }

    public static void getBreakFastMenu() {
        int count = 0;
        System.out.println("--------------------------------------------------------\n"
                + "---------------@@ BreakFast Menu @@-------------\n"
                + "----------------------------------------------------------");
        System.out.println("*********************************************");
        for (MenuItem mitem : GetFileData.menuItems) {
            if (mitem.getCategory().equalsIgnoreCase("Breakfast")) {
                count++;
                System.out.println("MenuID      :" + mitem.getMenuID());
                System.out.println("Name        :" + mitem.getName());
                System.out.println("Prize       :" + mitem.getPrice());
                System.out.println("Category    :" + mitem.getCategory());
                System.out.println("Description :" + mitem.getDescription());
                System.out.println("*********************************************");
            }

        }
        System.out.println(" Total Items  :--->" + count);
    }

    public static void getVegMenu() {
        int c1 = 0;
        System.out.println("--------------------------------------------------------\n"
                + "---------------@@ Veg Menu @@-------------\n"
                + "----------------------------------------------------------");
        System.out.println("*********************************************");
        for (MenuItem mitem : GetFileData.menuItems) {
            if (mitem.getCategory().equalsIgnoreCase("Veg")) {
                c1++;
                System.out.println("MenuID      :" + mitem.getMenuID());
                System.out.println("Name        :" + mitem.getName());
                System.out.println("Prize       :" + mitem.getPrice());
                System.out.println("Category    :" + mitem.getCategory());
                System.out.println("Description :" + mitem.getDescription());
                System.out.println("*********************************************");
            }

        }
        System.out.println(" Total Items  :--->" + c1);
    }

    public static void getNonVegMenu() {
        int c2 = 0;
        System.out.println("--------------------------------------------------------\n"
                + "---------------@@ Non Veg Menu @@-------------\n"
                + "----------------------------------------------------------");
        System.out.println("*********************************************");
        for (MenuItem mitem : GetFileData.menuItems) {
            if (mitem.getCategory().equalsIgnoreCase("Non-Veg")) {
                c2++;
                System.out.println("MenuID      :" + mitem.getMenuID());
                System.out.println("Name        :" + mitem.getName());
                System.out.println("Prize       :" + mitem.getPrice());
                System.out.println("Category    :" + mitem.getCategory());
                System.out.println("Description :" + mitem.getDescription());
                System.out.println("*********************************************");
            }

        }
        System.out.println(" Total Items  :--->" + c2);
    }

    public static void getCakeMenu() {
        int c3 = 0;
        System.out.println("--------------------------------------------------------\n"
                + "---------------@@ Cake Menu @@-------------\n"
                + "----------------------------------------------------------");
        System.out.println("*********************************************");
        for (MenuItem mitem : GetFileData.menuItems) {
            if (mitem.getCategory().equalsIgnoreCase("Cake")) {
                c3++;
                System.out.println("MenuID      :" + mitem.getMenuID());
                System.out.println("Name        :" + mitem.getName());
                System.out.println("Prize       :" + mitem.getPrice());
                System.out.println("Category    :" + mitem.getCategory());
                System.out.println("Description :" + mitem.getDescription());
                System.out.println("*********************************************");
            }

        }
        System.out.println(" Total Items  :--->" + c3);
    }

    public static void getJuiceMenu() {
        int c4 = 0;
        System.out.println("--------------------------------------------------------\n"
                + "---------------@@ Juice Menu @@-------------\n"
                + "----------------------------------------------------------");
        System.out.println("*********************************************");
        for (MenuItem mitem : GetFileData.menuItems) {
            if (mitem.getCategory().equalsIgnoreCase("Juice")) {
                c4++;
                System.out.println("MenuID      :" + mitem.getMenuID());
                System.out.println("Name        :" + mitem.getName());
                System.out.println("Prize       :" + mitem.getPrice());
                System.out.println("Category    :" + mitem.getCategory());
                System.out.println("Description :" + mitem.getDescription());
                System.out.println("*********************************************");
            }

        }
        System.out.println(" Total Items  :--->" + c4);
    }

    public static void getCompleteMenu() {

        System.out.println("--------------------------------------------------------\n"
                + "---------------@@ Main Menu @@-------------\n"
                + "----------------------------------------------------------");
        System.out.println("*********************************************");
        for (MenuItem mitem : GetFileData.menuItems) {

            System.out.println("MenuID      :" + mitem.getMenuID());
            System.out.println("Name        :" + mitem.getName());
            System.out.println("Prize       :" + mitem.getPrice());
            System.out.println("Category    :" + mitem.getCategory());
            System.out.println("Description :" + mitem.getDescription());
            System.out.println("*********************************************");

        }
        System.out.println(" Total Items  :--->" + GetFileData.menuItems.size());
    }

    public static MenuItem findMenuItemByID(Scanner sc) {
        MenuItem mitem = null;

        boolean found = false;
        System.out.print("Enter MenuID : ");
        String menuid = sc.next();
        for (MenuItem menuItem : GetFileData.menuItems) {
            if (menuItem.getMenuID().equalsIgnoreCase(menuid)) {
                found = true;
                System.out.println("*********************************************");
                System.out.println("MenuID      :" + menuItem.getMenuID());
                System.out.println("Name        :" + menuItem.getName());
                System.out.println("Prize       :" + menuItem.getPrice());
                System.out.println("Category    :" + menuItem.getCategory());
                System.out.println("Description :" + menuItem.getDescription());
                System.out.println("*********************************************");

                mitem = menuItem;
            }

        }
        if (!found) {
            System.out.println("MenuItem not  present");
        }
        return mitem;

    }

    public static MenuItem getLastMenuItem() {
        MenuItem mitem = GetFileData.menuItems.get(GetFileData.menuItems.size() - 1);
        System.out.println("@@@@@@@@@@@ Last MenuItem Details @@@@@@@@@@@@@");
        System.out.println("*********************************************");
        System.out.println("MenuID      :" + mitem.getMenuID());
        System.out.println("Name        :" + mitem.getName());
        System.out.println("Prize       :" + mitem.getPrice());
        System.out.println("Category    :" + mitem.getCategory());
        System.out.println("Description :" + mitem.getDescription());
        System.out.println("*********************************************");
        return mitem;

    }

    public static void editMenuItem() {
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        System.out.println("Enter MenuID which you want to edit");
        String menuid = sc.nextLine();
        for (MenuItem menuItem : GetFileData.menuItems) {
            if (menuItem.getMenuID().equalsIgnoreCase(menuid)) {
                found = true;
                System.out.println("<-------------@@MenuItem Details @@--------------->");
                System.out.println("*********************************************");
                System.out.println("MenuID      :" + menuItem.getMenuID());
                System.out.println("Name        :" + menuItem.getName());
                System.out.println("Prize       :" + menuItem.getPrice());
                System.out.println("Category    :" + menuItem.getCategory());
                System.out.println("Description :" + menuItem.getDescription());
                System.out.println("*********************************************");

                System.out.println("<-------------@@Enter New Details@@---------------->");
                System.out.print("Enter MenuItem Name  :");
                String name = sc.nextLine();
                System.out.println(name);
                System.out.print("Enter Category :BreakFast/Veg/Non-Veg/Cake/Juice :");
                String cat = sc.nextLine();
                System.out.println(cat);
                System.out.print("Enter Description :");
                String des = sc.nextLine();
                System.out.println(des);
                System.out.print("Enter MenuItem Prize :");
                double prize = sc.nextDouble();
                System.out.println(prize);

                menuItem.setName(name);
                menuItem.setPrice(prize);
                menuItem.setCategory(cat);
                menuItem.setDescription(des);

                // Writing Data into File
                System.out.print("Enter C to confirm the changes :");
                String confirm = sc.next();
                if (confirm.equalsIgnoreCase("c")) {
                    GetFileData.loadMenuDataIntoFile();
                    System.out.println("<-----MenuItem Updated successfully----->");
                    break;
                } else {
                    System.out.println("MenuItem not edited");

                }
            }

        }
        if (!found) {
            System.out.println("MenuItem not  present");
        }

    }

    public static void addNewMenuItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("<------------@@ Adding new menu item @@-------------->");
        System.out.println("Generating new MenuID .....");
        String menuID = MenuItem.menuIDGenerator();
        System.out.print("Enter MenuItem Name :");
        String name = sc.nextLine();
        System.out.print("Enter Category : ");
        String category = sc.nextLine();
        System.out.print("Enter Description :");
        String description = sc.nextLine();
        System.out.print("Enter Prize :");
        double prize = sc.nextDouble();

        System.out.print("Enter C to Add New MenuItem :");
        String confirm = sc.next();
        if (confirm.equalsIgnoreCase("c")) {
            GetFileData.menuItems.add(new MenuItem(menuID, name, prize, category, description));
            GetFileData.loadMenuDataIntoFile();
            System.out.println("<-----MenuItem Added successfully----->");
        } else {
            System.out.println("MenuItem Not Added");

        }

    }

    public static String menuIDGenerator() {
        MenuItem lastMenuItem = GetFileData.menuItems.get(GetFileData.menuItems.size() - 1);
        String lastMenuID = lastMenuItem.getMenuID();
        // System.out.println(lastMenuID);
        int id = Integer.parseInt(lastMenuID.substring(3));
        id = id + 1;
        String newMenuID = "MID" + id;
        System.out.println("new MenuID Created :" + newMenuID);
        return newMenuID;
    }

    public static void deleteMenuItem(Scanner sc) {
        System.out.println("<----@@ Deleting Menu Item @@---->");
        MenuItem mitem = MenuItem.findMenuItemByID(sc);
        if (mitem != null) {
            System.out.println("Do you want to delete ? y/n :");
            String confirm = sc.next();
            if (confirm.equalsIgnoreCase("y")) {
                if (GetFileData.menuItems.remove(mitem)) {
                    // Loading the changes into file
                    GetFileData.loadMenuDataIntoFile();
                    System.out.println("MenuItem got deleted...");
                } else {
                    System.out.println("Not able to delete");
                }
            } else {
                System.out.println("you seleted not to delete...");
            }
        }

    }

    public static MenuItem getMenuItemDetails(String MenuID_MenuName) {
        MenuItem mitem = null;

        boolean found = false;
        for (MenuItem menuItem : GetFileData.menuItems) {
            if (menuItem.getMenuID().equalsIgnoreCase(MenuID_MenuName)
                    || menuItem.getName().equalsIgnoreCase(MenuID_MenuName)) {
                found = true;
                System.out.println("*********************************************");
                System.out.println("MenuID      :" + menuItem.getMenuID());
                System.out.println("Name        :" + menuItem.getName());
                System.out.println("Prize       :" + menuItem.getPrice());
                System.out.println("Category    :" + menuItem.getCategory());
                System.out.println("Description :" + menuItem.getDescription());
                System.out.println("*********************************************");

                mitem = menuItem;
            }

        }
        if (!found) {
            System.out.println("MenuItem not  present");
        }
        return mitem;

    }

}