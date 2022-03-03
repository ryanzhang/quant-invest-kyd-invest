CREATE SCHEMA IF NOT EXISTS dys;

CREATE TABLE IF NOT EXISTS dys.s8s_backtest (
    id bigint not null,
    job_id varchar(64),
    final_roi float,
    annu_roi float,
    max_drawback float,
    max_roi float,
    params varchar(1024),
    update_time timestamp,
    primary key (id)
);

CREATE SEQUENCE IF NOT EXISTS dys.s8s_backtest_id_seq START WITH 1 INCREMENT BY 1;
