package schooltimetabling;

public class Room {
  private String name;

  // Required by OptaPlanner to create a planning clone
  private Room() {
  }

  public Room(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }
}
