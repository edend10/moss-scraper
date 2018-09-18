package com.eden.d.moss.scraper.pagesource;

import com.eden.d.moss.scraper.title.PageSourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PageSourceClient {
    public String getWebPageSource(String sUrl) throws PageSourceException {
        try {
            URL url = new URL(sUrl);
            URLConnection urlCon = url.openConnection();
            BufferedReader in =  new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

            String inputLine;
            StringBuilder sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();

            return sb.toString();

        } catch (Exception e) {
            throw new PageSourceException(e);
        }
    }
}
