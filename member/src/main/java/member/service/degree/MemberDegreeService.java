package member.service.degree;

import member.domain.member.degree.MemberDegree;

/**
 * 会员等级
 */
public interface MemberDegreeService {

    /**
     * 获取会员等级
     **/

    Long getMemberDegree();

    /**
     * 修改等级
     */
    void changeMemberDegree(Long degree);

    /**
     * @param memberDegree
     * @return
     */
    MemberDegree changeMemberDegree(MemberDegree memberDegree);
}
