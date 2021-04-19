package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(5000)
                    .setSocketTimeout(30000)
                    .setRedirectsEnabled(false)
                    .build())
                .build();

        HttpGet request = new HttpGet("https://cat-fact.herokuapp.com/facts");
        CloseableHttpResponse response = httpClient.execute(request);

        List<Post> posts = mapper.readValue(
                response.getEntity().getContent(), new TypeReference<>() {});

        posts.stream()
                .filter(p -> p.getId().equals("58e00a090aac31001185ed16"))
                .forEach(System.out::println);
    }
}
