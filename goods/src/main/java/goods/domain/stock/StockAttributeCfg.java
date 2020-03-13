package goods.domain.stock;

public enum StockAttributeCfg {
    //待付款,待发货,待收货，已完成
    DEFAULT_STOCK("默认", 1),
    NORMAL_STOCK("正常库", 2),
    ON_WAY_STOCK("在途库", 3),
    ON_BROKEN_STOCK("报损库", 4),
    DN_PREPARE_STOCK("预存库", 5);
    private String name;
    private int index;

    // 构造方法
    private StockAttributeCfg(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.index + "-" + this.name;
    }
}
