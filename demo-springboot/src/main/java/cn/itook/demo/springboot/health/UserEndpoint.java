package cn.itook.demo.springboot.health;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author changyanan1
 */
@Component
@Endpoint(id = "user")
public class UserEndpoint {
    @ReadOperation
    public List<Map<String, Object>> health() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(8);
        map.put("userId", "1001");
        map.put("userName", "zhangSan");
        list.add(map);
        return list;
    }
}
