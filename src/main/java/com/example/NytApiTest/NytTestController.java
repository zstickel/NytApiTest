package com.example.NytApiTest;

import com.example.NytApiTest.Models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class NytTestController {
    @Autowired ArticleService articleService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("articleList", articleService.getMostPopular());
        return "index";
    }
    @PostMapping("/search")
    public String searchPost(Model model, @RequestParam String searchString){
       // model.addAttribute("searchedList", articleService.getSearched(searchString));
        System.out.println(searchString);
        model.addAttribute("articleList", articleService.getSearched(searchString));
        return "nytsearchresults";
    }
    @GetMapping("/search")
    public  String search(Model model){
        return "nytsearch";
    }
}
