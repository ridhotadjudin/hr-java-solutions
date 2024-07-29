package com.hackerrank.rest_api_ip_tracker;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;


class Result {

    /*
     * Complete the 'ipTracker' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/ip?ip=<ip>
     *
     * The function is expected to return a STRING.
     * The function accepts a singe parameter ip.
     *
     * In case of no ip record, return string 'No Result Found'
     */

    public static String ipTracker(String ip) {
        try {
            String apiUrl = "https://jsonmock.hackerrank.com/api/ip?ip=" + ip;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String response = in.lines().collect(Collectors.joining());
                in.close();

                // Simple parsing of the JSON response
                if (response.contains("\"country\":")) {
                    int startIndex = response.indexOf("\"country\":") + 11;
                    int endIndex = response.indexOf("\"", startIndex);
                    String country = response.substring(startIndex, endIndex);
                    return country;
                } else {
                    return "No Result Found";
                }
            } else {
                return "No Result Found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "No Result Found";
        }
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String ip = bufferedReader.readLine();

        String result = Result.ipTracker(ip);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
