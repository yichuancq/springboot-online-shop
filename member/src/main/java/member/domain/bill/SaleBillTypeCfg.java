package member.domain.bill;

public enum SaleBillTypeCfg {
    //待付款,待发货,待收货，已完成
    DEFAULT_STATUS("默认", 1),
    NO_PAY_STATUS("待付款", 2),
    NO_SEND_STATUS("待发货", 3),
    NOT_RECEIVE_STATUS("待收货", 4),
    ON_DONE_STATUS("已完成", 5),
    ON_CANCEL_STATUS("已取消", 6);
    private String name;
    private int index;

    // 构造方法
    private SaleBillTypeCfg(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.index + "-" + this.name;
    }
}
