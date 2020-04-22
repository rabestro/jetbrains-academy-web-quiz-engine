package engine.entity;

public class QuizAnswer extends Quiz {
    private int[] answer;

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(final int[] answer) {
        this.answer = answer;
    }
}
