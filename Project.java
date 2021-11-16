/*****************************************************************************************
                       AMBULANCE PROVIDANCE SYSTEM

Problem statement : JAVA program to take the patient to the nearest possible hospital
					using Dijkstra's Algorithm.
					Includes data of address in database using file management.

GROUP MEMBERS : 2411-MRUNMAYEE MANMADKAR
                2410-SEJAL MANGAVE
                2415-SANYUKTA MULEY
                2419-PRACHI NARLAWAR
                
DATA STRUCTURES : Graph & Algorithm,File Handling
******************************************************************************************/
package MiniDSA;
import java.util.*;
/*...........................................................................................................*/
public class Project     //Main Class
{
	public static void main(String[] args)
	{
		System.out.println("\n-----------------------------------------------------------------------------------------");
		System.out.println("|                                                                                       |");     //Displays Title of Project
		System.out.println("|      SWIFT AMBULANCE SERVICE aims to provide ambulance service at the quickest !      |");
		System.out.println("|     The Program enables to take the patient to the nearest possible hospital safely.  |");
		System.out.println("|                                                                                       |");
		System.out.println("-----------------------------------------------------------------------------------------\n");
		Scanner scan=new Scanner(System.in);   //creates object of scanner class
		Graph gra=new Graph();    //object of class Graph
		int ch;
		do
		{
		System.out.println("1.Company Admin\n2.Enter Patient Data\n3.EXIT");  //displays menu 
		System.out.print("Enter choice :");
		ch=scan.nextInt();
		switch(ch)    //switch case for chosen case
		{
		case 1:gra.Information();
			   gra.CreateGraph();    //function call
			   gra.displayAdjMat();
			break;
		case 2:gra.Accept();         //function call
			break;
		case 3:System.out.println("Exit");
		}
		}while(ch!=3);    //continues till choice is equal to 3 
	}
}
/*OUTPUT:
-----------------------------------------------------------------------------------------
|                                                                                       |
|      SWIFT AMBULANCE SERVICE aims to provide ambulance service at the quickest !      |
|     The Program enables to take the patient to the nearest possible hospital safely.  |
|                                                                                       |
-----------------------------------------------------------------------------------------

1.Company Admin
2.Enter Patient Data
3.EXIT
Enter choice :1

----------------------------------------------------
             Display of Adjacency matrix            
----------------------------------------------------
   | 0  1  2  3  4  5  6  7  8  9 H1 H2 H3 H4 H5
----------------------------------------------------
0  | 0  2  0  4  0  0  0  0  0  0  0  0  0  3  0  
1  | 2  0  0  0  0  0  0  0  2  0  0  4  0  5  0  
2  | 0  0  0  3  0  0  0  0  0  0  5  0  3  0  0  
3  | 4  0  3  0  2  0  0  0  0  0  0  2  0  0  0  
4  | 0  0  0  2  0  0  0  4  5  0  0  4  0  0  0  
5  | 0  0  0  0  0  0  0  4  0  0  3  0  0  0  2  
6  | 0  0  0  0  0  0  0  3  0  3  0  0  0  0  1  
7  | 0  0  0  0  4  4  3  0  0  3  3  0  0  0  0  
8  | 0  2  0  0  5  0  0  0  0  6  0  0  0  0  0  
9  | 0  0  0  0  0  0  3  3  6  0  0  0  6  0  0  
H1 | 0  0  5  0  0  3  0  3  0  0  0  0  0  4  0  
H2 | 0  4  0  2  4  0  0  0  0  0  0  0  0  0  0  
H3 | 0  0  3  0  0  0  0  0  0  6  0  0  0  0  0  
H4 | 3  5  0  0  0  0  0  0  0  0  4  0  0  0  0  
H5 | 0  0  0  0  0  2  1  0  0  0  0  0  0  0  0  
----------------------------------------------------

1.Company Admin
2.Enter Patient Data
3.EXIT
Enter choice :2

------------------------------------------------------------------------------
Enter your name : sarika
Enter your Address(Plot/Flat No.) : 23/f

0.Model Colony
1.Ideal Colony
2.FC Road
3.JM Road
4.Deccan
5.Karvenagar
6.Magarpatta
7.Hadapsar
8.Nanded City
9.Sinhagad Road

Enter your address Id : 3
Enter your Contact Number : 9876
Invalid Contact number !
Enter Valid Contact number : 
9876543216
------------------------------------------------------------------------------


------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 3 to City Hospital distance: 8
Patients Area : 3 to Newlife Hospital distance: 2
Patients Area : 3 to Ruby Hospital distance: 6
Patients Area : 3 to Ashwini Hospital distance: 7
Patients Area : 3 to Aditya Birla Hospital distance: 10

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds are not available in Newlife Hospital
As beds are available in Ruby Hospital
Ambulance is called from Company Itself
Patient will be taken to Ruby Hospital with distance : 6
------------------------------------------------------------------------------

Do you want to continue Yes-1 No-0 : 1

------------------------------------------------------------------------------
Enter your name : namita
Enter your Address(Plot/Flat No.) : 34

0.Model Colony
1.Ideal Colony
2.FC Road
3.JM Road
4.Deccan
5.Karvenagar
6.Magarpatta
7.Hadapsar
8.Nanded City
9.Sinhagad Road

Enter your address Id : 5
Enter your Contact Number : 987654334
Invalid Contact number !
Enter Valid Contact number : 
9876543212
------------------------------------------------------------------------------


------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 5 to City Hospital distance: 3
Patients Area : 5 to Newlife Hospital distance: 12
Patients Area : 5 to Ruby Hospital distance: 11
Patients Area : 5 to Ashwini Hospital distance: 7
Patients Area : 5 to Aditya Birla Hospital distance: 2

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds are available in Aditya Birla Hospital
Ambulance is called from Company Itself
Patient will be taken to Aditya Birla Hospital with distance : 2
------------------------------------------------------------------------------

Do you want to continue Yes-1 No-0 : 1

------------------------------------------------------------------------------
Enter your name : priya
Enter your Address(Plot/Flat No.) : 35/gh

0.Model Colony
1.Ideal Colony
2.FC Road
3.JM Road
4.Deccan
5.Karvenagar
6.Magarpatta
7.Hadapsar
8.Nanded City
9.Sinhagad Road

Enter your address Id : 7
Enter your Contact Number : 9876543214
------------------------------------------------------------------------------


------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 7 to City Hospital distance: 3
Patients Area : 7 to Newlife Hospital distance: 8
Patients Area : 7 to Ruby Hospital distance: 9
Patients Area : 7 to Ashwini Hospital distance: 7
Patients Area : 7 to Aditya Birla Hospital distance: 4

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds are available in City Hospital
Ambulance is called from Company Itself
Patient will be taken to City Hospital with distance : 3
------------------------------------------------------------------------------

Do you want to continue Yes-1 No-0 : 1

------------------------------------------------------------------------------
Enter your name : prachi
Enter your Address(Plot/Flat No.) : 87/b

0.Model Colony
1.Ideal Colony
2.FC Road
3.JM Road
4.Deccan
5.Karvenagar
6.Magarpatta
7.Hadapsar
8.Nanded City
9.Sinhagad Road

Enter your address Id : 8
Enter your Contact Number : 9876543214
------------------------------------------------------------------------------


------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 8 to City Hospital distance: 11
Patients Area : 8 to Newlife Hospital distance: 6
Patients Area : 8 to Ruby Hospital distance: 12
Patients Area : 8 to Ashwini Hospital distance: 7
Patients Area : 8 to Aditya Birla Hospital distance: 10

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds and ambulance is not available in Newlife Hospital
As beds are available in Ashwini Hospital but ambulance is not
Ambulance is called from Aditya Birla Hospital
Patient will be taken to Ashwini Hospital with distance : 7
------------------------------------------------------------------------------

Do you want to continue Yes-1 No-0 : 1

------------------------------------------------------------------------------
Enter your name : sejal
Enter your Address(Plot/Flat No.) : 67/hn

0.Model Colony
1.Ideal Colony
2.FC Road
3.JM Road
4.Deccan
5.Karvenagar
6.Magarpatta
7.Hadapsar
8.Nanded City
9.Sinhagad Road

Enter your address Id : 9
Enter your Contact Number : 9876543214
------------------------------------------------------------------------------


------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 9 to City Hospital distance: 6
Patients Area : 9 to Newlife Hospital distance: 11
Patients Area : 9 to Ruby Hospital distance: 6
Patients Area : 9 to Ashwini Hospital distance: 10
Patients Area : 9 to Aditya Birla Hospital distance: 4

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds and ambulance is not available in Aditya Birla Hospital
As no beds are available in Ruby Hospital only ambulance is called from this hospital
Patient will be taken to City Hospital with distance : 6
------------------------------------------------------------------------------

Do you want to continue Yes-1 No-0 : 1

------------------------------------------------------------------------------
Enter your name : kanika
Enter your Address(Plot/Flat No.) : 1p

0.Model Colony
1.Ideal Colony
2.FC Road
3.JM Road
4.Deccan
5.Karvenagar
6.Magarpatta
7.Hadapsar
8.Nanded City
9.Sinhagad Road

Enter your address Id : 6
Enter your Contact Number : 9876543213
------------------------------------------------------------------------------


------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 6 to City Hospital distance: 6
Patients Area : 6 to Newlife Hospital distance: 11
Patients Area : 6 to Ruby Hospital distance: 9
Patients Area : 6 to Ashwini Hospital distance: 10
Patients Area : 6 to Aditya Birla Hospital distance: 1

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds and ambulance is not available in Aditya Birla Hospital
As no beds are available in City Hospital only ambulance is called from this hospital
we are short of beds right now,we'll contact you as soon as beds are available
.
.
.
.
.
.

The beds are now available!

------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 6 to City Hospital distance: 6
Patients Area : 6 to Newlife Hospital distance: 11
Patients Area : 6 to Ruby Hospital distance: 9
Patients Area : 6 to Ashwini Hospital distance: 10
Patients Area : 6 to Aditya Birla Hospital distance: 1

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds and ambulance is not available in Aditya Birla Hospital
As no beds are available in City Hospital only ambulance is called from this hospital
Patient will be taken to Ruby Hospital with distance : 9
------------------------------------------------------------------------------

Do you want to continue Yes-1 No-0 : 1

------------------------------------------------------------------------------
Enter your name : shreya
Enter your Address(Plot/Flat No.) : 98/l

0.Model Colony
1.Ideal Colony
2.FC Road
3.JM Road
4.Deccan
5.Karvenagar
6.Magarpatta
7.Hadapsar
8.Nanded City
9.Sinhagad Road

Enter your address Id : 3
Enter your Contact Number : 9876543213
------------------------------------------------------------------------------


------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 3 to City Hospital distance: 8
Patients Area : 3 to Newlife Hospital distance: 2
Patients Area : 3 to Ruby Hospital distance: 6
Patients Area : 3 to Ashwini Hospital distance: 7
Patients Area : 3 to Aditya Birla Hospital distance: 10

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds are available in Newlife Hospital but ambulance is not
Ambulance is called from Ruby Hospital
Patient will be taken to Newlife Hospital with distance : 2
------------------------------------------------------------------------------

Do you want to continue Yes-1 No-0 : 1

------------------------------------------------------------------------------
Enter your name : hina
Enter your Address(Plot/Flat No.) : 98

0.Model Colony
1.Ideal Colony
2.FC Road
3.JM Road
4.Deccan
5.Karvenagar
6.Magarpatta
7.Hadapsar
8.Nanded City
9.Sinhagad Road

Enter your address Id : 19
Please choose a valid Area : 7
Enter your Contact Number : 9876543213
------------------------------------------------------------------------------


------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 7 to City Hospital distance: 3
Patients Area : 7 to Newlife Hospital distance: 8
Patients Area : 7 to Ruby Hospital distance: 9
Patients Area : 7 to Ashwini Hospital distance: 7
Patients Area : 7 to Aditya Birla Hospital distance: 4

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds and ambulance is not available in City Hospital
As beds and ambulance is not available in Aditya Birla Hospital
As no beds are available in Ashwini Hospital only ambulance is called from this hospital
we are short of beds right now,we'll contact you as soon as beds are available
.
.
.
.
.
.

The beds are now available!

------------------------------------------------------------------------------
                          SYSTEM END
------------------------------------------------------------------------------
From the chosen Patients area distances to Hospitals are as below
------------------------------------------------------------------------------
Patients Area : 7 to City Hospital distance: 3
Patients Area : 7 to Newlife Hospital distance: 8
Patients Area : 7 to Ruby Hospital distance: 9
Patients Area : 7 to Ashwini Hospital distance: 7
Patients Area : 7 to Aditya Birla Hospital distance: 4

------------------------------------------------------------------------------
PATIENTS STATUS
------------------------------------------------------------------------------
As beds and ambulance is not available in City Hospital
As beds and ambulance is not available in Aditya Birla Hospital
As no beds are available in Ashwini Hospital only ambulance is called from this hospital
Patient will be taken to Newlife Hospital with distance : 8
------------------------------------------------------------------------------

Do you want to continue Yes-1 No-0 : 0

1.Company Admin
2.Enter Patient Data
3.EXIT
Enter choice :3
Exit
*/