package member.domain.member;

import member.domain.bill.SaleBill;
import member.domain.cart.ShoppingCart;
import member.domain.express.MemberExpressInfo;
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
     * 一个会员可能存在多个收货地址
     * 会员快递信息
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MemberExpressInfo> memberExpressInfoList;


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
     * 会员购物车
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<ShoppingCart> shoppingCartList;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<MemberExpressInfo> getMemberExpressInfoList() {
        return memberExpressInfoList;
    }

    public void setMemberExpressInfoList(List<MemberExpressInfo> memberExpressInfoList) {
        this.memberExpressInfoList = memberExpressInfoList;
    }

    public MemberDegree getMemberDegree() {
        return memberDegree;
    }

    public void setMemberDegree(MemberDegree memberDegree) {
        this.memberDegree = memberDegree;
    }

    public List<Points> getPointsList() {
        return pointsList;
    }

    public void setPointsList(List<Points> pointsList) {
        this.pointsList = pointsList;
    }

    public List<SaleBill> getSaleBillList() {
        return saleBillList;
    }

    public void setSaleBillList(List<SaleBill> saleBillList) {
        this.saleBillList = saleBillList;
    }

    public List<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public List<MemberGift> getMemberGiftList() {
        return memberGiftList;
    }

    public void setMemberGiftList(List<MemberGift> memberGiftList) {
        this.memberGiftList = memberGiftList;
    }

    public String getSalePlace() {
        return salePlace;
    }

    public void setSalePlace(String salePlace) {
        this.salePlace = salePlace;
    }

    public LocalDateTime getStartTIme() {
        return startTIme;
    }

    public void setStartTIme(LocalDateTime startTIme) {
        this.startTIme = startTIme;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
