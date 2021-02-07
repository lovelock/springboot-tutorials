package fun.happyhacker.springbootdemo.http;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

@Log4j2
public class InterceptorTest {
    public static void main(String[] args) throws IOException {
        InterceptorTest interceptorTest = new InterceptorTest();
        interceptorTest.get();
    }

    private void get() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new GetRequestInterceptor())
                .addInterceptor(new ResponseInterceptor())
                .build();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("local-docker")
                .port(80)
                .encodedPath("/get")
                .addEncodedQueryParameter("foo", "bar").build();

        Request request = new Request.Builder().url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("response {}", response.body().string());
        }
    }

    private void form() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new FormRequestInterceptor()).build();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("local-docker")
                .port(80)
                .encodedPath("/post")
                .build();

        RequestBody requestBody = new FormBody.Builder().addEncoded("foo", "bar").build();

        Request request = new Request.Builder().url(url)
                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("response {}", response.body().string());
        }
    }

    private void json() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new JsonRequestInterceptor()).build();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("local-docker")
                .port(80)
                .encodedPath("/post")
                .build();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(Map.of("foo", "bar")));

        Request request = new Request.Builder().url(url)
                .method("POST", requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("response {}", response.body().string());
        }
    }
}
