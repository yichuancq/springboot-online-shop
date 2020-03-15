package oauth2.handler;

import oauth2.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomerSavedRequestAwareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @param request
     * @param response
     * @param authentication
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws ServletException, IOException {

        String targetUrlParameter = getTargetUrlParameter();
        logger.info("targetUrlParameter=>{}", targetUrlParameter);
        logger.info("登录成功");
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();
//        String targetUrl = savedRequest.getRedirectUrl() + "/home/welcome";
        logger.info("登录用户user:{}", userInfo.getUsername());
        String targetUrl = "/welcome";
        /// 认证成功后，获取用户信息并添加到session中
        request.getSession().setAttribute("userInfo", userInfo);
        logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
        //getRedirectStrategy().sendRedirect(request, response, targetUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
