package com.ed_trade.ed_tradeserver_rest.main;

import com.ed_trade.ed_tradeserver_rest.main.entities.Listing;
import com.ed_trade.ed_tradeserver_rest.main.entities.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
//(scanBasePackages = {"com.ed_trade.ed_tradeserver_rest.main.entities", "com.ed_trade.ed_tradeserver_rest.main"})
@SpringBootApplication
public class EdTradeServerRestApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ListingRepository listingRepo;

    public static void main(String[] args) {
        SpringApplication.run(EdTradeServerRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new Setup().setupAll(false, jdbcTemplate);
        //ToDo put the JSON into the SQL at setup, query needs to be separate from repositories

//        //Standard function
//        List<Listing> listings = listingRepo.findAll();
//        listings.forEach(System.out :: println);

        //Custom function
        List<Listing> l = listingRepo.findListingsWithId(155);
        System.out.println(l.get(0).getBuy_price());




//        String sql = "SELECT * FROM EDDB.dbo.listings AS l WHERE l.station_id=4";
//        List<Listing> listings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Listing.class));
//
//        for (Listing l : listings) {
//            System.out.println(l.getCommodity_id());
//        }
    }


}
