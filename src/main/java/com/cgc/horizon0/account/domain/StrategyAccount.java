package com.cgc.horizon0.account.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "strategy_account", schema = "invest")
public class StrategyAccount extends PanacheEntity {

    @Column(name = "account_id")
    public Integer accountId;
    @Column(name = "account_name")
    public String accountName;
    @Column(name = " strategy_status_cd")
    public String strategyStatusCd; // 策略部署状态, I(Initial), R(Running), S(Suspend), Pause(Pause)
    @Column(name = "amount")
    public Float amount; // 资产市值
    @Column(name = "pos_pct")
    public Float posPct; // 持仓比例
    @Column(name = "trade_rate")
    public Float tradeRade; // 资产市值

}
