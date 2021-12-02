//@author Ryan Schiell, Andrew Edelen, Luke Estey, and Jacob Schloemer

//all of the import files for game.java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//jeopardy game class is created
class JeopardyGame implements ActionListener {

  //Swing components
  JTextField userName = new JTextField("Enter Your Name");
  JLabel userWelcome = new JLabel("Welcome to Group 4's Jeopardy game!");
  JLabel gameQuestion = new JLabel("Question: ");
  JLabel category = new JLabel("Category: ");;
  JLabel score = new JLabel("Score: ");
  JLabel option1 = new JLabel("Option A: ");
  JLabel option2 = new JLabel("Option B: ");
  JLabel option3 = new JLabel("Option C: ");
  JLabel option4 = new JLabel("Option D: ");
  JLabel rightAnswer = new JLabel("");
  JButton ans1 = new JButton("ans1");
  JButton ans2 = new JButton("ans2");
  JButton ans3 = new JButton("ans3");
  JButton ans4 = new JButton("ans4");
  JButton next = new JButton("next");
  JButton exit = new JButton("exit");

  //Game variables
  ArrayList<Question> gameQuestions;
  int playerScore = 0;
  int questionNumber = 0;
  int currentAnswer = 0;
  int currentPoints = 0;

//here the game is formatted using swing GUI elements
  JeopardyGame(){
   
    FlowLayout frameLayout = (new FlowLayout(FlowLayout.CENTER));
    
    JFrame frame = new JFrame("Group 4's Jeopardy Game");
    frame.setLayout(frameLayout);
    frame.setSize(550,550);

    userName.setBounds(0,0,350,50);
    userName.setFont(new Font("Ink Free",Font.BOLD,25));
    userName.setHorizontalAlignment(userName.CENTER);
    frame.add(userName);

    ans1.setText("A");
    ans1.setBounds(0,200,100,50);
    ans1.setForeground(Color.RED);
    frame.add(ans1);

    ans2.setText("B");
    ans2.setForeground(Color.RED);
    ans2.setBounds(0,300,100,50);
    frame.add(ans2);

    ans3.setText("C");
    ans3.setBounds(0,400,100,50);
    ans3.setForeground(Color.RED);
    frame.add(ans3);

    ans4.setText("D");
    ans4.setBounds(0,500,100,50);
    ans4.setForeground(Color.RED);
    frame.add(ans4);

    JButton next = new JButton();
    next.setText("Next");
    next.setBounds(700,500,100,50);
    next.setForeground(Color.BLUE);
    frame.add(next);

    JButton exit = new JButton();
    exit.setText("Exit");
    exit.setBounds(700,0,100,50);
    frame.add(exit);
    
    score.setFont(new Font ("Calibri", Font.BOLD,15));

    frame.add(score);
    frame.add(category);
    userWelcome.setFont(new Font("Calibri", Font.BOLD,20));
    frame.add(userWelcome);


    gameQuestion.setBounds(200,100,200,50);
    gameQuestion.setFont(new Font("Calibri", Font.BOLD,20));
    frame.add(gameQuestion);

    frame.add(option1);
    frame.add(option2);
    frame.add(option3);
    frame.add(option4);
    frame.add(rightAnswer);

    ans1.addActionListener(this);
    ans2.addActionListener(this);
    ans3.addActionListener(this);
    ans4.addActionListener(this);
    next.addActionListener(this);
    exit.addActionListener(this);
    userName.addActionListener(this);
    
    frame.setVisible(true);
    
  
    
    //Include method to load questions from trivia
    //Include method to write scores to scores

    gameQuestions = loadQuestions();
    goToQuestion(questionNumber);
    score.setText("Score: " + Integer.toString(playerScore));
    

  }
  //Load questions
  public ArrayList<Question> loadQuestions() {
    ArrayList<Question> questions = new ArrayList<Question>();
    try{
      File triviaFile = new File("trivia.txt");
      ArrayList<String> triviaQuestions = new ArrayList<String>();
      FileReader readTrivia;
      BufferedReader readQuestions;
      readTrivia = new FileReader(triviaFile);
      readQuestions = new BufferedReader(readTrivia);
      String line;

      while((line = readQuestions.readLine()) != null){
        triviaQuestions.add(line);
      }
      for(int i = 0; i < 6; i++){
        Question newQuestion = new Question(triviaQuestions.get(8*i),
        triviaQuestions.get((8*i) + 1),triviaQuestions.get((8*i)+2),
        triviaQuestions.get((8*i)+3),
        triviaQuestions.get((8*i)+4), 
        Integer.parseInt(triviaQuestions.get((8*i)+5)), Integer.parseInt(triviaQuestions.get((8*i)+6)),triviaQuestions.get((8*i)+7));
        questions.add(newQuestion);
      }
      readQuestions.close();
      readTrivia.close();
    }
    catch (IOException exception){
      System.out.println("An error occurred: " + exception);
    }
    return questions;
  }

