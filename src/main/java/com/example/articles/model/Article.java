package com.example.articles.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", nullable = false, unique = true)
    @Getter
    @Setter
    private Long id;

    @Column(name="uri", nullable = false)
    @Getter
    @Setter
    @NotNull
    private String uri;

    @Column(name="title", nullable = false)
    @Getter
    @Setter
    @NotNull
    private String title;

    @Column(name="published_date", nullable = false)
    @Getter
    @Setter
    @NotNull
    private Date published_date;

    @Column(name="section", nullable = false)
    @Getter
    @Setter
    @NotNull
    private String section;

    @Column(name="subsection")
    @Getter
    @Setter
    private String subsection;

    @Column(name="abstract")
    @Getter
    @Setter
    private String article_abstract;

    @Column(name="author")
    @NotNull
    @Getter
    @Setter
    private String author;
}
