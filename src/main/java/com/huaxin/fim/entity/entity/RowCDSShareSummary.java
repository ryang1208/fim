package com.huaxin.fim.entity.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 持有人份额对应的实体类
 */
@Entity
@Table(name = "t_raw_cds_share_summary")
public class RowCDSShareSummary implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "seq_t_raw_cds_share_summary")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id",length = 10)
    private String productId;

    @Column(name = "date",length = 8)
    private String date;

    @Column(name="client_name",length = 50)
    private String clientName;

    @Column(name = "data_source")
    private int dataSource;

    @Column(name = "client_type")
    private String clientType;

    @Column(name="update_date")
    private String updateDate;

    @Column(name = "hoding_share",precision = 20,scale = 6)
    @Digits(integer = 14,fraction = 6)
    private BigDecimal hodingShare;

    @Column(name = "frozen_share",precision = 20,scale = 6)
    @Digits(integer = 14,fraction = 6)
    private BigDecimal frozenShare;

    @Column(name = "pledge_share",precision = 20,scale = 6)
    @Digits(integer = 14,fraction = 6)
    private BigDecimal pledgeShare;

    @Column(name = "available_share",precision = 20,scale = 6)
    @Digits(integer = 14,fraction = 6)
    private BigDecimal availableShare;

    @Column(name = "client_product_id",length = 10)
    private String clientProductId;

    @Column(name = "client_product_code",length = 10)
    private String clientProductCode;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getDataSource() {
        return dataSource;
    }

    public void setDataSource(int dataSource) {
        this.dataSource = dataSource;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getHodingShare() {
        return hodingShare;
    }

    public void setHodingShare(BigDecimal hodingShare) {
        this.hodingShare = hodingShare;
    }

    public BigDecimal getFrozenShare() {
        return frozenShare;
    }

    public void setFrozenShare(BigDecimal frozenShare) {
        this.frozenShare = frozenShare;
    }

    public BigDecimal getPledgeShare() {
        return pledgeShare;
    }

    public void setPledgeShare(BigDecimal pledgeShare) {
        this.pledgeShare = pledgeShare;
    }

    public BigDecimal getAvailableShare() {
        return availableShare;
    }

    public void setAvailableShare(BigDecimal availableShare) {
        this.availableShare = availableShare;
    }

    public String getClientProductId() {
        return clientProductId;
    }

    public void setClientProductId(String clientProductId) {
        this.clientProductId = clientProductId;
    }

    public String getClientProductCode() {
        return clientProductCode;
    }

    public void setClientProductCode(String clientProductCode) {
        this.clientProductCode = clientProductCode;
    }
}
