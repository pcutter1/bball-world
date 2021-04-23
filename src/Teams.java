public class Teams {
  Player[] roster = new Player[5];
  String coach = RandomNumber.names[RandomNumber.generateNumber()] + " " + RandomNumber.names[RandomNumber.generateNumber()];
  String name;
  String city;
  String[] positions = new String[] {"PG", "SG", "SF", "PF", "C"};

  public Teams(Player[] roster, String name, String city) {
    this.roster = roster;
    this.name = name;
    this.city = city;
  }
  
  public Teams(String name, String city) {
    this(new Player[5], name, city);
    populateTeam();
  }

  public void populateTeam() {
      int i = roster.length-1;
      while (i != -1) {
        roster[i] = new Player();
        roster[i].setPosition(positions[i]);
        i--;
      }
  }
  
  public void printTeamInfo() {

    System.out.println("Starting Lineup for your " + city + " " + name + ":\n" 
            + "Coach: " + coach);
    for(Player player : roster) {
      System.out.println("\n" + player.position + ": " + player.number + "- " + player.name);
    }
    
  }
  
}
