
package com.cgc.horizon0.account.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "w10s_backtest", schema = "dys")
public class W10BackTest extends PanacheEntity {

    @Column(name = "job_id")
    public String jobId;

    @Column(name = "params", length=1024)
    public String params;

    @Column(name = "final_roi")
    public Float finalROI; 
    @Column(name = "annu_roi")
    public Float annuROI;
    @Column(name = "max_drawback")
    public Float maxDrawback;
    @Column(name = "max_roi")
    public Float maxROI;

    @Column(name = "update_time")
    public Date update_time;


}
