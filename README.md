# kyd-invest
用于更新 market->invest(schema|下面的table schema
# 大小盘指数轮动策略表 invest.big_small_etf_rotate
|名称|类型|描述|
|---	|---	|---	|
|trade_date|Date|交易日期|
|account_id|Integer| 投资账户id，并不等同于券商的账户，而是使用该策略的资金id
|is_suspend|Integer| 策略是否暂停实施
|is_skip_trade|Integer| 是否跳过量化交易
|ticker_x|String(16| 大盘轮动etf基金代码|
|pre_close_price_x|Float|
|open_price_x|Float|
|close_price_x|Float|
|chg_x|Float|
|chg_pct_x|Float|
|ticker_y|String(16|小盘轮动etf基金代码|
|pre_close_price_y|Float|
|open_price_y|Float|
|close_price_y|Float|
|chg_x|Float|
|chg_pct_y|Float|
|big_mom|Float|大盘动量因子
|small_mom|Float|小盘动量因子
|style|String|大小盘风格 | 
|pos|String| 策略计算持仓风格
|pos_chg_pct|Float|  扣除手续费后的涨幅
|trade_fee|Float|  扣除手续费后的涨幅
|big_net|Float|  大盘ETF净值因子
|small_net|Float| 小盘净值因子
|strategy_net|Float|  净值因子
|amount|Float|  资产市值
|update_time|DateTime|   更新时间
|comment|String|   更新说明
