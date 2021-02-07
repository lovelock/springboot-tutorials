package fun.happyhacker.springbootdemo.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Log4j2
public class ResponseInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        String responseString = response.body().string();
        GetBody getBody = new ObjectMapper().readValue(responseString, GetBody.class);
        getBody.getArgs().put("hello", "world");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("original response {}", responseString);
        log.info("new response {}", gson.toJson(getBody));
        return response.newBuilder().body(ResponseBody.create(response.body().contentType(), gson.toJson(getBody)))
                .build();
    }
}

@Data
class GetBody {
    private Map<String, String> args;
    private Map<String, String> headers;
    private String origin;
    private String url;
}
