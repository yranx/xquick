package com.ranx.chowder.designPatterns.adapter_user;

import java.util.Map;

/**
 * 劳务公司的人员信息接口
 * @author ranx
 * @create 2019-04-11 18:44
 **/
public interface IOuterUser {
    //基本信息:比如名称，性别，手机号码等
    public Map getUserbaseInfo();

    //工作区域信息
    public Map getUserOfficeInfo();

    //用户的家庭信息
    public Map getUserHomeInfo();
}
