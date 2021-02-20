package fr.gamedev.question;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamedev.question.data.UserAnswer;
import fr.gamedev.question.repository.AnswerRepository;
import fr.gamedev.question.repository.QuestionRepository;
import fr.gamedev.question.repository.UserAnswerRepository;
import fr.gamedev.question.repository.UserRepository;

/**
 * @author djer1
 *
 */
@RestController
public class ResponseController {

    /**  answerRepo.*/
    @Autowired
    private AnswerRepository answerRepo;

    /**  questionRepo.*/
    @Autowired
    private QuestionRepository questionRepo;

    /**  userRepo.*/
    @Autowired
    private UserRepository userRepo;

    /**  userAnswerRepo.*/
    @Autowired
    private UserAnswerRepository userAnswerRepo;

    /** Point pour une réponse valide.*/
    private static final Integer POINT = 10;

    /**  @questionId.
     * @param askedQuestionId Id of the question
     * @param answer user answer
     * @param userId Id of the user
     * @return display basic message */
    @GetMapping("/reponse")
    public String answer(@RequestParam final long askedQuestionId, @RequestParam final Boolean answer,
            @RequestParam final long userId) {

        //Optional<Question> question = questionRepo.findById(questionId);

        Optional<UserAnswer> answerData = userAnswerRepo.findById(askedQuestionId);

        Assert.isTrue(!answerData.isEmpty(), "Cette proposition de question n'existe pas");

        UserAnswer userAnswer = answerData.get();

        Assert.isTrue(userAnswer.getPoints() == null, "Réponse ignorée : vous avez déja répondu à cette question.");

        String response = "Oops ! Ca n'est pas correcte";
        userAnswer.setPoints(0);

        if (answer == userAnswer.getAnswer().getCorrectAnswer()) {

            Optional<UserAnswer> lastUserAnwswer = userAnswerRepo
                    .findTopByAnswerQuestionAndUserId(userAnswer.getAnswer().getQuestion(), userAnswer.getUser());

            response = "Bravo ! vous avez trouvé ! ";

            if (lastUserAnwswer.isPresent()) {
                Integer lastEarnedPoints = lastUserAnwswer.get().getPoints();
                userAnswer.setPoints(lastEarnedPoints / 2);
            } else {
                userAnswer.setPoints(POINT);
            }
        }

        userAnswerRepo.save(userAnswer);

        return response;
    }

}
