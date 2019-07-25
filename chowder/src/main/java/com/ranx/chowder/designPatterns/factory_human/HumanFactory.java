package com.ranx.chowder.designPatterns.factory_human;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 人类创建工厂： 实现生产人类的方法
 * @author ranx
 * @create 2018-11-21 17:27
 **/
public class HumanFactory extends AbstractHumanFactory {
    private static final Logger logger = LoggerFactory.getLogger(HumanFactory.class);
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;

        try {
            human = (Human)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            logger.info("人种生成错误！");
            e.printStackTrace();
        }
        return (T)human;
    }
}
