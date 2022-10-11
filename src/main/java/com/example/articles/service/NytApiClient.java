package com.example.articles.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

//@NoArgsConstructor
public class NytApiClient {

    private static RestTemplate restTemplate = new RestTemplate();
    private static JSONObject jsonObject;
    private static JSONArray jsonArray;

    public JSONArray getArticlesTable() throws JSONException {

        String yourKey = "47sRHjANoPNZ5lu1szOvlgjn4GeGzxI9";
        String Url = "https://api.nytimes.com/svc/mostpopular/v2/shared/1/facebook.json?api-key=" + yourKey;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<Map> articleList = restTemplate.exchange(Url, HttpMethod.GET, entity, Map.class);

        if (articleList.getStatusCode() == HttpStatus.OK) {
            jsonObject = new JSONObject(articleList.getBody());
            jsonArray = jsonObject.getJSONArray("results");
        }
        return jsonArray;
    }

}
