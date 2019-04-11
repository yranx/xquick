package com.ranx.chowder.study.designPatterns.strategy_math;

/**
 * 策略枚举
 * @author ranx
 * @create 2019-04-11 17:10
 **/
public enum CalculatorEnum {
    ADD("+") {
        public int exec(int a, int b) {
            return a + b;
        }
    },
    SUB("-") {
        public int exec(int a, int b) {
            return a - b;
        }
    };

    String value="";
    //定义成员值类型
    private CalculatorEnum(String value){
        this.value = value;
    }
    //获得枚举成员的值
    public String getValue() {
        return this.value;
    }

    //声明一个抽象函数
    public abstract int exec(int a, int b);
}
