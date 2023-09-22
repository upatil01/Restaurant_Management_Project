package RestaurantManagementProject;

import java.time.LocalDate;
import java.util.Scanner;

public class Order {
    private String OrderID;
    private String menuitemName;
    private int quantities;
    private double totalbillamount;
    private LocalDate date;
    private String status;
    private String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getOrderID() {
        return OrderID;
    }

    public String getMenuitemName() {
        return menuitemName;
    }

    public void setMenuitemName(String menuitemName) {
        this.menuitemName = menuitemName;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    @Override
    public String toString() {
        return "Order [OrderID=" + OrderID + ", menuitems=" + menuitemName + ", quantities=" + quantities
                + ", totalbillamount=" + totalbillamount + ", date=" + date + ", status=" + status + "]";
    }

    public double getTotalbillamount() {
        return totalbillamount;
    }

    public void setTotalbillamount(double totalbillamount) {
        this.totalbillamount = totalbillamount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(String orderID, String menuitems, int quantities, double totalbillamount, LocalDate date,
            String status, String UserName) {
        OrderID = orderID;
        this.menuitemName = menuitems;
        this.quantities = quantities;
        this.totalbillamount = totalbillamount;
        this.date = date;
        this.status = status;
        this.UserName = UserName;
    }

    public static void placeOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("--------------@@ Order Details @@--------------");
        System.out.println("-----------------------------------------------");
        System.out.print("Enter User Name :");
        String Name = sc.nextLine();
        System.out.println("OrderID is generating...");
        String orderID = Order.generateOrderID();
        System.out.print("Enter MenuID or MenuItem Name :");
        String MenuID_MenuName = sc.nextLine();
        MenuItem menuDetail = MenuItem.getMenuItemDetails(MenuID_MenuName);
        if (menuDetail != null) {
            System.out.print("Enter the Quantity :");
            int Quantity = sc.nextInt();
            double totalBill = menuDetail.getPrice() * Quantity;
            System.out.println("Total Bill Amount :" + totalBill);
            System.out.print("Enter 'C' to Confirm the Order :");
            String confirm = sc.next();
            if (confirm.equalsIgnoreCase("c")) {
                LocalDate d = LocalDate.now();
                GetFileData.orderDetails
                        .add(new Order(orderID, menuDetail.getName(), Quantity, totalBill, d, "OrderConfirmed",
                                Name));
                System.out.println("Your Order got Placed");

            } else {
                System.out.println("-------------------------------------------------");
                System.out.println("You Selected Not To Confirm The Order");
                System.out.println("Thank You  For Visiting.....");
                System.out.println("-------------------------------------------------");

            }
        }
    }

    public static String generateOrderID() {
        Order order = GetFileData.orderDetails.get(GetFileData.orderDetails.size() - 1);
        String lastOrderID = order.getOrderID();
        // System.out.println(lastMenuID);
        int id = Integer.parseInt(lastOrderID.substring(3));
        id = id + 1;
        String newMenuID = "ORD" + id;
        System.out.println("new orderID Created :" + newMenuID);
        return newMenuID;
    }

    public static Order findOrderDetailsByID(Scanner sc) {
        Order ord = null;

        boolean found = false;
        System.out.print("Enter OrderID : ");
        String orderID = sc.next();
        for (Order order : GetFileData.orderDetails) {
            if (order.getOrderID().equalsIgnoreCase(orderID)) {
                found = true;
                System.out.println("*********************************************");
                System.out.println("OrderID         :" + order.getOrderID());
                System.out.println("MenuItemName    :" + order.getMenuitemName());
                System.out.println("Quantity        :" + order.getQuantities());
                System.out.println("TotalBillAmount :" + order.getTotalbillamount());
                System.out.println("Order Issue Date:" + order.getDate());
                System.out.println("Order Status    :" + order.getStatus());
                System.out.println("UserName        :" + order.getUserName());

                System.out.println("*********************************************");

                ord = order;
            }

        }
        if (!found) {
            System.out.println("OrderDetails not  present");
        }
        return ord;

    }

    public static void cancelOrder(Scanner sc) {
        System.out.println("--------------------------------------------");
        System.out.println("---------Order Cancellation Process---------");
        System.out.println("--------------------------------------------");
        Order order = findOrderDetailsByID(sc);
        if (order != null) {
            System.out.print("Enter 'C' Cancel Order :");
            String cancel = sc.next();
            if (cancel.equalsIgnoreCase("c")) {
                order.setStatus("OrderCancelled");
                GetFileData.loadOrderDetailsIntoFile();
                System.out.println("OrderId " + order.getOrderID() + " got  cancelled");
                System.out.println("----------------------@@----------------------------");
            } else {
                System.out.println("You Seleted Not To Cancel Order");
                System.out.println("----------------------@@----------------------------");

            }
        }

    }
}
