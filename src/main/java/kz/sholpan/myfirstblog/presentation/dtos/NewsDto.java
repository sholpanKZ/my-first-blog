package kz.sholpan.myfirstblog.presentation.dtos;

import java.io.Serializable;

public class NewsDto implements Serializable {

    private String title;
    private String text;
    private String authorFullName;

    public NewsDto(String title, String text, String authorFullName) {
        this.title = title;
        this.text = text;
        this.authorFullName = authorFullName;
    }

    public NewsDto() {

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

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

}
