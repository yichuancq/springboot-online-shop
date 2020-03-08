package member.service.member.rights;

import member.domain.member.rights.MemberRights;

/**
 * 会员权益
 */
public interface MemberRightsService {
    /**
     * save
     *
     * @param memberRights
     */
    void saveMemberRights(MemberRights memberRights);

    /**
     * @param id
     * @return
     */
    MemberRights findMemberRightsById(Long id);

    /**
     * @param memberRights
     * @return
     */
    MemberRights changeMemberRights(MemberRights memberRights);


    /**
     * findByName
     *
     * @param rightName
     * @return
     */
    MemberRights findByName(String rightName);


}
