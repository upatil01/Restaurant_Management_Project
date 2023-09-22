package RestaurantManagementProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantApp {

    public static Scanner sc = new Scanner(System.in);

    public static String logout;

    public static boolean AdminLogin(String username, String password) {
        final String UserName = "Vaibhav";
        final String Password = "Vaibhav@123k";
        if (UserName.equals(username) && Password.equals(password)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        // Anonymous object created of GetFileData
        new GetFileData();

        String flag = "y";
        while (flag.equalsIgnoreCase("y")) {
            System.out.println("--------------------------------------------------------\n"
                    + "---------------@@ Quick-Bites Restaurant @@-------------\n"
                    + "----------------------------------------------------------");
            System.out.println("1. Admin ");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter '1' for Admin '2' for User :");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    boolean success = false;
                    String username = "";
                    int count = 3;
                    while (success == false && count >= 0) {
                        System.out.println("------------------------------------------------------------------ -");
                        System.out.println("<----------------------@@ Admin Login Page @@---------------------->");
                        System.out.println("------------------------------------------------------------------ -");
                        System.out.print("Enter UserName :");
                        username = sc.next();
                        System.out.print("Enter Password :");
                        String password = sc.next();
                        success = AdminLogin(username, password);
                        if (success == false) {
                            if (count > 0) {
                                System.out.println(
                                        "@@---> Invalid UserName and Password <---@@ " + count + "  Chances left");

                            } else if (count == 0) {
                                System.out.println("Invalid UserName and Password   " + "You crossed the limit");

                            }
                        }
                        count--;
                    }
                    String adminloop = "y";
                    if (success) {
                        while (adminloop.equalsIgnoreCase("y")) {
                            System.out.println("------------------------------------------------------------------ -");
                            System.out
                                    .println("<------------------@@ Welcome " + username + " @@--------------------->");
                            System.out.println("------------------------------------------------------------------ -");
                            System.out.println("1. View Menu Items");
                            System.out.println("2. Add new Menu Item");
                            System.out.println("3. Edit Menu Item");
                            System.out.println("4. Delete MenuItem");
                            System.out.println("5. Search MenuItem by MenuID");
                            System.out.println("6. CollectionReport");
                            System.out.println("7. Logout Admin Panel");
                            System.out.println("-----------------@@---------------------");
                            System.out.print("Enter your option :");
                            int adminoption = sc.nextInt();
                            switch (adminoption) {
                                case 1:
                                    MenuItem.showMenuList(sc);
                                    // System.out.print("Do you want logout Admin Page : y/n :");
                                    // logout = sc.next();
                                    // if (logout.equals("y")) {
                                    // adminloop = "n";
                                    // } else {
                                    // adminloop = "y";
                                    // }
                                    break;
                                case 2:
                                    MenuItem.addNewMenuItem();
                                    break;
                                case 3:
                                    MenuItem.editMenuItem();
                                    break;
                                case 4:
                                    MenuItem.deleteMenuItem(sc);
                                    break;
                                case 5:
                                    MenuItem.findMenuItemByID(sc);
                                    break;
                                case 6:
                                    CollectionReport.getDailyCollection(sc);
                                    break;
                                case 7:
                                    adminloop = "n";
                                    break;

                                default:
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("<-----------@@ Welcome To $$Quick-Bites Restaurant$$  @@------------>");
                    System.out.println("--------------------------------------------------------------------");
                    boolean userloop = true;
                    while (userloop) {
                        System.err.println("#-----------------@@-----------------#");
                        System.out.println("1. View MenuItems");
                        System.out.println("2. Place Order");
                        System.out.println("3. Cancel Order");
                        System.out.println("4. Logout User Panel");
                        System.err.println("#-----------------@@-----------------#");
                        System.out.print("Enter your option :");
                        int useroption = sc.nextInt();
                        System.err.println("#-----------------@@-----------------#");
                        switch (useroption) {
                            case 1:
                                MenuItem.showMenuList(sc);
                                break;
                            case 2:
                                Order.placeOrder();
                                GetFileData.loadOrderDetailsIntoFile();
                                break;
                            case 3:
                                Order.cancelOrder(sc);
                                break;
                            case 4:
                                System.out.println(
                                        "-------------------------------------------------------------------------");
                                System.out.println("<-------@@ ***Thank you***  Visit Again @@-------->");
                                System.out.println(
                                        "-------------------------------------------------------------------------");
                                userloop = false;
                                break;

                            default:
                                System.out.println("Invalid input");
                                break;
                        }

                    }

                    break;
                case 3:
                    System.out.println(
                            "-------------------------------------------------------------------------");
                    System.out.println("<-------@@ ***Thank you***  Visit Again @@-------->");
                    System.out.println(
                            "-------------------------------------------------------------------------");
                    flag="n";
                    break;
                default:
                    System.out.println("Enter valid input");
                    break;
            }

        }

    }

}
