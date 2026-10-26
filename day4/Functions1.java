public class Functions1{

	public static void main(String []args)
	{
	
	  //var studentName = getTopperNameForSubjectGrade(1,"Maths");
	  //System.out.println(studentName);
		printStudentDetails(1);
		var totalCount = getTotalCountOfBoysGirls(2);

		System.out.println("Boys: " + totalCount[0]);
		System.out.println("Girls: " + totalCount[1]);
	}
			//who is the topper?
			//which subject?
			//which grade?
			//response name of the student
	
	static String getTopperNameForSubjectGrade( 
			int grade,String subject)
	{
			// dummy Implementation
			String name = "Sangeeta";
			return name;
	 } 
	 //Returns array in which at 0 index boys count is present and 1 index girlscount is presaent
 	static int[] getTotalCountOfBoysGirls(int schoolID)
	{
		//Dummy
		int[] results = {500,500};
		return results;
	}
	static void printStudentDetails(int studentsId)
	{
		//dummy
		String name = "Radha";
		int age = 18 ;
        int grade = 10;	
		float CGPA = 9.2f;
		boolean isReagularToschool = true;
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(grade);
		System.out.println(CGPA);
		System.out.println(isReagularToschool);
	}
}