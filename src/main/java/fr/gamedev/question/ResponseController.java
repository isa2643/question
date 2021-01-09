package fr.gamedev.question;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamedev.question.data.Answer;
import fr.gamedev.question.data.Question;
import fr.gamedev.question.data.User;
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

    /**  @questionId.
     * @param questionId Id of the question
     * @param answer user answer
     * @param userId Id of the user
     * @return display basic message */
    @GetMapping("/reponse")
    public String answer(@RequestParam final long questionId, @RequestParam final Boolean answer,
            @RequestParam final long userId) {

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setPoints(0);

        Optional<Question> question = questionRepo.findById(questionId);
        Optional<Answer> answerData;
        String response = "Oops ! Ca n'est pas correcte";
        boolean isOk = true;

        if (!question.isEmpty()) {

            answerData = answerRepo.findByQuestion(question.get());
            if (!answerData.isEmpty()) {

                if (answer == answerData.get().getCorrectAnswer()) {

                    userAnswer.setAnswer(answerData.get());

                    response = "Bravo ! vous avez trouvé ! ";
                    userAnswer.setPoints(10);
                }
            } else {
                //TODO grp3 by DJE : Algo : votre code serait plus claire en intialisant "isOk" à false et le papssant a OK uniquement lorsque c'est OK.
                isOk = false;
            }
        } else {
            isOk = false;
        }

        //TODO grp3 by DJE : Algo :pourrait être fait ou tout début, si pas de User, pas de code a éxécuter (sauf pour tracer l'erreur)
        Optional<User> user = userRepo.findById(userId);

        if (!user.isEmpty()) {
            userAnswer.setUser(user.get());
        } else {
            isOk = false;
        }

        if (isOk) {
            userAnswerRepo.save(userAnswer);
        }
        return response;
    }

}
