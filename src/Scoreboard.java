public class Scoreboard {

  int homeTimeouts = 7;
  int awayTimeouts = 7;
  int homeTeamScore = 0;
  int awayTeamScore = 0;
  int homeFoulCount = 0;
  int awayFoulCount = 0;


  //method that calculates home and away scores
  //method for checking current quarter / score
  //displays for timeout/score/foulcount/

  public void printTimeLeft (Quarter q) {
    System.out.println(q.name);
    int minutes = (q.durationInSeconds%3600)/60;
    int seconds_output = (q.durationInSeconds% 3600)%60;
    System.out.println("Time: " + minutes + ":" + String.format("%02d", seconds_output));
  }

  public void printCurrentScore() {
    System.out.println("Current Score");
    System.out.println("Home: " + homeTeamScore);
    System.out.println("Away: " + awayTeamScore);

  }


}
