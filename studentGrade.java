/**
 Create a class called Student which has two attributes, name and final grades.
 Create multiple instances of the Student class with name and final grade. Use
 Quick sort to sort the objects by final grades. The array of students,
 Student [] students,  should contain sorted student objects by final grades.
 */

import java.util.*;

public class studentGrade {

    public static void main(String[] args)
    {
        student []studentCollection = new student[5];
        for (int i = 0; i < studentCollection.length; i++)
        {
            studentCollection[i] = new student();
            studentCollection[i].name = inputName();
            inputGrade (studentCollection[i].grade);
            bubbleSorting(studentCollection[i].grade);
            studentCollection[i].finalGrade = finalGrade(studentCollection[i].grade);

        }

        quickSort(studentCollection,0,studentCollection.length-1);

        for (int i=0 ; i < studentCollection.length; i++)
        {
            System.out.println(studentCollection[i].name);
            System.out.println(studentCollection[i].name + "'grades" );
            displayGrade(studentCollection[i].grade);
            System.out.println();
            System.out.println(studentCollection[i].finalGrade);

        }

    }


    public static void displayGrade (int [] studentGrade)
    {
        for (int i = 0; i < studentGrade.length; i++)
        {
            System.out.print( studentGrade[i] + "\t");
        }
    }

    public static String inputName ()
    {
        Scanner input = new Scanner(System.in);
            System.out.println("Please enter the name of student number: ");
            String studentName = input.nextLine();
            return studentName;
    }

    public static void inputGrade (int []studentGrade)
    {

        Random random = new Random();
        for (int i = 0; i < studentGrade.length; i++)
        {
            studentGrade[i] = random.nextInt(100 - 0 + 1) + 0;
        }
    }

    public static void bubbleSorting (int [] unsortGrade)
    {
//        System.out.println("Before sorting: ");
//        displayGrade(unsortGrade);
//        System.out.println();

        int temp;
        for (int nextNumber = 0; nextNumber < unsortGrade.length; nextNumber++)
        {
            for (int compare2Number = 0; compare2Number < ((unsortGrade.length - 1) - nextNumber); compare2Number++)
            {
                if (unsortGrade[compare2Number] > unsortGrade[compare2Number+1])
                {
                    temp = unsortGrade[compare2Number];
                    unsortGrade[compare2Number] = unsortGrade[compare2Number+1];
                    unsortGrade[compare2Number + 1] = temp;
                }
            }
        }
//        System.out.println("After sorting: ");
//        displayGrade(unsortGrade);
//        System.out.println();
    }

    public static int partition(student [] studentCollection, int left, int right)
    {
        int i = left, j = right;
        student pivot = studentCollection[(left + right) / 2];

        while (i <= j) {
            while (studentCollection[i].finalGrade < pivot.finalGrade)
                i++;
            while (studentCollection[j].finalGrade > pivot.finalGrade)
                j--;
            if (i <= j) {
                pivot = studentCollection[i];
                studentCollection[i] = studentCollection[j];
                studentCollection[j] = pivot;
                i++;
                j--;
            }
        }

        return i;
    }

    public static void quickSort(student averageGrade[], int left, int right)
    {
        int index = partition(averageGrade, left, right);
        if (left < index - 1)
        {
            quickSort(averageGrade, left, index - 1);
        }
        if (index < right)
        {
            quickSort(averageGrade, index, right);
        }
    }

    public static int finalGrade (int [] studentGrade)
    {
        int sum = 0;
        for (int i = 0; i < studentGrade.length; i++)
            sum = sum + studentGrade[i];

        return sum/studentGrade.length;
    }
}
