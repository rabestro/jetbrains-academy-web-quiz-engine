package engine.controller;

import engine.entity.Answer;
import engine.entity.Feedback;
import engine.entity.Quiz;
import engine.exceptions.QuizNotFoundException;
import engine.repository.QuizRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final Logger logger = LoggerFactory.getLogger(QuizController.class);

    private final QuizRepository db;

    @Autowired
    public QuizController(final QuizRepository db) {
        this.db = db;
    }

    @PostMapping
    public Quiz create(@Valid @RequestBody Quiz quiz) {
        return db.save(quiz);
    }

    @GetMapping("{id}")
    public Quiz getQuiz(@PathVariable Long id) throws QuizNotFoundException {
        return db.findById(id).orElseThrow(
                () -> new QuizNotFoundException("Quiz not found for id: " + id));
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return db.findAll();
    }

    @PostMapping(path = "/{id}/solve", consumes = "application/json")
    public Feedback checkAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        final var quiz = getQuiz(id);
        final var isCorrect = Arrays.equals(quiz.getAnswer(), answer.getAnswer())
                || quiz.getAnswer() == null && Arrays.equals(new int[] {}, answer.getAnswer());

        logger.trace("Solution is " + Arrays.toString(answer.getAnswer()));
        logger.trace("Correct is " + Arrays.toString(quiz.getAnswer()));

        return new Feedback(isCorrect);
    }
}
