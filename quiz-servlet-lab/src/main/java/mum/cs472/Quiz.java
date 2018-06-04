package mum.cs472;

public class Quiz {
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

  private int currentIndex=0;

  private int score = 0;

  public static String[] getQuestions() {
    return questions;
  }

  public int getAnswer() {
    return answers[currentIndex];
  }

  public static void setQuestions(String[] questions) {
    Quiz.questions = questions;
  }

  public static int[] getAnswers() {
    return answers;
  }

  public static void setAnswers(int[] answers) {
    Quiz.answers = answers;
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

  public Quiz(int currentIndex, int score) {
    this.currentIndex = currentIndex;
    this.score = score;
  }

  public String getQuestion() {
    return questions[currentIndex];
  }
}
