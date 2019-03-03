package com.ranx.chowder.study.refactor;

/**
 * 重构用例--影片
 * @author ranx
 * @create 2018-08-13 17:23
 **/
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    public String title;
//    public int _priceCode;
    private Price price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public int getPiceCode() {
//        return _priceCode;
//    }
//
//    public void setPriceCode(int _priceCode) {
//        this._priceCode = _priceCode;
//    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }


    public Movie(String title, int priceCode) {
        this.title = title;
        //重构8--用设值函数访问
//        this._priceCode = priceCode;
        setPriceCode(priceCode);
    }

    double getCharge(int daysRented) {
//        double result = 0;
//        switch (getPiceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if(daysRented > 2) {
//                    result += (daysRented - 2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += daysRented * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (daysRented > 3) {
//                    result += (daysRented - 3) * 1.5;
//                }
//                break;
//        }
//        return  result;
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
//        if ((getPriceCode() == Movie.NEW_RELEASE) &&
//                daysRented > 1) {
//            return 2;
//        } else {
//            return 1;
//        }
        return price.getFrequentRenterPoints(daysRented);
    }

}
