package oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/loginOutSuccess").setViewName("loginOutSuccess");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/userList").setViewName("userList");

    }
}
