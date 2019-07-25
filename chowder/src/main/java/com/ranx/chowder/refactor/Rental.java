package com.ranx.chowder.refactor;

/**
 * 重构用例--租赁
 * @author ranx
 * @create 2018-08-14 9:57
 **/
public class Rental {

    private Movie movie;
    private int daysRented;

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    //重构7--不建议在另一对象的基础上switch语句，到自己的对象上用
    double getCharge() {
//        double result = 0;
//        switch (getMovie().getPiceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if(getDaysRented() > 2) {
//                    result += (getDaysRented() -2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += getDaysRented() * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (getDaysRented() > 3) {
//                    result += (getDaysRented() - 3) * 1.5;
//                }
//                break;
//        }
//        return  result;

        return movie.getCharge(daysRented);
    }

    //重构7
    //重构6
    int getFrequentRenterPoints() {
//        if ((getMovie().getPiceCode() == Movie.NEW_RELEASE) &&
//                    getDaysRented() > 1) {
//            return 2;
//        }
//        return 1;
        return movie.getFrequentRenterPoints(daysRented);
    }
}
