package com.codingpractise;

public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
    double getCharge(int daysRented) {
        double charge = 1.5;
        if(daysRented >  2)
            charge += (daysRented - 3) * 1.5;
        return charge;
    }
}
