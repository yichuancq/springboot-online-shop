package oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
////https://blog.csdn.net/Sunday2017/article/details/83690383
//https://www.cnblogs.com/zwqh/p/11934880.html
public class Oauth2App {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2App.class, args);
    }
}
