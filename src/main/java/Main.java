import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        var gson = new Gson();
        Cat[] cats;

        var allCats = retrieveCatsData();

        cats = gson.fromJson(allCats, Cat[].class);

        List<Cat> catsWithVotes = Arrays.stream(cats).filter(cat -> cat.getUpvotes() > 0)
                .toList();

        var gsonPP = new GsonBuilder().setPrettyPrinting().create();

        String s = gsonPP.toJson(catsWithVotes);

        System.out.println(s);

/*
        var url = new URL("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
        var urlConnection = url.openConnection();

        var stringInput = new String(urlConnection.getInputStream().readAllBytes());
        System.out.println(stringInput);
*/

/*
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        var request = HttpRequest.newBuilder(URI.create("https://raw.githubusercontent
        .com/netology-code/jd-homeworks/master/http/task1/cats"))
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println(response.headers());
*/
    }

    static String retrieveCatsData() throws IOException {

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet("https://raw.githubusercontent.com/" +
                "netology-code/jd-homeworks/master/http/task1/cats");

        CloseableHttpResponse response = httpClient.execute(request);

        return (new String(response.getEntity().getContent().readAllBytes()));

/*
        CloseableHttpClient client = HttpClients.custom()
                .setSSLSocketFactory(new SSLConnectionSocketFactory(
                        SSLContexts.createSystemDefault(),
                        new String[] { "TLSv1.2" },
                        null,
                        SSLConnectionSocketFactory.getDefaultHostnameVerifier()))
                .setConnectionTimeToLive(1, TimeUnit.MINUTES)
                .setDefaultSocketConfig(SocketConfig.custom()
                        .setSoTimeout(5000)
                        .build())
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(5000)
                        .setCookieSpec(CookieSpecs.STANDARD_STRICT)
                        .build())
                .build();    }
*/

    }
}
