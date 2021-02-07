package fun.happyhacker.springbootdemo.http;

import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Log4j2
public class FormRequestInterceptor implements Interceptor {
    private static final Map<String, String> AUTH_PARAMS = Map.of("a", "b", "c", "d", "e", "f");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody body = request.body();
        String bodyString = bodyToString(body);
        String newBodyString;
        if (bodyString.length() == 0) {
            newBodyString = "?";
        } else {
            newBodyString = bodyString + "&";
        }
        newBodyString += buildQuery();
        RequestBody newBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), newBodyString);
        Request newRequest = request.newBuilder().post(newBody).build();

        return chain.proceed(newRequest);
    }

    private String bodyToString(RequestBody body) {
        final Buffer buffer = new okio.Buffer();
        if (body != null) {
            try {
                body.writeTo(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return buffer.readUtf8();
    }

    private String buildQuery() {
        StringBuilder builder = new StringBuilder();
        AUTH_PARAMS.forEach((key, value) -> {
            builder.append(URLEncoder.encode(key, StandardCharsets.UTF_8))
                    .append("=")
                    .append(URLEncoder.encode(value, StandardCharsets.UTF_8))
                    .append("&");
        });

        return builder.substring(0, builder.length()-1);
    }
}
