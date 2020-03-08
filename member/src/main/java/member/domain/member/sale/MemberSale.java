package member.domain.member.sale;

import member.domain.base.BaseEntity;
import member.domain.member.Member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

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

}
