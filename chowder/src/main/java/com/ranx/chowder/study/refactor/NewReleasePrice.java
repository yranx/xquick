package com.ranx.chowder.study.refactor;

/**
 * 提供类型相关行为
 * @author ranx
 * @create 2018-08-14 16:28
 **/
public class NewReleasePrice extends Price{
    @Override
    int getPriceCode(){
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1 ) ? 2 : 1;
    }
}
