class StudentDetails
{
	public static void main(String[] args)
	{
		
	// practice 1
	String studentName = 	getStudentName(11);
	 System.out.println(studentName);
	 
	 //practice 2
	 int studentAge = getStudentAge(11);
	 System.out.println(studentAge);
	 
	 //practice 3
	 int studentGrade = getStudentGrade(1);
	 System.out.println(studentGrade);
	 
	 //practice 4
	 String topperName = getStudentNameForGrade(1,"maths");
	 System.out.println(topperName);
	 
	 //practice 5
	 int totalMarks = calculateTotalMarks(80,70);
	 System.out.println(totalMarks);
	 
	 //practice 6
	 double averageMarks = calculateAverageMarks(80,70,90);
	 System.out.println(averageMarks);
	 
	 //practice 7
	 boolean passed = isStudentPassed(72);
	 System.out.println(passed);
	 
	 // practice 8 
	 String studentResult = getStudentResult("Rahul",72);
	 System.out.println(studentResult);
	}
	static String getStudentName(int studentId)
	{
	  String name = "rahul";
	  return  name;
	}
	
	//age
	static int getStudentAge(int studentId)
	{
		int age = 20;
		return age;
	}
	
	//grade
	static int getStudentGrade(int studentId)
	{
		int grade = 10;
		return grade;
	}
	//studentnamefor grade
	static String getStudentNameForGrade(int grade,String subject)
	{
		String name = "sangeeta";
		return name;
	}
	//calculate
	static int calculateTotalMarks(int maths,int science)
	{
	  int total = maths + science;
	  return total;
	}
	//calculateAverageMarks
	static double calculateAverageMarks(int maths,int science,int english)
	{
		int total = maths + science + english;
		double average = (total/3);
		return average;
	}
	// student passed 
	static boolean isStudentPassed(int marks)
	{
		if(marks>=35)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	// student result
	static String getStudentResult(String studentName,int marks)
	{
		if(marks>=35)
		{
			return "rahul has passed";
		}
		else
		{
			return "rahul has failed";
		}
	}
}

