package thieves;

import java.util.*;
import grid.*;

/** Main class for the Thieves
* @author Nollet Antoine
* @version 20/08/2020
*/
public class ThievesMain {

  /** Main function
  * @param args the parameters entered
  */
  public static void main(String[] args) {

    if (notCorrectParameters(args)) errorMessage();

    else simulation(args);

  }

  /** Launch the simulation with the parameters verified
  * @param args the parameters verified
  */
  private static void simulation(String[] args) {


    int width = Integer.parseInt(args[0]);
    int height = Integer.parseInt(args[1]);
    int perThief = Integer.parseInt(args[2]);
    int maxCoins = Integer.parseInt(args[3]);

    Container container = new Container(width,height,perThief,maxCoins);

    int steps = Integer.parseInt(args[4]);
    int displayPeriod = Integer.parseInt(args[5]);

    GridDisplayer displayer;
    if(args.length == 8) {
      displayer = new GraphicalGridDisplayer(width,height,"media/pictures/iconeThieves.png");
      int squSz =  Integer.parseInt(args[7]);
      GraphicalGridDisplayer.SQUARE_SIZE = squSz;
      GraphicalGridDisplayer.SQUARE_SIZE_INT = squSz - 2;
    }
    else displayer = new TextGridDisplayer();

    Thieves th = new Thieves(displayer,container);
    displaySimalution(th,steps,displayPeriod);

  }

  /** Display the simulation
  * @param Thieves the simulator
  * @param steps the number of steps of the simulation
  * @param displayPeriod the display period (how much step between 2 displays)
  */
  private static void displaySimalution(Thieves lg, int steps, int displayPeriod) {
    for(int i = 0;i!=steps;i++) {
      if(i%displayPeriod == 0) lg.display(i+"/"+steps);
      lg.oneStep();
    }
    lg.display(steps+"/"+steps);
  }

  /** Display the good way to use the simulation
  */
  private static void errorMessage() {
    System.out.println("run with java life.LifeGame w h pd s dp [display [squSz]]");
    System.out.println("where:");
    System.out.println("w       = width of environment (chose value<100)");
    System.out.println("h       = height of environment (chose value<100)");
    System.out.println("pt      = percentage of thieves at beginning");
    System.out.println("mc      = the maximum of coins of a thief at beginning");
    System.out.println("s       = number of steps of process");
    System.out.println("dp      = display period (nb of steps between 2 displays)");
    System.out.println("display = (optional) graphical display (text if no arg)");
    System.out.println("squSz   = (optional) square size if no arg");
    System.out.println("try:");
    System.out.println("java thieves.Thieves 20 20 10 3 200 1 g 10");
    System.out.println("or");
    System.out.println("java thieves.Thieves 25 25 10 5 200 1 g 10");
  }

  /** Boolean to check if the parameters are correct or not
  * @param args the parameters to check
  * @return true if they're not correct, false otherwise
  */
  private static boolean notCorrectParameters(String[] args) {
    try {
      if(notGoodSizeOfParameters(args)) return true;
      if(oneOfThemIsNegative(Arrays.copyOfRange(args,0,5))) return true;
      if(overOrEquals100(args[0])) return true;
      if(overOrEquals100(args[1])) return true;
      if(over100(args[2])) return true;
      if(negative(args[3]) || equals0(args[3])) return true;
      if(equals0(args[5])) return true;
      if(args.length== 8) if(notGraphical(args[6]) || negative(args[7])) return true;
      return false;
    }
    catch(NumberFormatException e) {
      return true;
    }
  }

  /** Boolean to check if the size of the list of parameters is correct or not (5 or 7)
  * @param args the list parameters we want to check the size
  * @return true if the size is'nt correct, false otherwise
  */
  private static boolean notGoodSizeOfParameters(String[] args) {
    return args.length != 6 && args.length != 8;
  }

  /** Boolean to check if the parameter is over or equals to 100
  * @param n the parameter
  * @return true if the string n is over or equals to 100, flase otherwise
  */
  private static boolean overOrEquals100(String n) {
    return Integer.parseInt(n) >= 100;
  }

  /** Boolean to check if the parameter is equals to 0
  * @param n the parameter
  * @return true if the string n is equals to 0, flase otherwise
  */
  private static boolean equals0(String n) {
    return Integer.parseInt(n) == 0;
  }

  /** Boolean to check if the parameter is negative or not
  * @param n the parameter
  * @return true if n is negative, false otherwise
  */
  private static boolean negative(String n){
    return Integer.parseInt(n) < 0;
  }

  /** Boolean to check if one at least of the parameters in the list is negative
  * @param args the list of parameters to check
  * @return true if one at least of the parameters in the list is negative, false otherwise
  */
  private static boolean oneOfThemIsNegative(String[] args){
    for(String n : args) if(negative(n)) return true;
    return false;
  }

  /** Boolean to check if the parameter is greater than 100
  * @param n the parameter
  * @return true if the sum of this two parameters is greater than 100, false otherwise
  */
  private static boolean over100(String n){
    return Integer.parseInt(n) > 100;
  }

  /** Boolean to check if the parameter correspond to describe the word "graphical"
  * @param n the parameter to check
  * @return true if the parameter correspond to describe the word "graphical", false otherwise
  */
  private static boolean notGraphical(String n) {
    return !(n.equals("g")) && !(n.equals("graphical")) && !(n.equals("Graphical")) && !(n.equals("graph") && !(n.equals("G")));
  }

}
