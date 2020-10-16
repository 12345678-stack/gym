/**
 * Created by Sileshi Haile Woldemariame
 * Date: 2020-10-09
 * Time: 18:52
 * Project:gym
 * Copyright: MIT
 */
public class Customer {
   private String name;
   private String pn;
   private String paymentDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", pn='" + pn + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                '}';
    }
}
