package member.service.member.member;

import member.domain.member.Member;

/**
 * member信息服务
 */
public interface MemberService {

    /**
     * @return
     */

    Member getMemberInfo();


    /**
     * @param member
     * @return
     */
    Member modMemberInfo(Member member);
}
