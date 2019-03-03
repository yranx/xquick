package com.ranx.chowder.study.rovers;

import java.util.ArrayList;
import java.util.List;

/**
 * 漫游车
 * @author ranx
 * @create 2018-09-05 18:55
 **/
public class RevorsTwo {


    public static void main(String[] args) {
        int i=0,s=0;
        do {
            if(i%2 == 0) {
                i++;
                continue;
            }
            i++;
            s = s + i;
        } while ( i< 7);
        System.out.println(s);

        Car.Max_x = 5;
        Car.Max_y = 5;
//        Car car = new Car(1, 2, "N");
        Car car = new Car(0, 0, "N");
        String str = "LMLMLMLMM";
        doRun(car, str);
        car= new Car(3, 3, "E");
        str = "MMRMMRMRRM";
        doRun(car, str);
    }



    public static void doRun(Car car, String str){
        List<Car> carList = new ArrayList<Car>();
        if(car.inspect()){
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
                    doRun(car, str);
                }
            }
        } else {
            System.out.println("坐标输入错误，请重新输入！");
        }

        if(carList!=null && carList.size()>0){
            Car cars = null;
            for(int i=0; i<carList.size(); i++){//输出每辆车的坐标
                cars = carList.get(i);
                System.out.println(cars.getX()+" "+cars.getY()+" "+cars.getFx());
            }
        } else {
            System.out.println("暂无车辆坐标信息！");
        }
    }
}
