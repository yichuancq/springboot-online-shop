package member.domain.member.rights;

import member.domain.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 会员权益
 */
@Entity
public class MemberRights extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 权益名称
     */
    private String rightsName;

    /**
     * 状态
     */
    private Integer state;


}
