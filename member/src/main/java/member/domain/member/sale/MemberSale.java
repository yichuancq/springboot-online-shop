package member.domain.member.sale;

import member.domain.base.BaseEntity;
import member.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 会员消费记录
 */
@Entity
public class MemberSale extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Member member;

    /**
     * 消费明细
     */
    @OneToMany
    private List<MemberSaleItem> memberSaleItemList;
    /**
     * 操作人
     */
    private String operator;

    /**
     *
     */
    private LocalDateTime happenTime;
    /**
     * 消费地点
     *
     * @return
     */
    private String salePlace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<MemberSaleItem> getMemberSaleItemList() {
        return memberSaleItemList;
    }

    public void setMemberSaleItemList(List<MemberSaleItem> memberSaleItemList) {
        this.memberSaleItemList = memberSaleItemList;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalDateTime getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(LocalDateTime happenTime) {
        this.happenTime = happenTime;
    }

    public String getSalePlace() {
        return salePlace;
    }

    public void setSalePlace(String salePlace) {
        this.salePlace = salePlace;
    }
}
