package com.ranx.chowder.study.designPatterns.composite_normal;

/**
 * @author ranx
 * @create 2019-04-22 10:51
 **/
public class Client {
    public static void main(String[] args) {
        //创建一个根节点
        Composite root = new Composite();
        root.doSomething();
        //创建一个树枝构件
        Composite branch = new Composite();
        //创建一个叶子节点
        Leaf leaf = new Leaf();

        //简历整体
        root.add(branch);
        branch.add(leaf);
    }

    //递归遍历树
    public static void display(Composite root) {
        for (Component c : root.getChildren()) {
            if (c instanceof Leaf) {
                c.doSomething();
            } else {
                display((Composite)c);
            }
        }
    }
}
