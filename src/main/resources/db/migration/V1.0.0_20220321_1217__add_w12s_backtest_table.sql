CREATE TABLE IF NOT EXISTS dys.w12s_backtest (
    id bigint not null,
    job_id varchar(255),
    start_date date,
    end_date date,
    final_roi float,
    annu_roi float,
    max_drawback float,
    max_roi float,
    sc_params varchar(340),
    rf_params varchar(340),
    tm_params varchar(340),
    params varchar(1024),
    update_time timestamp,
    primary key (id)
);

CREATE SEQUENCE IF NOT EXISTS dys.w12s_backtest_id_seq START WITH 1 INCREMENT BY 1;
