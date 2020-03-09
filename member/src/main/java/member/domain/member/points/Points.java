package member.domain.member.points;

import member.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * 积分
 */
@Entity
public class Points extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "points_id")
    private Long id;
    /**
     * 消费时间
     */
    private LocalDateTime consumeTime = LocalDateTime.now();

    /**
     * 当前积分
     */
    private Long consumePoints;
    /**
     * 消费地点
     *
     * @return
     */
    private String consumePlace;

    public String getConsumePlace() {
        return consumePlace;
    }

    public void setConsumePlace(String consumePlace) {
        this.consumePlace = consumePlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(LocalDateTime consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Long getConsumePoints() {
        return consumePoints;
    }

    public void setConsumePoints(Long consumePoints) {
        this.consumePoints = consumePoints;
    }
}
