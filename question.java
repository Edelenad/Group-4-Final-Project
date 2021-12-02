//@author Ryan Schiell, Andrew Edelen, Luke Estey, and Jacob Schloemer

//question class is created
class Question {
  public
  String questionName;
  String choice1;
  String choice2;
  String choice3;
  String choice4;
  int correctAnswer;
  int correctPoints;
  String category;
  boolean alreadyAnswered;

//question constructor
//@param requires all 8 parts of a trivia question
  Question(String aQuestionName, String aFirstChoice, String aSecondChoice, String aThirdChoice, String aFourthChoice, int aCorrectAnswer, int theCorrectPoints, String aCategory){
    questionName = aQuestionName;
    choice1 = aFirstChoice;
    choice2 = aSecondChoice;
    choice3 = aThirdChoice;
    choice4 = aFourthChoice;
    correctAnswer = aCorrectAnswer;
    correctPoints = theCorrectPoints;
    category = aCategory;
    alreadyAnswered = false;
  }

//below are all of the accessor methods
//@return returns that part of the question
  String getQuestionName(){
    return questionName;
  }

  String getChoice1(){
    return choice1;
  }

  String getChoice2(){
    return choice2;
  }

  String getChoice3(){
    return choice3;
  }

  String getChoice4(){
    return choice4;
  }

  int getCorrectAnswer(){
    return correctAnswer;
  }

  int getCorrectPoints(){
    return correctPoints;
  }

  String getCategory(){
    return category;
  }

  boolean getStatus(){
    return alreadyAnswered;
  }

  public void setStatus(boolean newStatus){
    alreadyAnswered = newStatus;
  }
}