package tablice;

public class Main {
	public static void main(String[] args) {
		Student student1 = new Student(101, "ABC", "ABC University");
		Student student2 = new Student(102, "LMN", "LMN University");
		Student student3 = new Student(103, "PQR", "PQR University");
		Student student4 = new Student(104, "UVW", "UVW University");
		Student student5 = new Student(105, "XYZ", "ZYZ University");
		Student studentArray[] = { student1, student2, student3, student4, student5 };

		Result result1 = new Result(111, 101, 70, "A");
		Result result2 = new Result(222, 102, 30, "D");
		Result result3 = new Result(333, 103, 90, "A+");
		Result result4 = new Result(444, 104, 55, "B");
		Result result5 = new Result(555, 105, 45, "C");
		Result resultArray[] = { result1, result2, result3, result4, result5 };

		String topStudentName = getTopStudentName(studentArray, resultArray);
		System.out.println("Najlepszy student: " + topStudentName);
		System.out.println(getNameForId(studentArray, 104 ));
		System.out.println(averageResult(resultArray));
		averageName(studentArray, resultArray);
	}

	static String getTopStudentName(Student studentArray[], Result resultArray[]) {
		String topStudentName = "";
		Result top = resultArray[0];
		for (Result scoreTop: resultArray){
			if (scoreTop.score > top.score) {
				top=scoreTop;
			}
		}
		for (Student studentTop: studentArray) {
			if (studentTop.studentId == top.studentId) {
				topStudentName = studentTop.name;
			}
		}
		return topStudentName;
	}
	static String getNameForId(Student studentArray[], Integer studentId){
		for(Student lookStudent: studentArray) {
			if (studentId == lookStudent.studentId) {
				return lookStudent.name ;
			}
		}
		return "";
	}
	static Double averageResult(Result resultArray[]){
		Double s = 0.0;
		for (Result averesult: resultArray) {
			s = s + averesult.score;
		}
		return s/resultArray.length;
	}
	static void averageName(Student studentArray[], Result resultArray[]){

		String a = "";
		String b = "";
		for (int i = 0; i<resultArray.length; i++) {
			if (resultArray[i].score > averageResult(resultArray)) {
				 a = a + getNameForId(studentArray, resultArray[i].studentId) + " ";
			}
			else {
				b = b + getNameForId(studentArray, resultArray[i].studentId) + " ";
			}

		}
		System.out.println("Students higher average are : " + a);
		System.out.println("Students lower average are: " + b);
	}
}
