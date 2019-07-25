package com.ranx.chowder.designPatterns.memento_mulstate;

import java.util.HashMap;

/**
 * 备忘录角色
 * 备忘他的状态
 * @author ranx
 * @create 2019-04-28 18:18
 **/
public class Memento {
    //接受HashMap作为状态
    private HashMap<String, Object> stateMap;

    public Memento(HashMap<String, Object> stateMap) {
        this.stateMap = stateMap;
    }

    public HashMap<String, Object> getStateMap() {
        return stateMap;
    }

    public void setStateMap(HashMap<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}
