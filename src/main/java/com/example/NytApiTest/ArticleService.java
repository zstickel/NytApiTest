package com.example.NytApiTest;

import com.example.NytApiTest.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;


    @Value("${searchUrl}")
    private String searchUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Documents> getSearched(String searchWord){
        String urlToGet = searchUrl + "q=" + searchWord + "&api-key=" + apikey;
        List<Documents> documents;
        SearchResponse searchResponse = restTemplate.getForObject(urlToGet, SearchResponse.class);
        if (searchResponse != null && searchResponse.getStatus().equals("OK")) {
            documents = searchResponse.getResponse().getDocs();
            return documents;

        } else {
            documents = new ArrayList<Documents>();
            return  documents;
        }
    }
    public List<Article> getMostPopular() {
        NytResponse response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        List<Article> results = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            results = response.getResults();

                 for (Article result : results) {
                         if (!result.getMedia().isEmpty()) {
                             result.setImageUrl(result.getMedia().get(0).getMediaMetadata().get(2).getUrl());
                         }
                 }

            return results;


        } else {
            return results;
        }
    }
    public String getTopArticleName() {
        NytResponse response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        List<Article> results = new ArrayList<>();
        String topArticle = "The top article is \"";
        if (response != null && response.getStatus().equals("OK")) {
            results =  response.getResults();
            topArticle += results.get(0).getTitle();
            topArticle += "\" from the the section ";
            topArticle += results.get(0).getSection();
            return  topArticle;
        } else {
            return "No Articles";
        }
    }
}
