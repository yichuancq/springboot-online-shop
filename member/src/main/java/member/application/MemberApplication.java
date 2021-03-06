package member.application;

import member.domain.member.Member;
import member.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 会员管理
 */
@Service
public class MemberApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MemberService memberService;

    /**
     * 保存会员
     *
     * @param member
     * @return
     */
    public Member addMember(Member member) {
        return memberService.addMember(member);
    }

    /**
     * 查询会员
     *
     * @param member
     * @return
     */
    public Member findMember(Member member) {
        return memberService.findOne(member);
    }

}
