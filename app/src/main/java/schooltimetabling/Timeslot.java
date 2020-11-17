package schooltimetabling;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {
  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  // Required by OptaPlanner to create a planning clone
  private Timeslot() {
  }

  public Timeslot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public static boolean isSequential(Timeslot timeslot1, Timeslot timeslot2) {
    if (timeslot1.dayOfWeek != timeslot2.dayOfWeek) {
      return false;
    } else {
      return timeslot1.startTime == timeslot2.endTime || timeslot1.endTime == timeslot2.startTime;
    }
  }

  @Override
  public String toString() {
    return dayOfWeek + " " + startTime.toString();
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }
}
