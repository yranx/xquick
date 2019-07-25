package com.ranx.chowder.designPatterns.factory_normal;

/**
 * 具体工厂类
 * @author ranx
 * @create 2019-02-15 16:41
 **/
public class CreatorFactory extends AbstractCreatorFactory {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)product;
    }
}
