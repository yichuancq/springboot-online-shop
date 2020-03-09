package member.domain.member.degree;

import member.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 会员级别
 */
@Entity
public class MemberDegree extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_degree_id")
    private Long id;
    //需要的点值
    private Long needPoint;
    //等级名称
    private String degreeName;
    //会员状态
    private Integer status;
    //
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNeedPoint() {
        return needPoint;
    }

    public void setNeedPoint(Long needPoint) {
        this.needPoint = needPoint;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
