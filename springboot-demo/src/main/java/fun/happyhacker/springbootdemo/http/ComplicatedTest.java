package fun.happyhacker.springbootdemo.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Log4j2
public class ComplicatedTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Map<String, String> PARAMS = Map.of("key1", "this is a value", "key2", "300 300", "key3", "haha woo");

    public static void main(String[] args) throws IOException {
        ComplicatedTest complicatedTest = new ComplicatedTest();
//        String s = complicatedTest.get();
//        log.info("response: {}", s);

//        String form = complicatedTest.form();
//        log.info("form response {}", form);

//        String json = complicatedTest.json();
//        log.info("json response {}", json);

        String json = new Gson().toJson(PARAMS);
        log.info("json {}", json);
    }

    private String get() throws IOException {
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.scheme("http")
                .host("local-docker")
                .port(80)
                .encodedPath("/get");
        PARAMS.forEach((key, value) -> builder.addEncodedQueryParameter(URLEncoder.encode(key, StandardCharsets.UTF_8), URLEncoder.encode(value, StandardCharsets.UTF_8)));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(builder.build()).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private String form() throws IOException {
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.scheme("http")
                .host("local-docker")
                .port(80)
                .encodedPath("/post");
//        MediaType contentType = MediaType.get("application/x-www-form-urlencoded");

        FormBody.Builder formBuilder = new FormBody.Builder();
        PARAMS.forEach(formBuilder::addEncoded);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(builder.build())
                .method("POST", formBuilder.build())
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private String json() throws IOException {
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.scheme("http")
                .host("local-docker")
                .port(80)
                .encodedPath("/post");
        MediaType contentType = MediaType.parse("application/json");

        String json = new Gson().toJson(PARAMS);

        RequestBody requestBody = RequestBody.create(contentType, json);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(builder.build())
                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
