package com.ed_trade.ed_tradeserver_rest.data;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Class that can be used to get JSON files from an API.
 *
 * @author Jeroen van der Horst
 */

public class JSONFileUtil {

    public static void getJSONByURL (String urlStr, String name) {
        try {
            URL url = new URL(urlStr);
            File file = new File("data/json/" + name + ".json");
            if (file.createNewFile()) {
                System.out.println("New file created: '" + name + ".json'");
            }
            else {
                System.out.println("Old file '" + name + "' overwritten.");
            }
            System.out.println("Downloading data for '" + name + "'...");
            InputStream is = new DataInputStream(url.openStream());
            OutputStream os = new FileOutputStream(file);

            byte[] buffer = new byte[8096];
            int bRead;

            while ((bRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bRead);
            }

            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONArray JSONArrayFromFile(String filepath) {
        JSONParser parser = new JSONParser();

        try {
            FileReader fileReader = new FileReader(filepath);

            return (JSONArray) parser.parse(fileReader);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject findJSONObjectString(JSONArray data, String key, String value) {
        for (Object o : data) {
            JSONObject json = (JSONObject) o;
            if (json.get(key).equals(value)) {
                return json;
            }
        }
        return null;
    }

    public static JSONObject findJSONObjectInt(JSONArray data, String key, int value) {
        for (Object o : data) {
            JSONObject json = (JSONObject) o;
            if (Integer.parseInt(json.get(key).toString()) == value) {
                return json;
            }
        }
        return null;
    }

}
