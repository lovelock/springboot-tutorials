package fun.happyhacker.springbootdemo.http;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log4j2
public class SimpleTest {
    private static final String URL = "http://local-docker:80";


    public static void main(String[] args) throws IOException {
        SimpleTest simpleTest = new SimpleTest();
        String getResult = simpleTest.get();

        log.info("get result {}", getResult);

        String postResult = simpleTest.post();
        log.info("post result {}", postResult);
    }

    private String get() throws IOException {

        final String URL_GET = URL + "/get";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_GET)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private String post() throws IOException {
        final String URL_POST = URL + "/post";
        OkHttpClient client = new OkHttpClient();
        Map<String, String> content = new HashMap<>();
        content.put("foo", "bar");
        content.put("hello", "world");
        RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), new Gson().toJson(content));
        Request request = new Request.Builder()
                .method("POST", requestBody)
                .url(URL_POST)
                .build();


        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
