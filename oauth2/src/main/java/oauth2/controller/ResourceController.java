package oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于不同权限页面访问测试
 */
@RestController
public class ResourceController {

    @GetMapping("/publicResource")
    public String toPublicResource() {
        return "resource/public";
    }

    @GetMapping("/vipResource")
    public String toVipResource() {
        return "resource/vip";
    }

}
