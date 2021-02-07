package fun.happyhacker.springbootdemo.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log4j2
public class SimpleTest {
    private static final String URL = "http://local-docker:80";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        SimpleTest simpleTest = new SimpleTest();

//        String getResult = simpleTest.get();
//        log.info("get result {}", getResult);
//
//        String postResult = simpleTest.post();
//        log.info("post result {}", postResult);

//        SlideShowBody slideShow = simpleTest.json();
//        log.info("json result {}", slideShow);

        String response = "{\n" +
                "    \"a_user\": {\n" +
                "        \"category1\": {\n" +
                "            \"credibility\": 20,\n" +
                "            \"features\": {\n" +
                "                \"feature1\": 10,\n" +
                "                \"feature2\": 20,\n" +
                "                \"feature3\": 30\n" +
                "            }\n" +
                "        },\n" +
                "        \"category3\": {\n" +
                "            \"credibility\": 40,\n" +
                "            \"features\": {\n" +
                "                \"feature5\": 10,\n" +
                "                \"feature6\": 20,\n" +
                "                \"feature7\": 30\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"b_user\": {\n" +
                "        \"category6\": {\n" +
                "            \"credibility\": 20,\n" +
                "            \"features\": {\n" +
                "                \"feature3\": 10,\n" +
                "                \"feature4\": 20,\n" +
                "                \"feature5\": 30\n" +
                "            }\n" +
                "        },\n" +
                "        \"category7\": {\n" +
                "            \"credibility\": 40,\n" +
                "            \"features\": {\n" +
                "                \"feature4\": 10,\n" +
                "                \"feature5\": 20,\n" +
                "                \"feature6\": 30\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";


        Map<String, Map<String, Category>> categoryMap  = objectMapper.readValue(response, new TypeReference<>() {
        });
        log.info("category map {}", categoryMap);
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

    private @Nullable
    SlideShowBody json() throws IOException {
        final String URL_JSON = URL + "/json";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(URL_JSON).build();
        SlideShowBody result;
        try (Response response = client.newCall(request).execute()) {
            result = objectMapper.readValue(response.body().string(), SlideShowBody.class);
            return result;
        }
    }

}
