package com.ranx.chowder.newFeatures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranx
 * @create 2018-08-29 12:21
 **/
public class MethodReferences {

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    class Car {
        public  Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired" + this.toString());
        }
    }

    public static void main(String args[]){
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