  //ScoreWriter saves scores to the txt file
  public boolean saveScores(String userNM, int userScore){
    boolean successfulSave = false;

    try {
      File scoreFile = new File("score.txt");
      FileWriter FW = new FileWriter(scoreFile,true);
      BufferedWriter writeScore = new BufferedWriter(FW);
      writeScore.newLine();
      writeScore.write(userNM + " Score: " + userScore);
      writeScore.close();
      FW.close();
      successfulSave = true;
    }
    catch (IOException exception) {
      System.out.println("An error occured: " + exception);
    }
    return successfulSave;
  }

  //Action Performer
  public void actionPerformed(ActionEvent ae){
    String buttonPressed = ae.getActionCommand();
    switch(buttonPressed) {
      case "A":
        if (gameQuestions.get(questionNumber).getStatus() == false){
          if(currentAnswer == 1){
            rightAnswer.setText("Correct!");
            playerScore += currentPoints;
            score.setText("Score: " + playerScore);
          }
          else{
            rightAnswer.setText("Wrong, sorry!");
          }
          gameQuestions.get(questionNumber).setStatus(true);
        }
        break;
      case "B":
        if (gameQuestions.get(questionNumber).getStatus() == false){
          if(currentAnswer == 2){
            rightAnswer.setText("Correct!");
            playerScore += currentPoints;
            score.setText("Score: " + playerScore);
          }
          else{
            rightAnswer.setText("Wrong, sorry!");
          }
          gameQuestions.get(questionNumber).setStatus(true);
        }
        break;
      case "C":
        if (gameQuestions.get(questionNumber).getStatus() == false){
          if(currentAnswer == 3){
            rightAnswer.setText("Correct!");
            playerScore += currentPoints;
            score.setText("Score: " + playerScore);
          }
          else{
            rightAnswer.setText("Wrong, sorry!");
          }
          gameQuestions.get(questionNumber).setStatus(true);
        }
        break;
      case "D":
        if (gameQuestions.get(questionNumber).getStatus() == false){
          if(currentAnswer == 4){
            rightAnswer.setText("Correct!");
            playerScore += currentPoints;
            score.setText("Score: " + playerScore);
          }
          else{
            rightAnswer.setText("Wrong, sorry!");
          }
          gameQuestions.get(questionNumber).setStatus(true);
        }
        break;
      case "Next":
        questionNumber++;
        if (gameQuestions.size() > questionNumber){
          goToQuestion(questionNumber);
        }
        else {
          rightAnswer.setText("No more questions!");
        }
        break;
      case "Exit":
        saveScores(userName.getText(),playerScore);
        System.exit(0);
        break;
      default: 
        System.out.println("Other");      
    }

    
  }
  
  public void goToQuestion(int qID){
    // Find the question in the question list
    Question nextQuestion = gameQuestions.get(qID);
    currentAnswer = nextQuestion.getCorrectAnswer();
    currentPoints = nextQuestion.getCorrectPoints();
    category.setText("Category: " + nextQuestion.getCategory());
    gameQuestion.setText(nextQuestion.getQuestionName());
    option1.setText("A: " + nextQuestion.getChoice1());
    option2.setText("B: " + nextQuestion.getChoice2());
    option3.setText("C: " + nextQuestion.getChoice3());
    option4.setText("D: " + nextQuestion.getChoice4());
    rightAnswer.setText("");
  }

}

