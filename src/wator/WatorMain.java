package wator;

import grid.*;
import wator.environment.*;
import wator.fish.*;
import java.util.*;

/** Main class for the wator project
*
*@author Nollet Antoine
*@version 20/05/2020
*/
public class WatorMain {

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

    int perTuna = Integer.parseInt(args[2]);
    int perShark = Integer.parseInt(args[3]);
    int nbTuna = perTuna*width*height/100;
    int nbSharks = perShark*width*height/100;
    Tuna.GESTATION = Integer.parseInt(args[4]);
    Shark.GESTATION = Integer.parseInt(args[5]);
    Shark.ENERGY = Integer.parseInt(args[6]);

    Sea sea = new Sea(width,height);
    sea.addTunasAndSharks(nbTuna,nbSharks);

    int steps = Integer.parseInt(args[7]);
    int displayPeriod = Integer.parseInt(args[8]);

    GridDisplayer displayer;
    if(args.length == 11) {
      displayer = new GraphicalGridDisplayer(width,height,"media/pictures/icone.png");
      int squSz =  Integer.parseInt(args[10]);
      GraphicalGridDisplayer.SQUARE_SIZE = squSz;
      GraphicalGridDisplayer.SQUARE_SIZE_INT = squSz - 2;
    }
    else displayer = new TextGridDisplayer();

    Wator wator = new Wator(displayer,sea);
    displaySimalution(wator,steps,displayPeriod);

  }

  /** Display the simulation
  * @param wator the simulator
  * @param steps the number of steps of the simulation
  * @param displayPeriod the display period (how much step between 2 displays)
  */
  private static void displaySimalution(Wator wator, int steps, int displayPeriod) {
    for(int i = 0;i!=steps;i++) {
      if(i%displayPeriod == 0) wator.display(i+"/"+steps);
      wator.oneStep();
    }
    wator.display(steps+"/"+steps);
  }

  /** Display the good way to use the simulation
  */
  private static void errorMessage() {
    System.out.println("run with java wator.Wator w h pt ps tgp spg ssp s dp [display [squSz]]");
    System.out.println("where:");
    System.out.println("w       = width of environment (chose value<100)");
    System.out.println("h       = height of environment (chose value<100)");
    System.out.println("pt      = percentage of tuna at beginning");
    System.out.println("ps      = percentage of shark at beginning");
    System.out.println("tgp     = tuna gestation period");
    System.out.println("sgp     = shark gestation period");
    System.out.println("ssp     = shark starvation period");
    System.out.println("s       = number of steps of process (number of 'fishes' that act)");
    System.out.println("dp      = display period (nb of steps between 2 displays)");
    System.out.println("display = (optional) graphical display (text if no arg)");
    System.out.println("squSz   = (optional) square size if no arg");
    System.out.println("try:");
    System.out.println("java wator.watorMain 20 20 20 20 1 3 2 40000 250 g 20");
    System.out.println("or");
    System.out.println("java wator.watorMain 25 25 30 10 2 5 3 125000 250 g 20");
  }

  /** Boolean to check if the parameters are correct or not
  * @param args the parameters to check
  * @return true if they're not correct, false otherwise
  */
  private static boolean notCorrectParameters(String[] args) {
    try {
      if(notGoodSizeOfParameters(args)) return true;
      if(oneOfThemIsNegative(Arrays.copyOfRange(args,0,9))) return true;
      if(overOrEquals100(args[0])) return true;
      if(overOrEquals100(args[1])) return true;
      if(sumOver100(args[2],args[3])) return true;
      if(equals0(args[8])) return true;
      if(args.length== 11) if(notGraphical(args[9]) || negative(args[10])) return true;
      return false;
    }
    catch(NumberFormatException e) {
      return true;
    }
  }

  /** Boolean to check if the size of the list of parameters is correct or not (9 or 11)
  * @param args the list parameters we want to check the size
  * @return true if the size is'nt correct, false otherwise
  */
  private static boolean notGoodSizeOfParameters(String[] args) {
    return args.length != 9 && args.length != 11;
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

  /** Boolean to check if the sum of two parameters if greater than 100
  * @param n1 the first parameter
  * @param n2 the second parameter
  * @return true if the sum of this two parameters is greater than 100, false otherwise
  */
  private static boolean sumOver100(String n1, String n2){
    return (Integer.parseInt(n1)+Integer.parseInt(n2)) > 100;
  }

  /** Boolean to check if the parameter correspond to describe the word "graphical"
  * @param n the parameter to check
  * @return true if the parameter correspond to describe the word "graphical", false otherwise
  */
  private static boolean notGraphical(String n) {
    return !(n.equals("g")) && !(n.equals("graphical")) && !(n.equals("Graphical")) && !(n.equals("graph") && !(n.equals("G")));
  }

}
