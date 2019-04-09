package wrx.xing;

import java.math.BigDecimal;

public class BillingRequestMessageData {

    private Long venderId;
    private Integer venderSource;//商家来源
    private Long accountId;
    private Long orderId;
    private Integer orderType;
    private Integer orderStatus;//订单状态:19-完成,26-退货,0-非销售单
    private Long rfBillId;//原始单据ID(退货-退货服务单号，其他为订单号且订单状态必须传19）
    private Integer rfBillType;//业务类型
    private String happenTime;
    private Integer feeType;//费用类型：1、订单费;2、服务费;3、调账;4、团购费;5、代收代付;6、物流损
    private Integer serviceFeeType;//服务费用类型：1,平台使用费，2,积分
    private String feeName;//费用名称
    private String unit;//计量单位
    private Integer num;//数量
    private Integer direction;//收支方向	1 站在商家角度应收 ，-1 站在商家角度应付
    private BigDecimal bal;//金额:  单位：元	保留两位小数
    private String currency;//币种	USD、CNY
    private String remark;
    private String formulaData;//费用计算关键公式说明	示例："佣金 = （货款：75.0）* （佣金比率：9.0）"
    private String rfUuid;//调用方业务全局UUID
    private String organId;//订单机构ID
    private String orderTime;
    private Boolean needExchangeCurrency;//是否需要换汇
    private String exchangeCurrency;

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public Integer getVenderSource() {
        return venderSource;
    }

    public void setVenderSource(Integer venderSource) {
        this.venderSource = venderSource;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getRfBillId() {
        return rfBillId;
    }

    public void setRfBillId(Long rfBillId) {
        this.rfBillId = rfBillId;
    }

    public Integer getRfBillType() {
        return rfBillType;
    }

    public void setRfBillType(Integer rfBillType) {
        this.rfBillType = rfBillType;
    }

    public String getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(String happenTime) {
        this.happenTime = happenTime;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public Integer getServiceFeeType() {
        return serviceFeeType;
    }

    public void setServiceFeeType(Integer serviceFeeType) {
        this.serviceFeeType = serviceFeeType;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public BigDecimal getBal() {
        return bal;
    }

    public void setBal(BigDecimal bal) {
        this.bal = bal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFormulaData() {
        return formulaData;
    }

    public void setFormulaData(String formulaData) {
        this.formulaData = formulaData;
    }

    public String getRfUuid() {
        return rfUuid;
    }

    public void setRfUuid(String rfUuid) {
        this.rfUuid = rfUuid;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Boolean getNeedExchangeCurrency() {
        return needExchangeCurrency;
    }

    public void setNeedExchangeCurrency(Boolean needExchangeCurrency) {
        this.needExchangeCurrency = needExchangeCurrency;
    }

    public String getExchangeCurrency() {
        return exchangeCurrency;
    }

    public void setExchangeCurrency(String exchangeCurrency) {
        this.exchangeCurrency = exchangeCurrency;
    }
}
