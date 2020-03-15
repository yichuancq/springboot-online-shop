import oauth2.Oauth2App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Oauth2App.class)
public class PassWordTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void encodePassWord() {
        System.out.println("password:" + passwordEncoder.encode("123456"));
    }

}
