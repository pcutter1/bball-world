

public class Player {
  String name = RandomNumber.names[RandomNumber.generateNumber()] + " " + RandomNumber.names[RandomNumber.generateNumber()];
  String number = String.valueOf(RandomNumber.generateNumber());
  String position = "Guard";
  int threePointRating = RandomNumber.generateNumber();
  int defensiveRating = RandomNumber.generateNumber();
  int midRangeRating = RandomNumber.generateNumber();
  int postRating = RandomNumber.generateNumber();
  int passRating = RandomNumber.generateNumber();
  int freeThrowRating = RandomNumber.generateNumber();



  public Player(String name, String number, String position, int threePointRating,
      int defensiveRating, int midRangeRating, int postRating, int passRating,
      int freeThrowRating) {
    this.name = name;
    this.number = number;
    this.position = position;
    this.threePointRating = threePointRating;
    this.defensiveRating = defensiveRating;
    this.midRangeRating = midRangeRating;
    this.postRating = postRating;
    this.passRating = passRating;
    this.freeThrowRating = freeThrowRating;

  }

  public Player() {
    //default
  }

  public void setPosition(String position) {
    this.position = position;
  }
}
