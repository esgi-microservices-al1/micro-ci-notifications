package com.esgi.rabbitmq.api;

import com.esgi.rabbitmq.models.Message;
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ApiRequestService {
    @Value("${api.url}")
    private String apiUrl;

    public void sendMessage(Message message){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost post = new HttpPost(apiUrl);

            Gson gson = new Gson();
            String body = gson.toJson(message);
            post.addHeader("content-type", "application/json");
            post.setEntity(new StringEntity(body));
            CloseableHttpResponse response = httpClient.execute(post);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
