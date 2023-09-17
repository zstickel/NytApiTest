package com.example.NytApiTest;

import com.example.NytApiTest.Models.Article;
import com.example.NytApiTest.Models.Documents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NytRestController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/nyt/test")
    public List<Article> getMostPopular(){
        return articleService.getMostPopular();
    }
    @GetMapping("/nyt/topname")
    public String getMostPopularName(){
        return articleService.getTopArticleName();
    }

    @GetMapping("/nyt/testsearch")
    public List<Documents> getSearched() { return articleService.getSearched("Ohio");}
}
