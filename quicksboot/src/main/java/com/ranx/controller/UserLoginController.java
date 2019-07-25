package com.ranx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ranx.annotation.AuthToken;
import com.ranx.mapper.TSysUserMapper;
import com.ranx.model.entity.TSysUser;
import com.ranx.utils.ConstantUtil;
import com.ranx.utils.Md5TokenGenerator;
import com.ranx.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author ranx
 * @create 2018-08-08 10:22
 **/
@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private Md5TokenGenerator tokenGenerator;

    @Autowired
    private TSysUserMapper tSysUserMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("用户登录接口")
    public Result login(@RequestBody(required = false)JSONObject userInfo) {
        String username = userInfo.getString("username");
        String password = userInfo.getString("password");

        List<TSysUser> users = tSysUserMapper.selectList(new EntityWrapper<TSysUser>()
        .eq("username", username)
        .eq("password", password));

        TSysUser currentUser = users.get(0);

        JSONObject result = new JSONObject();
        if (currentUser != null) {

            Jedis  jedis = new Jedis("localhost", 6379);
            String token = tokenGenerator.generate(username, password);
            jedis.set(username, token);
            jedis.expire(username, ConstantUtil.TOKEN_EXPIRE_TIME);
            jedis.set(token, username);
            jedis.expire(token, ConstantUtil.TOKEN_EXPIRE_TIME);
            Long currentTime = System.currentTimeMillis();
            jedis.set(token + username, currentTime.toString());

            //用完关闭
            jedis.close();

            result.put("status", "登录成功");
            result.put("token", token);
        } else {
            result.put("status", "登录失败");
        }

        return new Result(200,"登录成功",result);

    }

    @ApiOperation("测试token接口")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @AuthToken
    public Result test() {
        List<TSysUser> user = new TSysUser().selectAll();
        return new Result(200,"登录成功",user);
    }
}
