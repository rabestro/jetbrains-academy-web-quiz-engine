package engine.repository;

import engine.entity.Quiz;
import engine.entity.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public interface QuizRepository extends JpaRepository<Quiz, Long> {
}


/*
@Component
public class QuizRepository {
    private static Long PRODUCT_ID_SEQUENCE = 0L;
    private final Map<Long, QuizAnswer> db = new HashMap<>();

    public QuizAnswer insert(QuizAnswer quiz) {
        quiz.setId(++PRODUCT_ID_SEQUENCE);
        db.put(PRODUCT_ID_SEQUENCE, quiz);
        return quiz;
    }

    public QuizAnswer get(Long id) {
        return db.get(id);
    }

    public Collection<QuizAnswer> getAll() {
        return db.values();
    }
}
*/
