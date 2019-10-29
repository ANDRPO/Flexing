package com.example.xtest.GettersAndSetters;

public class GAS_news {
    private int id;
    private String title;
    private String text;
    private String create_date;
    private String update_date;
    private int comments_count;
    private String image;
    private int likes;

    public GAS_news(int id, String title, String text, String create_date, String update_date, int comments_count, String image, int likes) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.create_date = create_date;
        this.update_date = update_date;
        this.comments_count = comments_count;
        this.image = image;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public int getComments_count() {
        return comments_count;
    }

    public String getImage() {
        return image;
    }

    public int getLikes() {
        return likes;
    }
}
