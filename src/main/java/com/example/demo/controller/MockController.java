package com.example.demo.controller;


import cn.hutool.core.util.RandomUtil;
import com.example.demo.model.Info;
import com.example.demo.model.R;
import com.example.demo.model.User;
import com.forte.util.Mock;
import com.forte.util.utils.MockUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@Api(tags = "mock")
@RestController
@RequestMapping("/mock")
public class MockController {


    @GetMapping("/api/a")
    public R<Object> mockA() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userName", "@cname");
        map.put("userId|4", 0);
        map.put("email", "@email");
        Mock.reset(User.class, map);
        User user = Mock.get(User.class).getOne();
        return R.data(user);
    }

    @GetMapping("/api/b")
    public R<String> mockB() {
        return R.data(MockUtil.word(3, 12));
    }

    @GetMapping("/api/c")
    public R<List> mockC() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("url", "@url");
        map.put("ip", "@ip");
        map.put("id|4", 0);
        Mock.reset(Info.class, map);
        List<Info> list = Mock.get(Info.class).getList(RandomUtil.randomInt(10, 20));
        return R.data(list);
    }
}
