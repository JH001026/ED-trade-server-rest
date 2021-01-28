package com.ed_trade.ed_tradeserver_rest.main;

import com.ed_trade.ed_tradeserver_rest.data.JSONFileUtil;
import com.ed_trade.ed_tradeserver_rest.logic.SystemComparison;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EdTradeServerRestApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemp;

    public static void main(String[] args) {
        SpringApplication.run(EdTradeServerRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Setup.setupAll(false);
        System.out.println(SystemComparison.getLineDistanceSystems("Borr", "LHS 1240"));



//        String sql = "SELECT * FROM EDDB.dbo.listings AS f WHERE f.allegiance='Alliance'";
//        List<Faction> factions = jdbcTemp.query(sql, BeanPropertyRowMapper.newInstance(Faction.class));
//
//        for (Faction f : factions) {
//            System.out.println(f.getAllegiance());
//        }
    }
}
