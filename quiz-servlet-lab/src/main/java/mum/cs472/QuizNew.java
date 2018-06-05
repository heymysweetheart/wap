package mum.cs472;

public class QuizNew {
  public static String[] questions = {
      "3,1,4,1,5", //pi
      "1,1,2,3,5", //fibonacci
      "1,4,9,16,25", //square
      "2,3,5,7,11", //primes
      "1,2,4,8,16" //power of 2
  };

  public static int[] answers = {
      9, 8, 36, 13, 32
  };

  public static String[] hints = {
     "PI",
     "Fibonacci",
     "Square",
     "Primes",
     "Power of 2"
  };

  private int currentAttempt = 0;

  public int getCurrentAttempt() {
    return currentAttempt;
  }

  public void setCurrentAttempt(int currentAttempt) {
    this.currentAttempt = currentAttempt;
  }

  public String getHint() {
    return hints[currentIndex];
  }

  private int currentIndex=0;

  private int score = 0;

  public static String[] getQuestions() {
    return questions;
  }

  public int getAnswer() {
    return answers[currentIndex];
  }

  public static void setQuestions(String[] questions) {
    QuizNew.questions = questions;
  }

  public static int[] getAnswers() {
    return answers;
  }

  public static void setAnswers(int[] answers) {
    QuizNew.answers = answers;
  }

  public int getCurrentIndex() {
    return currentIndex;
  }

  public void setCurrentIndex(int currentIndex) {
    this.currentIndex = currentIndex;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public QuizNew(int currentIndex, int score) {
    this.currentIndex = currentIndex;
    this.score = score;
  }

  public String getQuestion() {
    return questions[currentIndex];
  }

  public int getNewScore(QuizNew quiz) {
    int currentAttempt = quiz.getCurrentAttempt();
    switch (currentAttempt) {
      case 0: return 10;
      case 1: return 5;
      case 2: return 2;
      default: return 0;
    }
  }
}
