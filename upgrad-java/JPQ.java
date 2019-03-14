import java.util.*;

public class JPQ {
	public static void main(String[] Args) {
		PriorityQueue<Student> studentlist = new PriorityQueue<Student>(new SortStudent());
		Scanner scanner = new Scanner(System.in);
		System.out.println("hello");
		int events = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < events; i++) {
			String event = scanner.next();
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

class Student {
	float cgpa;
	String name;
	int token;

	Student(Float cgpa, String name, int token) {
		this.cgpa = cgpa;
		this.name = name;
		this.token = token;
	}

	public String toString() {
		return this.name;
	}
}

class SortStudent implements Comparator<Student> {
	public int compare(Student a, Student b) {
		if (a.cgpa > b.cgpa) {
			return -1;
		} else if (a.cgpa < b.cgpa) {
			return 1;
		}

		if ((a.name).compareTo(b.name) < 0) {
			return -1;
		} else if (b.name.compareTo(a.name) > 0) {
			return 1;
		}

		if (a.token < b.token) {
			return -1;
		} else {
			return 1;
		}
	}
}