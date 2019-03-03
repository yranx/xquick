package com.ranx.chowder.study.rovers;

import java.util.ArrayList;
import java.util.List;

/**
 * 漫游车
 * @author ranx
 * @create 2018-09-05 18:55
 **/
public class Revors {
    public static final char FLAG[] = {'E', 'S', 'W', 'N'};

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Car> carList = new ArrayList<Car>();
//        Car.Max_x = sc.nextInt();
//        Car.Max_y = sc.nextInt();
//
//        while(!sc.hasNext("EXIT")){
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            String fx = sc.next();
//            getCoordinate(x, y, fx, carList, sc);
//        }
//
//        if(carList!=null && carList.size()>0){
//            Car car = null;
//            for(int i=0; i<carList.size(); i++){//输出每辆车的坐标
//                car = carList.get(i);
//                System.out.println(car.getX()+" "+car.getY()+" "+car.getFx());
//            }
//        } else {
//            System.out.println("暂无车辆坐标信息！");
//        }
//        sc.close();
//        carList.clear();
//    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Car.Max_x = sc.nextInt();
//        Car.Max_y = sc.nextInt();
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        String fx = sc.next();
        Car.Max_x = 5;
        Car.Max_y = 5;
        Car car = new Car(1, 2, "N");
        String str = "LMLMLMLMM";
        doRun(car, str);
        car= new Car(3, 3, "E");
        str = "MMRMMRMRRM";
        doRun(car, str);
    }

    public static void doRun(Car car, String str) {
        List<Car> carList = new ArrayList<Car>();
//        Car.Max_x = x;
//        Car.Max_y = y;
        getCoordinate(car.getX(), car.getY(), car.getFx(), carList, str);

        if(carList!=null && carList.size()>0){
            Car cars = null;
            for(int i=0; i<carList.size(); i++){//输出每辆车的坐标
                cars = carList.get(i);
                System.out.println(cars.getX()+" "+cars.getY()+" "+cars.getFx());
            }
        } else {
            System.out.println("暂无车辆坐标信息！");
        }
//        sc.close();
        carList.clear();
    }

//    public static void getCoordinate(int x, int y, String fx, List<Car> carList, Scanner sc){
//        Car car = new Car(x,y,fx);
//        if(car.inspect()){
//            String str = sc.next();
//            if(str!=null && str.length()>0){
//                boolean isSuccess = true;//标记若是命令错误则提示重输递归
//                for(int i=0; i<str.length(); i++){
//                    if("M".equals(String.valueOf(str.charAt(i)))){
//                        car.move();
//                    } else if("L".equals(String.valueOf(str.charAt(i)))){
//                        car.gotoLeft();
//                    } else if("R".equals(String.valueOf(str.charAt(i)))){
//                        car.gotoRight();
//                    } else {
//                        System.out.println("命令输入错误，请重新输入！");
//                        isSuccess = false;
//                        break;
//                    }
//                }
//                if(isSuccess){
//                    carList.add(car);
//                } else {
//                    getCoordinate(x, y, fx, carList, sc);
//                }
//            }
//        } else {
//            System.out.println("坐标输入错误，请重新输入！");
//        }
//    }

    public static void getCoordinate(int x, int y, String fx, List<Car> carList, String str){
        Car car = new Car(x,y,fx);
        if(car.inspect()){
//            String str = sc.next();
            if(str!=null && str.length()>0){
                boolean isSuccess = true;//标记若是命令错误则提示重输递归
                for(int i=0; i<str.length(); i++){
                    if("M".equals(String.valueOf(str.charAt(i)))){
                        car.move();
                    } else if("L".equals(String.valueOf(str.charAt(i)))){
                        car.gotoLeft();
                    } else if("R".equals(String.valueOf(str.charAt(i)))){
                        car.gotoRight();
                    } else {
                        System.out.println("命令输入错误，请重新输入！");
                        isSuccess = false;
                        break;
                    }
                }
                if(isSuccess){
                    carList.add(car);
                } else {
                    getCoordinate(x, y, fx, carList, str);
                }
            }
        } else {
            System.out.println("坐标输入错误，请重新输入！");
        }
    }
}
