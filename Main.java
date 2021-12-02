//@author Ryan Schiell, Andrew Edelen, Luke Estey, and Jacob Schloemer
//@version 1.1 on 11/30/21

//all the imports for the entire repl
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main {
 public static void main(String[] args) {
   SwingUtilities.invokeLater(new Runnable() {
     //this should run a new game
     public void run() {
      new JeopardyGame();
      
     }
   });
 }
}