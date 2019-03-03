package com.ranx.chowder.study.refactor;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 重构用例--顾客
 * @author ranx
 * @create 2018-08-14 10:16
 **/
public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rental = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rental.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rental.nextElement();
            //重构1提炼出来
//            switch (each.getMovie().getPiceCode()) {
//                case Movie.REGULAR:
//                    thisAmount += 2;
//                    if(each.getDaysRented() > 2) {
//                        thisAmount += (each.getDaysRented() -2) * 1.5;
//                    }
//                    break;
//                case Movie.NEW_RELEASE:
//                    thisAmount += each.getDaysRented() * 3;
//                    break;
//                case Movie.CHILDRENS:
//                    thisAmount += 1.5;
//                    if (each.getDaysRented() > 3) {
//                        thisAmount += (each.getDaysRented() - 3) * 1.5;
//                    }
//                    break;
//            }

            //重构4-这里还可以进化,还可以发现该变量没啥作用了，去掉
            //重构后
//            thisAmount = amountFor(each);
//            thisAmount = each.getCharge();

            //重构6--积分的计算责任应该提炼到Rental
//            frequentRenterPoints ++;
//            if ((each.getMovie().getPiceCode() == Movie.NEW_RELEASE) &&
//                    each.getDaysRented() > 1) {
//                frequentRenterPoints ++;
//            }
            //重构后
//            frequentRenterPoints += each.getFrequentRenterPoints();

            //重构5--发现thisAmount没啥作用了
//            result += "\t" + each.getMovie().getTitle() + "\t" +
//                    String.valueOf(thisAmount) + "\n";
//            totalAmount += thisAmount;
            //重构后
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
//            totalAmount += each.getCharge();
        }
        //重构7--继续去除临时变量
//        result += "Amount pwed is " + String.valueOf(totalAmount) + "\n";
        result += "Amount pwed is " + String.valueOf(getTotalCharge()) + "\n";
//        result += "You earned " + String.valueOf(frequentRenterPoints) +
//                " frequent renter points";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    //再次修改2--更改变量名
//    private double amountFor(Rental each) {
//        double thisAmount = 0;
//        switch (each.getMovie().getPiceCode()) {
//                case Movie.REGULAR:
//                    thisAmount += 2;
//                    if(each.getDaysRented() > 2) {
//                        thisAmount += (each.getDaysRented() -2) * 1.5;
//                    }
//                    break;
//                case Movie.NEW_RELEASE:
//                    thisAmount += each.getDaysRented() * 3;
//                    break;
//                case Movie.CHILDRENS:
//                    thisAmount += 1.5;
//                    if (each.getDaysRented() > 3) {
//                        thisAmount += (each.getDaysRented() - 3) * 1.5;
//                    }
//                    break;
//            }
//            return  thisAmount;
//        }

    //重构4-这里还可以进化,该函数可去除
    private double amountFor(Rental aRental) {
        //重构3--搬移未使用到该类中信息的代码块去相关类中
//        double result = 0;
//        switch (aRental.getMovie().getPiceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if(aRental.getDaysRented() > 2) {
//                    result += (aRental.getDaysRented() -2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += aRental.getDaysRented() * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (aRental.getDaysRented() > 3) {
//                    result += (aRental.getDaysRented() - 3) * 1.5;
//                }
//                break;
//        }
//        return  result;

        //重构后-委托新函数去调用
        return aRental.getCharge();
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rental;
        rental = rentals.elements();
        while (rental.hasMoreElements()) {
            Rental each = (Rental) rental.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rental = rentals.elements();
        while (rental.hasMoreElements()) {
            Rental each = (Rental) rental.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
