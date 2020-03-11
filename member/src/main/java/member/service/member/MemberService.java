package member.service.member;

import member.domain.member.Member;

/**
 * member信息服务
 */
public interface MemberService {


    Member addMember(Member member);

    /**
     * @return
     */

    Member findOne(Member member);


    /**
     * @param member
     * @return
     */
    Member modMemberInfo(Member member);
}
