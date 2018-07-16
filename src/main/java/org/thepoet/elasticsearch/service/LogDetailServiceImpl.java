package org.thepoet.elasticsearch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 13.05.2018
 */
@Service
public class LogDetailServiceImpl implements LogDetailService {

    @Value("${log.detail.url}")
    private String logDetailUrl;

    @Override
    public String generateLogDetail() {
        HttpURLConnection connection = null;
        try {
            connection = this.getHttpConnection();
            StringBuilder content = this.getResponse(connection);
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private HttpURLConnection getHttpConnection() throws IOException {
        URL url = new URL(logDetailUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        return connection;

    }

    private StringBuilder getResponse(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content;
    }
}