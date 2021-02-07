package fun.happyhacker.springbootdemo.http;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class GetRequestInterceptor implements Interceptor {
    private static final Map<String, String> AUTH_PARAMS = Map.of("a", "b", "c", "d", "e", "f");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();

        HttpUrl.Builder newUrlBuilder = url.newBuilder();
        AUTH_PARAMS.forEach(newUrlBuilder::addEncodedQueryParameter);

        Request newRequest = request.newBuilder().url(newUrlBuilder.build()).build();

        return chain.proceed(newRequest);
    }
}
