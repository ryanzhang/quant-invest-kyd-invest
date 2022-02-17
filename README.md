# kyd-invest
用于更新 market->invest(schema|下面的table schem

# 量化策略投资账号表 invest.strategy_account
|名称|类型|描述|
|---	|---	|---	|
|account_id|Integer| 投资账户id，并不等同于券商的账户，而是使用该策略的资金id
|account_name|String| 策略投资账号名称
|stragegy_status_cd|String| 策略部署状态, I(Initial)初始化, R(Running)运行, S(Suspend)停用, Pause(Pause)暂停
|total_amount|Float|  总资产市值
|trade_rate|Float|  交易费率
|posPct|Float|  持仓比例


# 大小盘指数轮动策略表 invest.big_small_etf_rotate
|名称|类型|描述|
|---	|---	|---	|
|account_id|Integer| 投资账户id，并不等同于券商的账户，而是使用该策略的资金id
|trade_date|Date|交易日期|
|stragegy_status_cd|String| 策略部署状态,  R(Running)运行, S(Suspend)停用, Pause(Pause)暂停
|ticker_x|String| 大盘轮动etf基金代码|
|sec_short_name_x|String| 大盘轮动etf基金名称|
|pre_close_price_x|Float|
|open_price_x|Float|
|close_price_x|Float|
|chg_x|Float|
|chg_pct_x|Float|
|ticker_y|String|小盘轮动etf基金代码|
|sec_short_name_y|String| 小盘轮动etf基金名称|
|pre_close_price_y|Float|
|open_price_y|Float|
|close_price_y|Float|
|chg_y|Float|
|chg_pct_y|Float|
|big_mom|Float|大盘动量因子
|small_mom|Float|小盘动量因子
|style|String|大小盘风格 | 
|pos|String| 策略计算持仓风格
|trade_cd|Integer| 当日的交易指令 0 不交易 1 买入 2卖出 3换仓
|next_trade_cd|Integer| 下一个交易日的操作指令
|strategy_chg_pct|Float|  扣除手续费后的涨幅
|big_net|Float|  大盘ETF净值因子
|small_net|Float| 小盘净值因子
|vol|Float|  交易多少股 （必须是100的倍数)
|amount|Float|  股票资产市值
|trade_fee|Float|  扣除手续费后的涨幅
|total_amount|Float|  总资产市值
|strategy_chg_pct_real|Float|  扣除手续费后的涨幅
|strategy_net_real|Float|  净值因子
|update_time|DateTime|   更新时间
|comment|String|   更新说明
