package com.ranx.chowder.study.rovers;

/**
 * @author ranx
 * @create 2018-09-05 19:03
 **/
public class Car {
    //x坐标值
    private int x;
    //y坐标值
    private int y;
    //方向
    private String fx;
    //最大x值
    static int Max_x;
    //最大y值
    static int Max_y;

    public Car() {
    }

    public Car(int x, int y, String fx) {
        this.x = x;
        this.y = y;
        this.fx = fx.trim();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x<=Max_x && x>=0) {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y<=Max_y && y>=0){
            this.y = y;
        }
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        if("E".equals(fx)||"S".equals(fx)||"W".equals(fx)||"N".equals(fx)){
            this.fx = fx.trim();
        }
    }

    //输入值检验
    public boolean inspect() {
        if(this.x<0||this.x>Max_x
                ||this.y<0||this.y>Max_y
                ||!("E".equals(this.fx)
                ||"W".equals(this.fx)
                ||"S".equals(this.fx)
                ||"N".equals(this.fx))){
            return false;
        }
        return true;
    }

    //移动一步
    public void move(){
        if("E".equals(this.fx)){
            this.x += 1;
        } else if("S".equals(this.fx)){
            this.y -= 1;
        } else if("W".equals(this.fx)){
            this.x -= 1;
        } else if("N".equals(this.fx)){
            this.y += 1;
        }
    }

    //当前朝向-->向左转
    public void gotoLeft(){
        if("E".equals(this.fx)){
            this.fx = "N";
        } else if("S".equals(this.fx)){
            this.fx = "E";
        } else if("W".equals(this.fx)){
            this.fx = "S";
        } else if("N".equals(this.fx)){
            this.fx = "W";
        }
    }
    //当前朝向-->向右转
    public void gotoRight(){
        if("E".equals(this.fx)){
            this.fx = "S";
        } else if("S".equals(this.fx)){
            this.fx = "W";
        } else if("W".equals(this.fx)){
            this.fx = "N";
        } else if("N".equals(this.fx)){
            this.fx = "E";
        }
    }
}
