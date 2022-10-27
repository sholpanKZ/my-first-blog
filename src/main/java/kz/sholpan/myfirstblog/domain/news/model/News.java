package kz.sholpan.myfirstblog.domain.news.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String text;
    private Date createdAt;
    private String authorFullName;

    public News(Long id, String title, String text, Date createdAt, String authorFullName) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.authorFullName = authorFullName;
    }

    public News() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id.equals(news.id) && Objects.equals(title, news.title) && Objects.equals(text, news.text) && Objects.equals(createdAt, news.createdAt) && Objects.equals(authorFullName, news.authorFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, createdAt, authorFullName);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", authorFullName='" + authorFullName + '\'' +
                '}';
    }
}

