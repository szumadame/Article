package com.example.articles.service;

import com.example.articles.model.Article;
import com.example.articles.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    public NytApiClient nytApiClient;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public void saveArticles() throws JSONException, ParseException {
        JSONArray jsonArray = nytApiClient.getArticlesTable();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < jsonArray.length(); i++) {
            Article article = new Article();
            article.setId((long) (i + 1));
            article.setUri(jsonArray.getJSONObject(i).get("url").toString());
            article.setTitle(jsonArray.getJSONObject(i).get("title").toString());
            Date dateInString = formatter.parse(String.valueOf(jsonArray.getJSONObject(i).get("publishedAt")));
            article.setPublished_date(dateInString);
            article.setArticle_abstract(jsonArray.getJSONObject(i).get("description").toString());
            article.setAuthor(jsonArray.getJSONObject(i).get("author").toString());
            articleRepository.save(article);
        }
    }

    public Optional<Article> getArticleById(Long article_id) {
        return articleRepository.findById(article_id);
    }

    public List<String> getArticleTitlesTable() {
        List<String> titleList = new ArrayList<>();
        List<Article> articles = articleRepository.findAll();
        if (!articles.isEmpty()) {
            articles.stream()
                    .forEach(e -> {
                        titleList.add(e.getTitle());
                    });
            return titleList;
        }
        return titleList;
    }

    public String getArticleUriById(Long id) {
        return articleRepository.findById(id).get().getUri();
    }

    public String getArticleTitleById(Long id) {
        return articleRepository.findById(id).get().getTitle();
    }
}
