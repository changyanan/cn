package cn.itook.springsecurityjwt.control;

import cn.itook.springsecurityjwt.result.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class UserController {
    // 路由映射到/users
    @RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public String usersList() {

        ArrayList<String> users = new ArrayList<String>() {{
            add("freewolf");
            add("tom");
            add("jerry");
        }};

        return JSONResult.fillResultString(0, "", users);
    }

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public String hello() {
        ArrayList<String> users = new ArrayList<String>() {{
            add("hello");
        }};
        return JSONResult.fillResultString(0, "", users);
    }

    @RequestMapping(value = "/world", produces = "application/json;charset=UTF-8")
    public String world() {
        ArrayList<String> users = new ArrayList<String>() {{
            add("world");
        }};
        return JSONResult.fillResultString(0, "", users);
    }
}
