/*
add(student_id) --> seat #
Assign student to seat that maximises the distance to nearest neighbor. Break ties by going to the left

remove(student_id)

add("s1") -> 0
"s1" _    _    _    _    _    _    _
add("s2") -> 7
"s1" _    _    _    _    _    _    "s2"
add("s3") -> 3
"s1" _    _    "s3" _    _    _    "s2"
add("s4") -> 5
"s1" _    _    "s3" _    "s4" _    "s2"
remove("s3")
"s1" _    _    _ .  _    "s4" _    "s2"
add("s5") -> 2
"s1" _    "s5" _ .  _    "s4" _    "s2"
*/

import java.util.*;
import java.io.*;
import static java.lang.Integer.*;

class Student_Seat {
	int NUMBER_OF_SEATS;
	TreeSet<Integer> seats;
	HashMap<String, Integer> students;

	public Student_Seat(int numberOfSeats) {
		this.seats = new TreeSet<>();
		this.students = new HashMap<>();
		this.NUMBER_OF_SEATS = numberOfSeats;
	}

	//add: O(n) time
	public int add(String student) {
		if(seats.size() == NUMBER_OF_SEATS) {
			return -1; //Already full.
		}
		int maxDist = 0;
		int targetPlace = 0;
		if(!seats.isEmpty()) {
			Integer pt = 0; //pointer
			while(pt != null && pt != NUMBER_OF_SEATS - 1) {
				Integer temp = seats.higher(pt);
				if(temp == null) {
					temp = NUMBER_OF_SEATS - 1;
					targetPlace = NUMBER_OF_SEATS - 1;
				} else if(temp - pt > maxDist) {
					targetPlace = pt + (temp - pt) / 2;  //find mid
					maxDist = temp - pt;
				}
				pt = temp;
			}
		}	
		seats.add(targetPlace);
		students.put(student, targetPlace);
		return targetPlace;
	}

	//remove: O(1) time
	public void remove(String student) {
		if(!students.containsKey(student)) {
			throw new IllegalArgumentException("This student " + student + " is not in the seats.");
		}
		seats.remove(students.get(student));
	}


	public static void main(String[] args){
		Student_Seat t = new Student_Seat(8);

		System.out.println(t.add("s1")); 
		System.out.println("Add s1: " + "\t" + t.printStatus() + "\n");

		System.out.println(t.add("s2"));
		System.out.println("Add s2: " + "\t" + t.printStatus() + "\n");

		System.out.println(t.add("s3"));
		System.out.println("Add s3: " + "\t" + t.printStatus() + "\n");

		System.out.println(t.add("s4"));
		System.out.println("Add s4: " + "\t" + t.printStatus() + "\n");

		t.remove("s2");
		System.out.println("Remove s2: " + "\t" + t.printStatus() + "\n");

		System.out.println(t.add("s5"));
		System.out.println("Add s5: " + "\t" + t.printStatus() + "\n");
	}

	private String printStatus() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < NUMBER_OF_SEATS; i++) {
			if(seats.contains(i)) {
				sb.append("S");
			} else {
				sb.append("-");
			}
		}
		return sb.toString();
	}
}