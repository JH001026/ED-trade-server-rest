package com.ed_trade.ed_tradeserver_rest.main;

import com.ed_trade.ed_tradeserver_rest.data.JSONFileUtil;

import java.io.File;


/**
 * Class that handles preparation of data by downloading the respective files from the web. The setupAll function can
 * be used to specify which pieces of data need to be refreshed to prevent unnecessary re-downloading.
 *
 * @author Jeroen van der Horst
 */

public class Setup {

    public static void setupAll(boolean refreshJSON) {
        createDataDirectories();
        if (refreshJSON) {
            getAllJSONData();
        }
    }

    private static void createDataDirectories() {
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
     * Gets all (currently needed) JSON data
     */

    private static void getAllJSONData() {
        JSONFileUtil.getJSONByURL("https://eddb.io/archive/v6/stations.json", "stations");
        JSONFileUtil.getJSONByURL("https://eddb.io/archive/v6/systems_populated.json", "systems_populated");
        JSONFileUtil.getJSONByURL("https://eddb.io/archive/v6/commodities.json", "commodities");
        JSONFileUtil.getJSONByURL("https://eddb.io/archive/v6/modules.json", "modules");
    }

}
