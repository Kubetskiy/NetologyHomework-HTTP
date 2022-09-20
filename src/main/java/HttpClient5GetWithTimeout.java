
import java.io.IOException;

/**
 * @author https://www.wdbyte.com
 */
public class HttpClient5GetWithTimeout {

/*
    public static void main(String[] args) {
        String result = get("http://httpbin.org/get");
        System.out.println(result);
    }

    public static String get(String url) {
        String resultContent = null;
        // Set timeout time
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(Timeout.ofMilliseconds(5000L))
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(5000L))
                .setResponseTimeout(Timeout.ofMilliseconds(5000L))
                .build();
        // Request level timeout
        HttpGet httpGet = new HttpGet(url);
        //httpGet.setConfig(config);
        //try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
        // Client-level timeouts
        try (CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(config).build()) {
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {

                System.out.println(response.getVersion()); // HTTP/1.1
                System.out.println(response.getCode()); // 200
                System.out.println(response.getReasonPhrase()); // OK
                HttpEntity entity = response.getEntity();

                resultContent = EntityUtils.toString(entity);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return resultContent;
    }
*/

}
