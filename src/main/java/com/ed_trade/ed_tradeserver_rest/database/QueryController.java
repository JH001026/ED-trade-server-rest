package com.ed_trade.ed_tradeserver_rest.database;

import com.ed_trade.ed_tradeserver_rest.main.EdTradeServerRestApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class QueryController {
    private String sql;

    public QueryController(String sql) {
        this.sql = sql;
    }

    @Autowired
    private JdbcTemplate jdbcT;


    public boolean executePlainSQL() {
        jdbcT.execute(sql);
        return true;
    }


 }
