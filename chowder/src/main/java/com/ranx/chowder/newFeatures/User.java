package com.ranx.chowder.newFeatures;

import java.util.List;

/**
 * @author ranx
 * @create 2019-04-10 9:28
 **/
public class User {
    private String name;
    private Integer age;
    private String sex;
    private List<String> hobbys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        if (obj != null) {
            if (this.getClass().getName().equals(obj.getClass().getName())) {
                User user = (User) obj;
                isEquals = this.age == user.age
                        && this.name.equals(user.name)
                        && this.sex.equals(user.sex);
            }
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + this.age;
        result = result * 31 + this.name.hashCode();
        result = result * 31 + this.sex.hashCode();
        return result;
    }
}
