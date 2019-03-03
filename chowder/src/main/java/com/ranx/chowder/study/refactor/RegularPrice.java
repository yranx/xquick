package com.ranx.chowder.study.refactor;

/**
 * 提供类型相关行为
 * @author ranx
 * @create 2018-08-14 16:28
 **/
public class RegularPrice extends Price{
    @Override
    int getPriceCode(){
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if(daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
