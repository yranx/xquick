package com.ranx.chowder.refactor;

/**
 * 提供类型相关行为
 * @author ranx
 * @create 2018-08-14 16:28
 **/
public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    //不声明为abstra，留一个默认行为
    int getFrequentRenterPoints(int daysRented) {
//        if ((getPriceCode() == Movie.NEW_RELEASE) &&
//                daysRented > 1) {
//            return 2;
//        } else {
            return 1;
//        }
    }
}
