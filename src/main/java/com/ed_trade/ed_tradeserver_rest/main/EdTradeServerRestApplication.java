package com.ed_trade.ed_tradeserver_rest.main;

import com.ed_trade.ed_tradeserver_rest.data.JSONFinder;
import com.ed_trade.ed_tradeserver_rest.model.Faction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class EdTradeServerRestApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemp;

    public static void main(String[] args) {
        SpringApplication.run(EdTradeServerRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        JSONFinder.findByURL("https://eddb.io/archive/v6/stations.jsonl");
        System.out.println(System.getProperty("user.dir"));

        String sql = "SELECT * FROM TestDB.dbo.factions AS f WHERE f.allegiance='Alliance'";
        List<Faction> factions = jdbcTemp.query(sql, BeanPropertyRowMapper.newInstance(Faction.class));

        for (Faction f : factions) {
            System.out.println(f.getAllegiance());
        }
    }
}
