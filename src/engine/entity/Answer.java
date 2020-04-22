package engine.entity;

import java.util.Arrays;

public class Answer {
    private int[] answer;

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(final int[] answer) {
        this.answer = answer;
        Arrays.sort(this.answer);
    }
}
