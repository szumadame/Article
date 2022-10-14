package com.example.articles.controller;

import com.example.articles.service.ArticleService;
import com.example.articles.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;
    @Autowired
    ArticleService articleService;

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

    @GetMapping("/email/{articleId}/{userEmail}")
    public @ResponseBody ResponseEntity sendEmail(@PathVariable Long articleId, @PathVariable String userEmail) {
        String uri = articleService.getArticleUriById(articleId);
        String title = articleService.getArticleTitleById(articleId);
        String message = "Enjoy your article, here is the title and uri " + "\n" + title + "\n" + uri;
        if (uri != null) {
            try {
                emailService.sendMail(message, userEmail);
            } catch (MailException mailException) {
                LOG.error("Error while sending out email..{}", mailException.getStackTrace());
                return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("There is no article to be sent", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Check your email", HttpStatus.OK);
    }
}
