package com.ed_trade.ed_tradeserver_rest.main;

import com.ed_trade.ed_tradeserver_rest.logic.SystemComparison;
import com.ed_trade.ed_tradeserver_rest.beans.Listing;
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
        Setup.setupAll(false);
        System.out.println(SystemComparison.getLineDistanceSystems("Borr", "LHS 1240"));



        String sql = "SELECT * FROM EDDB.dbo.listings AS l WHERE l.station_id=4";
        List<Listing> listings = jdbcTemp.query(sql, BeanPropertyRowMapper.newInstance(Listing.class));

        for (Listing l : listings) {
            System.out.println(l.getCommodity_id());
        }
    }
}
