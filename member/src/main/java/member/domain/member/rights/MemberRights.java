package member.domain.member.rights;

import member.domain.base.BaseEntity;

import javax.persistence.Column;
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
    @Column(name = "member_rights_id")
    private Long id;
    /**
     * 权益名称
     */
    private String rightsName;

    /**
     * 状态
     */
    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRightsName() {
        return rightsName;
    }

    public void setRightsName(String rightsName) {
        this.rightsName = rightsName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
