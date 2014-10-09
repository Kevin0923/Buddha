package kevin.buddha.helper.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {
    private final static String charsetName = "UTF-8";

    public static String doPost(String url, String value) throws MalformedURLException, IOException {
        HttpURLConnection urlconn = null;
        BufferedReader rd = null;
        try {
            urlconn = (HttpURLConnection) new URL(url).openConnection();
            urlconn.getRequestProperties();
            urlconn.setRequestProperty("content-type", "application/json");
            urlconn.setRequestMethod("POST");
            urlconn.setConnectTimeout(10000);
            urlconn.setReadTimeout(10000);
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.getOutputStream().write(value.getBytes(charsetName));
            urlconn.getOutputStream().close();

            rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), charsetName));

            String temp = null;
            StringBuffer sb = new StringBuffer();
            temp = rd.readLine();
            while (temp != null) {
                sb.append(temp);
                temp = rd.readLine();
            }
            return sb.toString();
        } finally {
            if (rd != null) {
                rd.close();
            }
            if (urlconn != null) {
                urlconn.disconnect();
            }
        }
    }
}
