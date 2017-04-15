package ru.digdes.steammarketparser.service.impl;

import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.service.HttpService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * TODO javadoc
 */
@Service
public class HttpServiceImpl implements HttpService {
    @Override
    public String getUrl(String link) {
        try {
            URL url = new URL(link);
            try (InputStream is = url.openStream()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
