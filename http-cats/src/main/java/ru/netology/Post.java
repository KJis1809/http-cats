package ru.netology;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    private final String id;
    private final String user;
    private final String text;

    public Post(
            @JsonProperty("_id") String id,
            @JsonProperty("user") String user,
            @JsonProperty("text") String text
    ) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Post" +
                "\n id = " + id +
                "\n user = " + user +
                "\n text = " + text;
    }
}
