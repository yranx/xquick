package com.ranx.chowder.study.designPatterns.composite_normal_lucency;


import java.util.ArrayList;

/**
 * 树叶构件
 * 树叶节点没有子下级的对象
 * @author ranx
 * @create 2019-04-22 10:49
 **/
public class Leaf extends Component {

    @Deprecated
    @Override
    public void add(Component component) throws UnsupportedOperationException{
        //空实现，抛出“不支持请求”异常
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public void remve(Component component) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public ArrayList<Component> getChildren() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
}
