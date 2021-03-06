package engine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import engine.exceptions.BadRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;

@Entity
@Table(name = "Quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "title is mandatory")
    private String title;

    @Column(name = "text", nullable = false)
    @NotBlank(message = "text is mandatory")
    private String text;

    @Column(name = "options", nullable = false)
    @NotNull
    @Size(min = 2)
    private String[] options;


    @Column
    private int[] answer;

    @Column(name = "owner")
    private String owner;

    public Quiz() {
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(final long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(final String[] options) {
        this.options = options;
    }


    @JsonIgnore
    public int[] getAnswer() {
        return answer;
    }

    @JsonProperty
    public void setAnswer(int[] answer) {
        if (answer.length >= options.length) {
            throw new BadRequest();
        }

        this.answer = answer;
        Arrays.sort(this.answer);
    }

    @JsonIgnore
    public String getOwner() {
        return owner;
    }

    @JsonIgnore
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
