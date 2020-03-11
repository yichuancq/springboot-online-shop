package member.domain.member;

import member.domain.bill.SaleBill;
import member.domain.member.account.Account;
import member.domain.member.degree.MemberDegree;
import member.domain.member.gift.MemberGift;
import member.domain.member.points.Points;
import member.domain.person.Person;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 会员基本信息
 */
@Entity
public class Member extends Person {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    /**
     * 账户信息
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Account account;
    /**
     * 会员等级
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private MemberDegree memberDegree;
    /**
     * 会员积分记录
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Points> pointsList;
    /**
     * 会员消费记录
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<SaleBill> saleBillList;
    /**
     * 不产生销售也可能获取兑换礼品
     * 礼品兑换
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<MemberGift> memberGiftList;
    /**
     * 售卡地
     */
    private String salePlace;
    /**
     * 会员卡开卡时间
     */
    private LocalDateTime startTIme;
    /**
     * 会员卡有效结束时间
     */
    private LocalDateTime endTime;

}
