package com.ed_trade.ed_tradeserver_rest.main;

import com.ed_trade.ed_tradeserver_rest.data.JSONFileUtil;
import com.ed_trade.ed_tradeserver_rest.main.entities.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;


/**
 * Class that handles preparation of data by downloading the respective files from the web and uploading/transforming it
 * to/for SQL. The setupAll function can be used to specify which pieces of data need to be refreshed to prevent
 * unnecessary re-downloading.
 *
 * @author Jeroen van der Horst
 */

public class Setup {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setupAll(boolean refreshJSON, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        createDataDirectories();
        if (refreshJSON) {
            getAllJSONData();
        }

        jsonToSQL("modules-json-to-sql-query");
        System.out.println(System.getProperty("user.dir"));

    }

    /**
     * Method that creates directories for the data files.
     *
     */
    private void createDataDirectories() {
        File[] toCreate = {
                new File("data/json"),
                new File("data/csv")
        };
        for (File file : toCreate) {
            if (file.mkdirs()) {
                System.out.println("Directory '" + file.getName() + "' created.");
            }
        }

    }


    /**
     * Method that gets all (currently needed) JSON data and stores it in files
     *
     * @author Jeroen van der Horst
     */

    private void getAllJSONData() {
        JSONFileUtil.getJSONByURL("https://eddb.io/archive/v6/stations.json", "stations");
        JSONFileUtil.getJSONByURL("https://eddb.io/archive/v6/systems_populated.json", "systems_populated");
        JSONFileUtil.getJSONByURL("https://eddb.io/archive/v6/commodities.json", "commodities");
        JSONFileUtil.getJSONByURL("https://eddb.io/archive/v6/modules.json", "modules");
    }


    /**
     * Method that takes an SQL script and executes it.
     *
     * @author Jeroen van der Horst
     */

    private void jsonToSQL(String script) {
        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(Objects.requireNonNull(classLoader.getResource(script)).getFile());

        try {
            String query = new String(Files.readAllBytes(file.toPath()));
            jdbcTemplate.execute(query);
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }




}
