package com.ed_trade.ed_tradeserver_rest.main.entities;

import com.ed_trade.ed_tradeserver_rest.main.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {

    @Query(value = "Select * FROM EDDB.dbo.listings WHERE listings.id = ?1", nativeQuery = true)
    List<Listing> findListingsWithId(Integer id);
}
