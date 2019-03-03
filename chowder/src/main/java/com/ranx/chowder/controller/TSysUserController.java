package com.ranx.chowder.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ranx.chowder.model.entity.TSysUser;
import com.ranx.chowder.model.vo.TSysUserVO;
import com.ranx.chowder.service.TSysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *  前端控制器
 *
 * @author ranx
 * @since 2018-08-07
 */
@Controller
@RequestMapping("/tSysUser")
public class TSysUserController {
    @Autowired
    private TSysUserService tSysUserService;

    /**
     * list 查询测试
     *
     */
    @RequestMapping("/testSelect")
    @ResponseBody
    public Object testSelect() {
        // 构造实体对应的 EntityWrapper 对象，进行过滤查询
        EntityWrapper<TSysUser> ew = new EntityWrapper<>();
//        ew.where("type={0}", 1)
//                .like("name", "王")
//                .and("core_number={0}", 24)
//                .and("is_delete=0");
        /**
         SELECT
         id,username,`password`,created_at AS createdAt,updated_at AS updatedAt,del_flag AS delFlag
         FROM t_sys_user WHERE (del_flag = 0 AND username LIKE "%wang")
         */
        ew.where("del_flag=0")
                .like("username", "%王");
        List<TSysUser> list = tSysUserService.selectList(ew);
        List<Map<String, Object>> maps = tSysUserService.selectMaps(ew);
        System.out.println(list);
        System.out.println(maps);
        return "ok";
    }

//    /**
//     * 分页 查询测试
//     */
//    @RequestMapping("/2")
//    @ResponseBody
//    public Object test2() {
//        // 构造实体对应的 EntityWrapper 对象，进行过滤查询
//        EntityWrapper<Cable> ew = new EntityWrapper<>();
//        ew.where("type={0}", 1)
////    .like("name", "王")
//                .and("core_number={0}", 24)
//                .and("is_delete=0");
//        Page<Cable> page = new Page<>(1,10);
//        Page<Cable> pageRst = tSysUserService.selectPage(page, ew);
//        return pageRst;
//    }
//
//    /**
//     * 自定义查询字段
//     */
//    @RequestMapping("/3")
//    @ResponseBody
//    public Object test3() {
//        Object vl = null;
//        // 构造实体对应的 EntityWrapper 对象，进行过滤查询
//        EntityWrapper<Cable> ew = new EntityWrapper<>();
//        ew.setSqlSelect("id, `name`, "
//                + "case type\n" +
//                "when 1 then '220kv'\n" +
//                "end typeName")
//                .where("type={0}", 1)
////    .like("name", "王")
//                .where(false, "voltage_level=#{0}", vl);//当vl 为空时，不拼接
//        Page<Cable> page = new Page<>(1,10);
//        Page<Cable> pageRst = tSysUserService.selectPage(page, ew);
//        return pageRst;
//    }
//
    /**
     * insert
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object insert(@Valid TSysUserVO tSysUserVO, BindingResult bindingResult) {
        TSysUser tSysUser = new TSysUser();
        if (!bindingResult.hasErrors()) {
            BeanUtils.copyProperties(tSysUserVO, tSysUser);
            tSysUserService.insert(tSysUser);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError objectError : list) {
                stringBuffer.append(objectError.getDefaultMessage());
                stringBuffer.append("---");
            }
            return stringBuffer !=null ? stringBuffer.toString() : "";
        }

        return "ok";
    }
//
//    /**
//     * update
//     */
//    @RequestMapping("/5")
//    @ResponseBody
//    public Object test5() {
//        Cable c = tSysUserService.selectById(22284l);
//        c.setName("测试光缆2222");
//        c.setType(1);
//        tSysUserService.updateById(c);
//        return "ok";
//    }

}

