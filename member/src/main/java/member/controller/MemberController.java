package member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import member.application.MemberApplication;
import member.domain.member.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "会员信息API")
@RequestMapping("/member")
public class MemberController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MemberApplication memberApplication;

    /**
     * @param member
     * @return
     */
    @ApiOperation(value = "findMember", notes = "findMember")
    @RequestMapping(value = "/findMember", method = RequestMethod.GET)
    public Member findMember(Member member) {
        try {
            return memberApplication.findMember(member);
        } catch (Exception e) {
            logger.error("ex:{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
