package pl.romanek.webprojekt.note.domain;

import java.util.Random;

public class NoteItem {

    private String id;
    private String title;
    private String description;

    public NoteItem() {

        Random generator = new Random();
        int rand = generator.nextInt(1000);
        int rand2 = generator.nextInt(10000);
        this.id = rand + rand2 + "";
        this.title = "EMPTY_TITLE";
        this.description = "EMPTY";

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
