
package com.cgc.horizon0.account.domain;

import java.text.DecimalFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jboss.logging.Logger;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "w12s_backtest", schema = "dys")
public class W12BackTest extends PanacheEntity {

    @Column(name = "job_id")
    public String jobId;

    @Column(name = "start_date") @Temporal(TemporalType.DATE)
    public Date startDate;

    @Column(name = "end_date") @Temporal(TemporalType.DATE)
    public Date endDate;

    @Column(name = "final_roi")
    public Float finalROI; 
    @Column(name = "annu_roi")
    public Float annuROI;
    @Column(name = "max_drawback")
    public Float maxDrawback;
    @Column(name = "max_roi")
    public Float maxROI;

    @Column(name = "sc_params", length=1024)
    public String scParams;
    @Column(name = "rf_params", length=1024)
    public String rfParams;
    @Column(name = "tm_params", length=1024)
    public String tmParams;
    @Column(name = "params", length=3096)
    public String params;

    @Column(name = "update_time")
    public Date update_time;

    public String getAnnuROI(){

        String x= annuROI.toString();
        int n=x.indexOf('.');
        return x.substring(0, n+3);
    }
    public String getMaxDrawback(){
        String x= maxDrawback.toString();
        int n=x.indexOf('.');
        return x.substring(0, n+3);
    }
    public String getFinalROI(){
        String x= finalROI.toString();
        int n=x.indexOf('.');
        return x.substring(0, n+3);
    }
    public String getMaxROI(){
        String x= maxROI.toString();
        int n=x.indexOf('.');
        return x.substring(0, n+3);
    }
}
