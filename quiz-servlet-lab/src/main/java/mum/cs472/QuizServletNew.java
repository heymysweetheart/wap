package mum.cs472;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizServletNew extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    QuizNew quiz = new QuizNew(0, 0);
    req.getSession().setAttribute("quiz", quiz);
    req.getSession().setAttribute("index", 0);
    req.getSession().setAttribute("question", quiz.getQuestion());
    req.getSession().setAttribute("result", 0);
    req.getSession().setAttribute("currentAttempt", 0);
    RequestDispatcher dispatcher = req.getRequestDispatcher("/quiznew.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    QuizNew quiz = (QuizNew) req.getSession().getAttribute("quiz");
    String answer = req.getParameter("answer");
    if(isCorrectAnswer(answer, quiz)) {
      req.getSession().setAttribute("correctAnswer", "");
      quiz.setScore(quiz.getScore() + quiz.getNewScore(quiz));
      quiz.setCurrentAttempt(0);
      int currentIndex = quiz.getCurrentIndex();
      if(currentIndex < 4) {//Go on with the test
        quiz.setCurrentAttempt(0);
        quiz.setCurrentIndex(currentIndex + 1);
        req.getSession().setAttribute("currentAttempt", 0);
        req.getSession().setAttribute("quiz", quiz);
        req.getSession().setAttribute("result", quiz.getScore());
        req.getSession().setAttribute("question", quiz.getQuestion());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/quiznew.jsp");
        requestDispatcher.forward(req, resp);
      } else {//Turn to another page to show the result
        req.getSession().invalidate();
        req.setAttribute("result", getFinalGrade(quiz.getScore()));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/resultnew.jsp");
        requestDispatcher.forward(req, resp);
      }
    } else {
      if(isValidStatus(quiz)) {
        quiz.setCurrentAttempt(quiz.getCurrentAttempt() + 1);
        req.getSession().setAttribute("currentAttempt", quiz.getCurrentAttempt());
        req.getSession().setAttribute("quiz", quiz);
        req.getSession().setAttribute("result", quiz.getScore());
        req.getSession().setAttribute("question", quiz.getQuestion());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/quiznew.jsp");
        requestDispatcher.forward(req, resp);
      } else { //Fully used the 3 attempts and has to show next question
        //If currentIndex exceeds 4, then go to result page
        if(quiz.getCurrentIndex() < QuizNew.getQuestions().length -1) {
          quiz.setCurrentAttempt(quiz.getCurrentAttempt() + 1);
//          quiz.setCurrentIndex(quiz.getCurrentIndex() + 1);//After fully use all the three chances, still return to
// the previous question, but with the right answer shown.
          req.getSession().setAttribute("currentAttempt", 0);
          req.getSession().setAttribute("quiz", quiz);
          req.getSession().setAttribute("result", quiz.getScore());
          req.getSession().setAttribute("correctAnswer", quiz.getAnswer());//show the right answer
          req.getSession().setAttribute("question", quiz.getQuestion());
          RequestDispatcher requestDispatcher = req.getRequestDispatcher("/quiznew.jsp");
          requestDispatcher.forward(req, resp);
        } else {
          req.getSession().invalidate();
          req.setAttribute("result", getFinalGrade(quiz.getScore()));
          RequestDispatcher requestDispatcher = req.getRequestDispatcher("/resultnew.jsp");
          requestDispatcher.forward(req, resp);
        }

      }
    }

    req.getSession().setAttribute("result", quiz.getScore());
  }

  private String getFinalGrade(int score) {
    String result = "NC";
    if(score<=50 && score >= 45) {
      result = "A";
    } else if(score<=44 && score >= 35) {
      result = "B";
    } else if(score<=34 && score >= 25) {
      result = "C";
    }
    return result;
  }

  /**
   * check whether the user has another chance
   * @param quiz
   * @return
   */
  private boolean isValidStatus(QuizNew quiz) {
    return quiz.getCurrentAttempt() < 2;
  }

  private boolean isCorrectAnswer(String answer, QuizNew quiz) {
    return answer.equals(String.valueOf(quiz.getAnswer()));
  }
}
