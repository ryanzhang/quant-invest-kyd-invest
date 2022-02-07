
package com.cgc.horizon0.account.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "big_small_etf_rotate", schema = "invest")
public class BigSmallEtfRotate extends PanacheEntity {

    @Column(name = "account_id")
    public Integer accountId;
    @Column(name = "trade_date")
    @Temporal(TemporalType.DATE)
    public Date tradeDate;
    @Column(name = "is_suspend")
    public Integer isSuspend; // 策略是否暂停实施
    @Column(name = "is_skip_trade")
    public Integer isSkipTrade; // 是否跳过量化交易
    @Column(name = "ticker_x")
    public String tickerX;
    @Column(name = "pre_close_price_x")
    public Float preClosePriceX;
    @Column(name = "open_price_x")
    public Float openPriceX;
    @Column(name = "close_price_x")
    public Float closePriceX;
    @Column(name = "chg_x")
    public Float chgX;
    @Column(name = "chg_pct_x")
    public Float chgPctX;
    @Column(name = "ticker_y")
    public String tickerY;
    @Column(name = "pre_close_price_y")
    public Float preClosePriceY;
    @Column(name = "open_price_y")
    public Float openPriceY;
    @Column(name = "close_price_y")
    public Float closePriceY;
    @Column(name = "chg_y")
    public Float chgY;
    @Column(name = "chg_pct_y")
    public Float chgPctY;
    @Column(name = "big_mom")
    public Float bigMom;
    @Column(name = "small_mom")
    public Float smallMom;
    @Column(name = "style")
    public String style; // 风格
    @Column(name = "pos")
    public String pos;// 持仓
    @Column(name = "vol")
    public String vol;// 多少手
    @Column(name = "pos_chg_pct")
    public Float posChgPct;// 扣除手续费后的涨幅
    @Column(name = "trade_fee")
    public Float tradeFee; // 扣除手续费后的涨幅
    @Column(name = "big_net")
    public Float bigNet;// 净值因子
    @Column(name = "small_net")
    public Float smallNet; // 净值因子
    @Column(name = "strategy_net")
    public Float strategyNet; // 净值因子
    @Column(name = "amount")
    public Float amount; // 股票市值
    @Column(name = "total_amount")
    public Float totalAmount; // 资产市值
    @Column(name = "update_time")
    public Date updatTime; // 更新时间
    @Column(name = "comment")
    public String comment; // 更新说明

}
