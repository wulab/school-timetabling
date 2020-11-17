package schooltimetabling;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class App {
  public static void main(String[] args) {
		// Build the Solver
		SolverFactory<TimeTable> solverFactory = SolverFactory.createFromXmlResource("schooltimetabling/solverConfig.xml");
		Solver<TimeTable> solver = solverFactory.buildSolver();

		// Load a problem
		// https://docs.optaplanner.org/7.45.0.Final/optaplanner-docs/html_single/QuickStart/SpringBoot/timeTableAppScreenshot.png
		List<Timeslot> timeslotList = new ArrayList<Timeslot>();
		List<Room> roomList = new ArrayList<Room>();
		List<Lesson> lessonList = new ArrayList<Lesson>();

		timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
		timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
		timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
		timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
		timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));

		roomList.add(new Room("Room A"));
		roomList.add(new Room("Room B"));
		roomList.add(new Room("Room C"));

		lessonList.add(new Lesson(1, "Geography", "C. Darwin", "10th grade"));
		lessonList.add(new Lesson(2, "Physics", "M. Curie", "10th grade"));
		lessonList.add(new Lesson(3, "Physics", "M. Curie", "9th grade"));
		lessonList.add(new Lesson(4, "Chemistry", "M. Curie", "9th grade"));
		lessonList.add(new Lesson(5, "Math", "A. Turing", "10th grade"));
		lessonList.add(new Lesson(6, "Math", "A. Turing", "10th grade"));
		lessonList.add(new Lesson(7, "Spanish", "P. Cruz", "9th grade"));
		lessonList.add(new Lesson(8, "Spanish", "P. Cruz", "10th grade"));
		lessonList.add(new Lesson(9, "English", "I. Jones", "9th grade"));
		lessonList.add(new Lesson(10, "English", "I. Jones", "9th grade"));

		TimeTable unsolvedTimeTable = new TimeTable(timeslotList, roomList, lessonList);

		// Solve the problem
		TimeTable solvedTimeTable = solver.solve(unsolvedTimeTable);

		// Display the result
		StringBuilder solution = new StringBuilder();
		HardSoftScore score = solvedTimeTable.getScore();

		for (Lesson lesson : solvedTimeTable.getLessonList()) {
			Timeslot timeslot = lesson.getTimeslot();
			Room room = lesson.getRoom();

			if (timeslot == null || room == null) {
				continue;
			}

			solution.append("* " + lesson.toString() + " -> " + room.toString() + ", " + timeslot.toString() + "\n");
		}

		System.out.println("Solved TimeTable with " + timeslotList.size() + " timeslots, " + roomList.size() + " rooms and " + lessonList.size() + " lessons:\n");
		System.out.println(solution.toString());
		System.out.println("Score: " + score.toString());
  }
}
