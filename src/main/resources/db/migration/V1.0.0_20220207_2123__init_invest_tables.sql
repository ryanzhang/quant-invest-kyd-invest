CREATE SCHEMA IF NOT EXISTS invest;
CREATE TABLE IF NOT EXISTS invest.strategy_account (
    id bigint not null,
    account_id integer,
    account_name varchar(255),
    strategy_status_cd varchar(2),
    amount float,
    trade_rate float,
    pos_pct float,
    primary key (id)
);
CREATE TABLE IF NOT EXISTS invest.big_small_etf_rotate (
    id BIGINT NOT NULL,
    account_id INTEGER,
    account_name VARCHAR(64),
    trade_date DATE,
    strategy_status_cd VARCHAR(2),
    ticker_x VARCHAR(255),
    sec_short_name_x varchar(255),
    pre_close_price_x FLOAT,
    open_price_x FLOAT,
    close_price_x FLOAT,
    chg_x FLOAT,
    chg_pct_x FLOAT,
    ticker_y VARCHAR(255),
    sec_short_name_y varchar(255),
    pre_close_price_y FLOAT,
    open_price_y FLOAT,
    close_price_y FLOAT,
    chg_y FLOAT,
    chg_pct_y FLOAT,
    big_mom FLOAT,
    small_mom FLOAT,
    style VARCHAR(255),
    pos VARCHAR(255),
    trade_cd INTEGER,
    next_trade_cd INTEGER,
    strategy_chg_pct FLOAT,
    big_net FLOAT,
    small_net FLOAT,
    strategy_net FLOAT,
    vol FLOAT,
    amount FLOAT,
    trade_fee FLOAT,
    total_amount FLOAT,
    strategy_chg_pct_real FLOAT,
    strategy_net_real FLOAT,
    update_time TIMESTAMP,
    comment VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE SEQUENCE IF NOT EXISTS invest.strategy_account_id_seq START WITH 1 INCREMENT BY 1;
CREATE UNIQUE INDEX IF NOT EXISTS strategy_account_idx ON invest.strategy_account(account_id );
CREATE SEQUENCE IF NOT EXISTS invest.big_small_etf_rotate_id_seq START WITH 1 INCREMENT BY 1;
CREATE UNIQUE INDEX IF NOT EXISTS big_small_etf_rotate_idx ON invest.big_small_etf_rotate(account_id, trade_date);

INSERT INTO invest.strategy_account (id, account_id, account_name, strategy_status_cd,  amount, pos_pct) VALUES(nextval('big_small_etf_rotate_id_seq'), 1, '大小盘轮动虚拟账户',  'I', 100000, 1 );
