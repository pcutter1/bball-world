import java.util.Scanner;

public class Game {
  Scanner scanner = new Scanner(System.in);
  boolean started = false;
  Quarter first = new Quarter("First");
  Quarter second = new Quarter("Second");
  Quarter third = new Quarter("Third");
  Quarter fourth = new Quarter("Fourth");
  Quarter[] quarters = new Quarter[]{first, second, third, fourth};
  int currentQuarter = 0;
  Quarter acutalQuarter = quarters[currentQuarter];
  Scoreboard scoreboard = new Scoreboard();

  Teams home = new Teams("Rockets", "Houston");
  Teams away = new Teams("Bulls", "Chicago");
  Teams posession = home;


  //functionality of interaction
  //pass method
  //shoot method
  //outcome logic
  //call timeout method

  public void startGame() {
    started = true;
    //start prompt / tipoff
    shootPrompt();
  }

  public void shootPrompt(){
    System.out.println("You have the rock. What are you going to do?");
    System.out.println("p - Pass the ball\n" + "h - High percentage shot\n" + "l - Low percentage shot");

    char operator = scanner.next().charAt(0);

    switch(operator) {
      case 'p': //pass method
        break;
      case 'h': hpShot();
        break;
      case 'l': lpShot();
        break;
      default:
        System.out.println("You took too long to decide and lost the ball");

    }
    deductTime(acutalQuarter);
    changePosession();

    scoreboard.printTimeLeft(acutalQuarter);
    scoreboard.printCurrentScore();

    shootPrompt();
  }

  public void hpShot(){

    int RNG = (int) (Math.random() * 10);
    int score = 0;

    if (RNG > 9) {
      System.out.println("Can't buy a bucket! - You're getting benched.");
    } else if(RNG > 7) {
      System.out.println("From deep.... YES! Good for 3!");
      score = 3;
    } else {
      System.out.println("You drive the lane - AND FINISH AT THE RIM FOR 2!");
      score = 2;
    }
    addToScore(score);

  }

  public void lpShot(){

    int RNG = (int) (Math.random() * 10);
    int score = 0;

    if (RNG > 5) {
      System.out.println("You had no business taking that shot. Brick city!");
    } else if(RNG > 2) {
      System.out.println("Hits the lucky 3!!");
      score = 3;
    } else {
      System.out.println("The ball rattles... and you get the friendly roll! But your toe was on the line");
      score = 2;
    }
    addToScore(score);
  }

  void addToScore(int points) {
    if(posession.equals(home)) {
      scoreboard.homeTeamScore += points;
    } else {
      scoreboard.awayTeamScore += points;
    }
  }

  public void deductTime(Quarter qt) {
    qt.durationInSeconds -= 25;
    if (qt.durationInSeconds <= 0 && currentQuarter == 3) {
      System.out.println("GAME OVER!");
      scoreboard.printCurrentScore();

      System.out.println("THE WINNER IS:");
      if(scoreboard.homeTeamScore > scoreboard.awayTeamScore) {
        System.out.println(home.name);
      } else {
        System.out.println(away.name);
      }
    } else if (qt.durationInSeconds <= 0){
      startNewQuarter();
    }

  }

  public void startNewQuarter() {
    currentQuarter++;
    acutalQuarter = quarters[currentQuarter];
  }

  public void changePosession(){
    if (posession.equals(home)){
      posession = away;
    } else {
      posession = home;
    }
  }

}
