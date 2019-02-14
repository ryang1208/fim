package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "t_raw_fund_valuation")
public class RawFundValuation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "seq_t_raw_fund_valuation") // 适配oracle等没有主键自增长的数据库，改用sequence
    @Column(name = "id", nullable = false)
    private Long id;
    /**
     * 编号
     */
    @Column(name = "bh", nullable = false)
    @NotNull
    private Long bh;
    /**
     * 数量
     */
    @Column(name = "sl", length = 20)
    private String sl;
    /**
     * 成本
     */
    @Column(name = "cb", length = 18)
    private String cb;
    /**
     * 市值占净值
     */
    @Column(name = "szzjz", length = 18)
    private String szzjz;
    /**
     * 账套编号
     */
    @Column(name = "ztbh")
    private int ztbh;
    /**
     * 是否确认
     */
    @Column(name = "sfqr")
    private int sfqr;
    /**
     * 科目名称
     */
    @Column(name = "kmmc", length = 100)
    private String kmmc;
    /**
     * 市价
     */
    @Column(name = "hqjz", length = 18)
    private String hqjz;
    /**
     * 估值日期 yyyy-MM-dd
     */
    @Column(name = "ywrq", length = 10)
    private String ywrq;
    /**
     * 成本占净值
     */
    @Column(name = "cbzjz", length = 18)
    private String cbzjz;
    /**
     * 科目代码
     */
    @Column(name = "kmdm", length = 200)
    private String kmdm;
    /**
     * 估值增值
     */
    @Column(name = "gzzz", length = 18)
    private String gzzz;
    /**
     * 市值
     */
    @Column(name = "sz", length = 18)
    private String sz;
    /**
     * 单位成本
     */
    @Column(name = "dwcb", length = 18)
    private String dwcb;
    /**
     * 基金全称
     */
    @Column(name = "fullname", length = 200)
    private String fullname;

    // 鑫管家数据来源
    @Column(name = "raw_data_source")
    private Integer rawDataSource;

    /**
     * 停牌信息
     */
    @Column(name = "stock_suspension_message", length = 200)
    private String stockSuspensionMessage;

    // 基金产品编号
    @Column(name = "product_id", length = 32)
    @Length(min = 1, max = 32)
    @NotNull
    @NotBlank
    private String productId;

    // 托管机构代号（1：恒生，2：赢时胜）
    @Column(name = "trustee_id", length = 1)
    @Length(min = 1, max = 1)
    @NotNull
    @NotBlank
    private String trusteeId;

    @Column(name = "update_date",length = 8)
    private String updateDate;

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getTrusteeId() {
        return trusteeId;
    }

    public void setTrusteeId(String trusteeId) {
        this.trusteeId = trusteeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStockSuspensionMessage() {
        return stockSuspensionMessage;
    }

    public void setStockSuspensionMessage(String stockSuspensionMessage) {
        this.stockSuspensionMessage = stockSuspensionMessage;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getSzzjz() {
        return szzjz;
    }

    public void setSzzjz(String szzjz) {
        this.szzjz = szzjz;
    }

    public int getZtbh() {
        return ztbh;
    }

    public void setZtbh(int ztbh) {
        this.ztbh = ztbh;
    }

    public int getSfqr() {
        return sfqr;
    }

    public void setSfqr(int sfqr) {
        this.sfqr = sfqr;
    }

    public String getKmmc() {
        return kmmc;
    }

    public void setKmmc(String kmmc) {
        this.kmmc = kmmc;
    }

    public String getHqjz() {
        return hqjz;
    }

    public void setHqjz(String hqjz) {
        this.hqjz = hqjz;
    }

    public Long getBh() {
        return bh;
    }

    public void setBh(Long bh) {
        this.bh = bh;
    }

    public String getYwrq() {
        return ywrq;
    }

    public void setYwrq(String ywrq) {
        this.ywrq = ywrq;
    }

    public String getCbzjz() {
        return cbzjz;
    }

    public void setCbzjz(String cbzjz) {
        this.cbzjz = cbzjz;
    }

    public String getKmdm() {
        return kmdm;
    }

    public void setKmdm(String kmdm) {
        this.kmdm = kmdm;
    }

    public String getGzzz() {
        return gzzz;
    }

    public void setGzzz(String gzzz) {
        this.gzzz = gzzz;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getDwcb() {
        return dwcb;
    }

    public void setDwcb(String dwcb) {
        this.dwcb = dwcb;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRawDataSource() {
        return rawDataSource;
    }

    public void setRawDataSource(Integer rawDataSource) {
        this.rawDataSource = rawDataSource;
    }
}
