package fun.happyhacker.springbootdemo.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.util.Map;

@Log4j2
public class JsonRequestInterceptor implements Interceptor {
    private static final Map<String, String> AUTH_PARAMS = Map.of("a", "b", "c", "d", "e", "f");

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody body = request.body();
        ObjectNode objectNode;
        MediaType mediaType;
        if (body == null) {
            mediaType = MediaType.parse("application/json");
            objectNode = objectMapper.createObjectNode();
        } else {
            mediaType = body.contentType();
            objectNode = (ObjectNode) new ObjectMapper().readTree(bodyToString(body));
        }

        log.info("json node {}", objectNode.toPrettyString());

        for (Map.Entry<String, String> entry : AUTH_PARAMS.entrySet()) {
            objectNode.put(entry.getKey(), entry.getValue());
        }

        RequestBody newBody = RequestBody.create(mediaType, objectNode.toString());

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
}
