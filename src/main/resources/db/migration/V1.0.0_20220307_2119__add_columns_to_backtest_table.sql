ALTER TABLE dys.s8s_backtest ADD column start_date date;
ALTER TABLE dys.s8s_backtest ADD column end_date date;
ALTER TABLE dys.s8s_backtest ADD column sc_params VARCHAR;
ALTER TABLE dys.s8s_backtest ADD column rf_params VARCHAR;
ALTER TABLE dys.s8s_backtest ADD column tm_params VARCHAR;

ALTER TABLE dys.w10s_backtest ADD column start_date date;
ALTER TABLE dys.w10s_backtest ADD column end_date date;
ALTER TABLE dys.w10s_backtest ADD column sc_params VARCHAR;
ALTER TABLE dys.w10s_backtest ADD column rf_params VARCHAR;
ALTER TABLE dys.w10s_backtest ADD column tm_params VARCHAR;
