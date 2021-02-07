package fun.happyhacker.springbootdemo.http;

import okhttp3.*;

import java.io.IOException;

public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        RequestBody requestBody = request.body();
        Headers headers = request.headers();
        // do what you want with the request

        return chain.proceed(request);
    }
}
