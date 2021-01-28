package com.ed_trade.ed_tradeserver_rest.logic;

import com.ed_trade.ed_tradeserver_rest.data.JSONFileUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SystemComparison {

//    private static JSONArray j1 = JSONFileUtil.JSONArrayFromFile("data/json/stations.json");
    private static JSONArray systems = JSONFileUtil.JSONArrayFromFile("data/json/systems_populated.json");

    public static double getLineDistanceSystems(String system1, String system2) {
        JSONObject syso1 = JSONFileUtil.findJSONObjectString(systems, "name", system1);
        double[] sysc1 = {
                (Double) syso1.get("x"),
                (Double) syso1.get("y"),
                (Double) syso1.get("z")
        };
        JSONObject syso2 = JSONFileUtil.findJSONObjectString(systems, "name", system2);
        double[] sysc2 = {
                (Double) syso2.get("x"),
                (Double) syso2.get("y"),
                (Double) syso2.get("z")
        };

        return getDistance3D(sysc1[0] - sysc2[0], sysc1[1] - sysc2[1], sysc1[2] - sysc2[2]);
    }

    private static double getDistance3D(double x, double y, double z) {
        return Math.sqrt(x*x + y*y + z*z);
    }


}
