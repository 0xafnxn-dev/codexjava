public class StudentsMarks 
{
    public static void main(String[] args)
    {
        //accepts students name
        String studentName = args[0];

        //accepts student marks
        int subjectOne = Integer.parseInt(args[1]);
        int subjectTwo = Integer.parseInt(args[2]);
        int subjectThree = Integer.parseInt(args[3]);

        System.out.println("Student Name : "+ studentName);

        int marks = subjectOne + subjectTwo + subjectThree ;

        double average = (marks/3.0);

        System.out.println("Total Marks : "+ marks);
        System.out.println("Total Average : "+ average);
    }
    
}
