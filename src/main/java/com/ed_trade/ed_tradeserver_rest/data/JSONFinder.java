package com.ed_trade.ed_tradeserver_rest.data;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class that can be used to get JSON files from an API.
 *
 * @author Jeroen van der Horst
 * @Date 1/27/2021 14:08
 */
public class JSONFinder {

//    public static void findByURL(String urlStr) {
//        try {
//            URL url = new URL(urlStr);
//            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//            String str = "";
//            while (null != (str = br.readLine())) {
//                System.out.println(str);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }

    public static void findByURL(String urlStr) {
        try {
            URL url = new URL(urlStr);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(url.openConnection().getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
