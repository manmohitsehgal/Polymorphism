import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student extends AcademicPerson {

	// Instance variables
	private int[] grades; // grade for the corresponding course
	private static final int MAX_COURSES = 30; // maximum number of courses
	Map<String, Integer> student;

	// Constructor
	public Student(String name, String address) {
		super(name, address);
		courses = new String[MAX_COURSES];
		grades = new int[MAX_COURSES];
		student = new HashMap<String, Integer>();

	}

	// It adds a course and corresponding grade to the lists.
	// Student can take the same course couple of times. If a course that
	// already exists in the list is given as the input of the method you need
	// to compare the input grade with the one that is saved in the Grades list,
	// the higher grade needs to be saved in the Grades list.
	public void addCourseGrade(String course, int grade) {
		// student = new HashMap<String, Integer>();
		student.put(course, grade);
	}

	// This method prints the student's average grade for all the courses.
	// This method throws IllegalDivisionByZero exception, when there is no
	// courses in the list.
	public void getAverageGrade() throws IllegalDivisionByZero {
		// student = new HashMap<String, Integer>();
		double average = 0.0;
		int totalStudent = 0;
		Double averageGrade = 0.0;
		int counter = 0;

		if (student.isEmpty()) {
			throw new IllegalDivisionByZero("Division by zero");
		} else {
			Set<String> course = student.keySet();
			for (String grade : course) {
				averageGrade += student.get(grade);
				counter++;
			}

			average = (averageGrade / counter);
			System.out.println("Average is: " + average);
		}

	}

	// It prints all the courses with the corresponding grades in each line.
	@Override
	public void printCourses() {
		System.out.println("CourseName"+"\t"+"CourseGrade");
		for (String courses : student.keySet()) {
			System.out.println(courses + "             " +student.get(courses));
		}
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Student: " + super.toString();
	}
}