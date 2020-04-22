package engine.entity;

public class Feedback {
    private boolean success;
    private String feedback;

    public Feedback(boolean isSuccess) {
        this.success = isSuccess;
        feedback = isSuccess ? "Congratulations, you're right!" : "Wrong answer! Please, try again.";
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }
}