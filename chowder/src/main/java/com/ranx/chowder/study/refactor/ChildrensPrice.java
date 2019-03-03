package com.ranx.chowder.study.refactor;

/**
 * 提供类型相关行为
 * @author ranx
 * @create 2018-08-14 16:28
 **/
public class ChildrensPrice extends Price{
    @Override
    int getPriceCode(){
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
