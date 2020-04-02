package oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Oauth2App {
    //test new branch
    public static void main(String[] args) {
        SpringApplication.run(Oauth2App.class, args);
    }
}
