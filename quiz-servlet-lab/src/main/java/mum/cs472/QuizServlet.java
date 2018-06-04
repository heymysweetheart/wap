package mum.cs472;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Quiz quiz = new Quiz(0, 0);
    req.getSession().setAttribute("quiz", quiz);
    req.getSession().setAttribute("index", 0);
    req.getSession().setAttribute("question", quiz.getQuestion());
    RequestDispatcher dispatcher = req.getRequestDispatcher("/quiz.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Quiz quiz = (Quiz) req.getSession().getAttribute("quiz");
    String answer = req.getParameter("answer");
    if(isCorrectAnswer(answer, quiz)) {
      quiz.setScore(quiz.getScore() + 1);
    }
    req.getSession().setAttribute("result", quiz.getScore());

    int currentIndex = quiz.getCurrentIndex();
    if(currentIndex < 4) {//Go on with the test
      quiz.setCurrentIndex(currentIndex + 1);
      req.getSession().setAttribute("quiz", quiz);
      req.getSession().setAttribute("question", quiz.getQuestion());
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/quiz.jsp");
      requestDispatcher.forward(req, resp);
    } else {//Turn to another page to show the result
      req.getSession().invalidate();
      req.setAttribute("result", quiz.getScore());
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/result.jsp");
      requestDispatcher.forward(req, resp);
    }

  }

  private boolean isCorrectAnswer(String answer, Quiz quiz) {
    return answer.equals(String.valueOf(quiz.getAnswer()));
  }
}
