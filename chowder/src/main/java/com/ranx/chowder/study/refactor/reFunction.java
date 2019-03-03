package com.ranx.chowder.study.refactor;

import java.util.Arrays;
import java.util.List;

/**
 * @author ranx
 * @create 2018-08-16 16:54
 **/
public class reFunction {
    int quantity;
    int itemPrice;


    //有两个临时变量，重构掉--用查询或查询函数替代临时变量
//    double getPrice() {
//        int basePrice = _quantity * _itemPrice;
//        double discountFactor;
//        if (basePrice > 1000)
//            discountFactor = 0.95;
//        else
//            discountFactor = 0.98;
//
//        return basePrice * discountFactor;
//    }
    double getPrice() {
        return basePrice() * discountFactor();
    }

    int basePrice() {
        return  quantity * itemPrice;
    }

    double discountFactor() {
        if (basePrice() > 1000) {
            return 0.95;
        }
        else {
            return 0.98;
        }
    }


    class Account {
        //重构示例---以函数对象取代函数
        int gamma (int inputVal, int quantity, int yearToDate) {
//            int importantValue1 = (inputVal * quantity);
//            int importantValue2 = (inputVal * yearToDate) + 100;
//            if ((yearToDate - importantValue1) > 100){
//                importantValue2 -= 20;
//            }
//            int importantValue3 = importantValue2 * 7;
//            return importantValue3 - 2 * importantValue1;
            return new Gamma(this, inputVal, quantity, yearToDate).compute();
        }
    }


    class Gamma {
        private Account account;
        private int inputVal;
        private int quantity;
        private int yearToDate;
        private int importantValue1;
        private int importantValue2;
        private int importantValue3;

        public Gamma(Account source, int inputValArg, int quantityArg, int yearToDateArg) {
            account = source;
            inputVal = inputValArg;
            quantity = quantityArg;
            yearToDate = yearToDateArg;
        }

        int compute () {
            int importantValue1 = (inputVal * quantity);
            int importantValue2 = (inputVal * yearToDate) + 100;
//            if ((yearToDate - importantValue1) > 100){
//                importantValue2 -= 20;
//            }
            importantThing();
            int importantValue3 = importantValue2 * 7;
            return importantValue3 - 2 * importantValue1;
        }

        void importantThing() {
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
        }
    }

    //重构--替换算法
    String foundPerson(String[] people) {
//        for (int i=0; i<people.length; i++) {
//            if (people[i].equals("Don")) {
//                return "Don";
//            }
//            if (people[i].equals("John")) {
//                return "John";
//            }
//            if (people[i].equals("Kent")) {
//                return "Kent";
//            }
//        }
//        return "";

        // ===>
        List candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
        for (int i=0; i< people.length; i++) {
            if (candidates.contains(people[i])) {
                return people[i];
            }
        }
        return "";
    }
}
