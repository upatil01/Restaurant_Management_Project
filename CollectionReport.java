package RestaurantManagementProject;

import java.time.LocalDate;
import java.util.Scanner;

public class CollectionReport {
    private LocalDate date;
    private double totalCollectionAmount;
    Order ord;

    public CollectionReport(LocalDate date, double totalCollectionAmount) {
        this.date = date;
        this.totalCollectionAmount = totalCollectionAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalCollectionAmount() {
        return totalCollectionAmount;
    }

    public void setTotalCollectionAmount(double totalCollectionAmount) {
        this.totalCollectionAmount = totalCollectionAmount;
    }

    public static double getDailyCollection(Scanner sc) {
        double collection = 0;
        System.out.println("Enter the Date :'yyyy-mm-dd' ");
        String Date = sc.next();
        int orderConfirmed = 0;
        int orderCancelled = 0;
        LocalDate date = LocalDate.parse(Date);
        for (Order order : GetFileData.orderDetails) {
            if (order.getDate().equals(date) && order.getStatus().equalsIgnoreCase("OrderConfirmed")) {
                orderConfirmed++;
                collection += order.getTotalbillamount();
            } else if (order.getDate().equals(date) && order.getStatus().equalsIgnoreCase("OrderCancelled")) {
                orderCancelled++;
            }
        }
        System.out.println("Total  Revenue for " + date + " is " + collection);
        System.out.println("Order Confirmed  :" + orderConfirmed);
        System.out.println("Order Cancelled  :" + orderCancelled);
        return collection;

    }
}
