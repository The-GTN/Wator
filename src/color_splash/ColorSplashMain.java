package color_splash;

import java.util.*;
import grid.*;

/** Main class for the Color Splash
* @author Nollet Antoine
* @version 19/08/2020
*/
public class ColorSplashMain {

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
    int perOne = Integer.parseInt(args[2]);
    int perTwo = Integer.parseInt(args[3]);
    int perThree = Integer.parseInt(args[4]);

    Field field = new Field(width,height,perOne,perTwo,perThree);

    int steps = Integer.parseInt(args[5]);
    int displayPeriod = Integer.parseInt(args[6]);

    GridDisplayer displayer;
    if(args.length == 9) {
      displayer = new GraphicalGridDisplayer(width,height,"media/pictures/iconeColor.png");
      int squSz =  Integer.parseInt(args[8]);
      GraphicalGridDisplayer.SQUARE_SIZE = squSz;
      GraphicalGridDisplayer.SQUARE_SIZE_INT = squSz - 2;
    }
    else displayer = new TextGridDisplayer();

    ColorSplash cs = new ColorSplash(displayer,field);
    displaySimalution(cs,steps,displayPeriod);

  }

  /** Display the simulation
  * @param bf the simulator
  * @param steps the number of steps of the simulation
  * @param displayPeriod the display period (how much step between 2 displays)
  */
  private static void displaySimalution(ColorSplash bf, int steps, int displayPeriod) {
    for(int i = 0;i!=steps;i++) {
      if(i%displayPeriod == 0) bf.display(i+"/"+steps);
      bf.oneStep();
    }
    bf.display(steps+"/"+steps);
  }

  /** Display the good way to use the simulation
  */
  private static void errorMessage() {
    System.out.println("run with java color_splash.ColourSplash w h po pt pth s dp [display [squSz]]");
    System.out.println("where:");
    System.out.println("w       = width of environment (chose value<100)");
    System.out.println("h       = height of environment (chose value<100)");
    System.out.println("po      = percentage of cell of state one at beginning");
    System.out.println("pt      = percentage of cell of state two at beginning");
    System.out.println("pth      = percentage of cell of state three at beginning");
    System.out.println("s       = number of steps of process");
    System.out.println("dp      = display period (nb of steps between 2 displays)");
    System.out.println("display = (optional) graphical display (text if no arg)");
    System.out.println("squSz   = (optional) square size if no arg");
    System.out.println("try:");
    System.out.println("java color_splash.ColorSplash 30 30 20 20 20 100 1 g 10");
    System.out.println("or");
    System.out.println("java color_splash.ColorSplash 20 20 15 20 15 80 1 g 20");
  }

  /** Boolean to check if the parameters are correct or not
  * @param args the parameters to check
  * @return true if they're not correct, false otherwise
  */
  private static boolean notCorrectParameters(String[] args) {
    try {
      if(notGoodSizeOfParameters(args)) return true;
      if(oneOfThemIsNegative(Arrays.copyOfRange(args,0,7))) return true;
      if(overOrEquals100(args[0]) || overOrEquals100(args[1])) return true;
      if(over100(args[2]) || over100(args[3]) || over100(args[4])) return true;
      if(sumOver100(args[2],args[3],args[4])) return true;
      if(equals0(args[6]) || equals0(args[5])) return true;
      if(args.length== 9) if(notGraphical(args[7]) || negative(args[8])) return true;
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
    return args.length != 7 && args.length != 9;
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

  private static boolean sumOver100(String one, String two, String three) {
    return Integer.parseInt(one) + Integer.parseInt(two) + Integer.parseInt(three) > 100;
  }

}
