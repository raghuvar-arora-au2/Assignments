import java.util.*;

/**
 * Following is the service class that is does the required job
 */
public class JPQ {
	public static void main(String[] Args) {
		// declares and initialises the PriorityQueue with SortStudent comparator
		PriorityQueue<Student> studentlist = new PriorityQueue<Student>(new SortStudent());
		Scanner scanner = new Scanner(System.in);
		int events = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < events; i++) {
			String event = scanner.next();
			// if "ENTER" initialize a new Student object with the given data and add to the
			// Queue
			if (event.equals("ENTER")) {
				String name = scanner.next();
				float cgpa = scanner.nextFloat();
				int token = scanner.nextInt();
				Student s = new Student(cgpa, name, token);
				studentlist.add(s);
			} else {
				studentlist.poll();
			}
		}
		scanner.close();
		while (!studentlist.isEmpty()) {
			System.out.println(studentlist.poll());
		}
	}
}

/**
 * Represents a student with attributes cgpa, name, token
 */
class Student {
	float cgpa;
	String name;
	int token;

	Student(Float cgpa, String name, int token) {
		this.cgpa = cgpa;
		this.name = name;
		this.token = token;
	}

	/**
	 * @Override returns the value of name attribute of the object
	 */
	public String toString() {
		return this.name;
	}
}

/**
 * comparator class to compare students according to given specs
 */
class SortStudent implements Comparator<Student> {
	public int compare(Student a, Student b) {

		if (a.cgpa > b.cgpa) {
			return -1;
		} else if (a.cgpa < b.cgpa) {
			return 1;
		}

		// the program reaches here only if the cgpa are equal
		if ((a.name).compareTo(b.name) < 0) {
			return -1;
		} else if (b.name.compareTo(a.name) > 0) {
			return 1;
		}

		// the program reaches here only if both Student objects have equal cgpa and
		// same name.
		if (a.token < b.token) {
			return -1;
		} else {
			return 1;
		}
	}
}