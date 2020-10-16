import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sileshi Haile Woldemariame
 * Date: 2020-10-09
 * Time: 12:43
 * Project:gym
 * Copyright: MIT
 */
public class Receptionisten {
    List<Customer> customerList = new ArrayList<>();
    ReadAndWrite rw = new ReadAndWrite();
    public Receptionisten(String fileName) throws IOException {
        List<String> file = rw.readFile(fileName);
        for (int i = 0; i < file.size(); i += 2) {
            Customer customer = new Customer();
            String[] firstLine = file.get(i).split(",");
            customer.setName(firstLine[1]);
            customer.setPn(firstLine[0]);
            customer.setPaymentDate(file.get(i + 1));
            this.customerList.add(customer);
        }
    }
    public boolean findCustomer(String pn) {
        boolean found = false;
        for (Customer cust : this.customerList) {
            if (cust.getPn().equals(pn)) {
                cust.toString();
                found = true;
            }
        }
        return found;
    }
    public Boolean isCurrentMember(String pn) {
        boolean isActive = false;
        for (Customer cust : this.customerList) {
            if (cust.getPn().equals(pn)) {
                LocalDate paymentDate = LocalDate.parse(cust.getPaymentDate());
                if (paymentDate.isAfter(LocalDate.now().minusYears(1))) {
                    System.out.println("Customer is Active!!!");
                    isActive = true;
                } else {
                    System.out.println("Customer is not Active!!!");
                }
            }
        }
        return isActive;
    }
    public void printAllCustomer() {
        System.out.println("You Have :" + this.customerList.size() + " Customers!!!");
        for (Customer cust : this.customerList) {
            System.out.println(cust.toString());
        }
    }
    public void printCustomer(String pn) {
        System.out.println("You Have :" + this.customerList.size() + " Customers!!!");
        for (Customer cust : this.customerList) {
            if (cust.getPn().equals(pn)) {
                System.out.println(cust.toString());
            }

        }
    }
    public static void main(String[] args) throws IOException {
        Receptionisten receptionisten = new Receptionisten("src/customers.txt");
        String pn = "7608021234";
        receptionisten.printAllCustomer();
        boolean isCustomerAvailable = receptionisten.findCustomer(pn);
        if (isCustomerAvailable) {
            System.out.println("Customer Found!!!");
            receptionisten.printCustomer(pn);
            boolean isCurrentMember = receptionisten.isCurrentMember(pn);
            if (isCurrentMember) {
                System.out.println("Saving Customer visit info!!!");
                String data = "Visit Date : " + LocalDate.now() + ", PersonalNumber : " + pn;
                receptionisten.rw.writer("src/visitedCust.txt", data);
            } else {
                System.out.println("Customer is not Active, and can not enter the gym!!!");
            }
        } else {
            System.out.println("Customer not found");
        }
    }
}
