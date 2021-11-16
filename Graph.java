package MiniDSA;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*.....................................................................................................*/
public class Graph  //Graph class for all the methods
{
	Scanner sc=new Scanner(System.in);
	int vertices;        //number of vertices i.e areas and hospitals
	int edges;       //number of edges  i.e is roads between areas and hospitals
	Info info[]=new Info[30];     //creating object of class info
	int adjMat[][]=new int[20][20]; //adjacency matrix of the graph
	String Hospitals[]=new String[30];
	int temp_distance[]=new int[30];    //distance array
	int hos[]=new int[30];
	int Patient;
	int flag=0;
	int counter=0;
	int add;

	/*.....................................................................................................*/
	Graph()    //Constructor 
	{
		vertices = 15;     //initializing vertices and edges
		edges = 25;
		Patient=0;        
		Hospitals[1]="City Hospital";
		Hospitals[2]="Newlife Hospital";
		Hospitals[3]="Ruby Hospital";
		Hospitals[4]="Ashwini Hospital";
		Hospitals[5]="Aditya Birla Hospital";
	}
	/*.....................................................................................................*/
	void Information()         //initializing id of areas and beds and ambulance of hospitals
	{
		for(int i=0;i<10;i++)
		{
			info[i]=new Info(i,0,false);
		}
		info[10]=new Info(10,2,false);
		info[11]=new Info(11,0,false);
		info[12]=new Info(12,1,false);
		info[13]=new Info(13,1,false);
		info[14]=new Info(14,1,false);
	}
	/*.....................................................................................................*/
	void create(int source,int destination,int weight)    //create adjacency matrix			//O(1)
	{
		adjMat[source][destination]=weight;      
		adjMat[destination][source]=weight;    
	}
	/*.....................................................................................................*/
	void CreateGraph()     //creation of graph which includes areas and hospitals as vertices and roads in between as edges 	//O(1)
	{
		create(1,0,2);
		create(1,8,2);
		create(8,9,6);
		create(9,6,3);
		create(6,14,1);
		create(14,5,2);
		create(5,10,3);
		create(10,13,4);
		create(13,0,3);
		create(0,3,4);
		create(1,13,5);
		create(1,11,4);
		create(8,4,5);
		create(11,3,2);
		create(3,2,3);
		create(2,10,5);
		create(11,4,4);
		create(3,4,2);
		create(2,12,3);
		create(10,7,3);
		create(7,5,4);
		create(7,6,3);
		create(7,9,3);
		create(4,7,4);
		create(9,12,6);
	}
	/*.....................................................................................................*/
	void displayAdjMat()   //Display of adjacency matrix		//O(V^2)
	{
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("             Display of Adjacency matrix            ");
		System.out.println("----------------------------------------------------");
		System.out.println("   | 0  1  2  3  4  5  6  7  8  9 H1 H2 H3 H4 H5");
		System.out.println("----------------------------------------------------");
		for(int i=0;i<vertices;i++)                                    //till all the vertices are covered
		{
			if(i<10)
			{
				System.out.print(i+"  | ");
				for(int j=0;j<vertices;j++)                               //till all the areas are covered
				{
					System.out.print(adjMat[i][j]+"  ");
				}
				System.out.println();
				}
			else
			{
				System.out.print("H"+(i-9)+" | ");                           //till all the hospitals are covered
				for(int j=0;j<vertices;j++)
				{
					System.out.print(adjMat[i][j]+"  ");
				}
				System.out.println();
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println();
	}
	/*.....................................................................................................*/
	int getMinimumVertex(boolean [] set, int [] key)       //to get the vertex with shortest distance from the source		//O(V)
	{
	       int minKey = Integer.MAX_VALUE;
	       int vertex = -1;
	       for (int i = 0; i <vertices ; i++)     //till all the vertices are covered
	       {
	           if(set[i]==false && minKey>key[i])      //to find the minimum 
	           {
	               minKey = key[i];
	               vertex = i;         //get the vertex with minimum distance
	           }
	       }
	       return vertex;
	}
	/*.....................................................................................................*/
	void dijkstra_GetMinDistances(int sourceVertex)       //Dijkstra's algorithm to find the shortest distance from areas to hospitals		//O(V^2)
	{
		   boolean[] set = new boolean[vertices];
		   int [] distance = new int[vertices];
		   int INFINITY = Integer.MAX_VALUE;
		   for (int i = 0; i <vertices ; i++)  
		   {
		    distance[i] = INFINITY;    //Initializing all distances to infinity 
		   }
		   distance[sourceVertex] = 0;
		   for (int i = 0; i <vertices ; i++)    //till all the vertices are covered
		   {
		
			   int vertex_U = getMinimumVertex(set, distance);   //function call to get the vertex with shortest distance from the source
		       set[vertex_U] = true;                           			//set the visited vertex as true
		       for (int vertex_V = 0; vertex_V <vertices ; vertex_V++)
		       {
		    	   if(adjMat[vertex_U][vertex_V]>0)                   //check whether the vertex_u and vertex_v adjacent to each other 
		           {
		    		   if(set[vertex_V]==false && adjMat[vertex_U][vertex_V]!=INFINITY)  //check if the vertex_v is not visited
		               {
		    			   int newKey =  adjMat[vertex_U][vertex_V] + distance[vertex_U];  //calculation of shortest distances
		                   if(newKey<distance[vertex_V])  //if the new key is shortest then set the distance of vertex_v from source
		                   {
		                	   distance[vertex_V] = newKey;        
		                   }
		               }
		           }
		       }
		   	}
		    printDijkstra(sourceVertex, distance);   //function call 
	}
	/*.....................................................................................................*/
	void printDijkstra(int sourceVertex, int [] distance)  //function to print the source and destinations with its corresponding shortest distance //O(V)
	{
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("                          SYSTEM END");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("From the chosen Patients area distances to Hospitals are as below");
		System.out.println("------------------------------------------------------------------------------");
	   for (int i = 10; i <vertices ; i++)    //prints the shortest distance from patients given area to all the hospitals
	   {	   
		   System.out.println("Patients Area : " + sourceVertex + " to " +Hospitals[i-9]+" distance: " + distance[i]);
	   }
	   Search_Min(distance);   //function call
	}
	/*.....................................................................................................*/
	void sort(int [] distance)   //O(n^2)
	{
		int flag=0;
		int temp;
		for(int i=10;i<vertices;i++)  
		{
			temp_distance[i]=distance[i];
		}
		for(int i=10;i<vertices-1;i++)    //bubble sort to sort the distances
		{
			flag=0;
			for(int j=10;j<vertices-1;j++)
			{
				if(temp_distance[j]>temp_distance[j+1])
				{
					temp=temp_distance[j];
					temp_distance[j]=temp_distance[j+1];
					temp_distance[j+1]=temp;
					flag=1;
				}
			}
			if(flag==0)
			{
				break;
			}
		}
		System.out.println();
	}
	/*.....................................................................................................*/
	void Search_Min(int []distance)   //O(V^2)
	{
		sort(distance);
		for (int i = 10; i <vertices ; i++)
		{
			for (int j = 10; j <vertices ; j++)
			{
				if(temp_distance[i]==distance[j] && hos[i-1]!=j-9)
					hos[i]=j-9;
			}
		}		
		if(Patient<4)         //initially 3 ambulances are present in company
		{
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("PATIENTS STATUS");
			System.out.println("------------------------------------------------------------------------------");
			chk_availability1(10);
		}
		else
		{
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("PATIENTS STATUS");
			System.out.println("------------------------------------------------------------------------------");
			chk_availability(10);
		}
	}
	/*.....................................................................................................*/
	void chk_availability1(int i)   //to check if beds are available or not		//O(1)
	{
		if(info[hos[i]+9].Bed!=0)   //if beds are available in hospital with shortest distance patient will be moved to that hospital
		{
			System.out.println("As beds are available in "+Hospitals[hos[i]]);
			System.out.println("Ambulance is called from Company Itself");
			System.out.println("Patient will be taken to "+Hospitals[hos[i]]+" with distance : "+temp_distance[i]);
			info[hos[i]+9].Bed--;
			info[hos[i]+9].Ambulance_flag=true;
		}
		else if(info[hos[i]+9].Bed==0)   //if the beds are not available in shortest distance hospital it will check for second shortest distance hospital
		{
			System.out.println("As beds are not available in "+Hospitals[hos[i]]);
			chk_availability1(i+1);
			return;
		}
	}
	/*.....................................................................................................*/
	void chk_availability(int i)  //to check if beds and ambulance is available in hospital 		//O(n)
	{
		int index=0;
		if(info[hos[i]+9].Bed!=0 && info[hos[i]+9].Ambulance_flag==true)  //if bed and ambulance is available in hospital 
		{
			System.out.println("As beds and ambulance is available in "+Hospitals[hos[i]]);
			System.out.println("Patient will be taken to "+Hospitals[hos[i]]+" with distance : "+temp_distance[i]);
			info[hos[i]+9].Bed--;
			info[hos[i]+9].Ambulance_flag=true;
		}
		else if(info[hos[i]+9].Bed==0 && info[hos[i]+9].Ambulance_flag==true)	//if bed is not available but ambulance is present
		{
			int flag1=0;
			System.out.println("As no beds are available in "+Hospitals[hos[i]]+" only ambulance is called from this hospital");
			
			for(int j=i+1;j<15;j++)
			{
				if(info[hos[j]+9].Bed!=0)
				{
					System.out.println("Patient will be taken to "+Hospitals[hos[j]]+" with distance : "+temp_distance[j]);
					info[hos[j]+9].Bed--;
					info[hos[j]+9].Ambulance_flag=true;
					index=j;
					flag1=1;
					break;
					
				}
			}
			if(flag1==0)
			{
				System.out.println("we are short of beds right now,we'll contact you as soon as beds are available");
				flag=1;
				System.out.println(".");
				System.out.println(".");
				System.out.println(".");
				System.out.println(".");
				System.out.println(".");
				System.out.println(".");
				update();
				dijkstra_GetMinDistances(add);

			}
			else
			{
				info[hos[i]+9].Ambulance_flag=false;
			}
			return;
		}
		else if(info[hos[i]+9].Bed!=0 && info[hos[i]+9].Ambulance_flag==false)	//if bed is present but ambulace is not
		{
			System.out.println("As beds are available in "+Hospitals[hos[i]]+" but ambulance is not");
			info[hos[i]+9].Bed--;
		    index=0;
			for(int j=11;j<15;j++)
			{
				if(info[hos[j]+9].Ambulance_flag==true)
				{
					info[hos[j]+9].Ambulance_flag=false;
					index=j;
					break;
				}
			}
			System.out.println("Ambulance is called from "+Hospitals[hos[index]]);
			System.out.println("Patient will be taken to "+Hospitals[hos[i]]+" with distance : "+temp_distance[i]);
			info[hos[i]+9].Ambulance_flag=true;
			return;
		}
		else if(info[hos[i]+9].Bed==0 && info[hos[i]+9].Ambulance_flag==false)  //bed and ambulance is not available
		{
			System.out.println("As beds and ambulance is not available in "+Hospitals[hos[i]]);
			chk_availability(i+1);
			return;
		}
	}
	/*.....................................................................................................*/
	void update()			//O(1)
	{
		
		flag=0;
		System.out.println("\nThe beds are now available!");
		info[11].Bed++;
		info[12].Bed++;		
	}
	/*.....................................................................................................*/
	void file_Menu()    //file creation,read and write		//O(n)
	{
		//create
		File myFile = new File("Menu.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create this file");
            e.printStackTrace();
        }

        // write 
        try {
            FileWriter fileWriter = new FileWriter("Menu.txt");
            fileWriter.write("\n0.Model Colony\n1.Ideal Colony\n2.FC Road\n3.JM Road\n4.Deccan\n5.Karvenagar\n6.Magarpatta\n7.Hadapsar\n8.Nanded City\n9.Sinhagad Road");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading
        try {
            Scanner sc = new Scanner(myFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	/*.......................................................................................................*/
	void Accept()  //accept information of patients		//O(n)
	{
		int choice=0;
		do
		{
			String Name,Address;
			String contactNo;
			int flag2=1;
			System.out.println("\n------------------------------------------------------------------------------");
			System.out.print("Enter your name : ");  			//get patients details
			Name=sc.next()+sc.nextLine();
			System.out.print("Enter your Address(Plot/Flat No.) : ");
			Address=sc.next()+sc.nextLine();
			file_Menu();
			System.out.print("\nEnter your address Id : ");		
			add=sc.nextInt();
			while(add>9 || add<0)						//address validation
			{
				System.out.print("Please choose a valid Area : ");
				add=sc.nextInt();
			}
			System.out.print("Enter your Contact Number : ");
			contactNo=sc.next()+sc.nextLine();
			while(flag2!=0)												//Contact number validation
	        {
	            if((contactNo.length()==10) && (contactNo.charAt(0)=='9' || contactNo.charAt(0)=='8' || contactNo.charAt(0)=='7'))
	            {
	                flag2=0;
	            }
	            else
	            {
	            	System.out.println("Invalid Contact number !");
	            	System.out.println("Enter Valid Contact number : ");
	    			contactNo=sc.next()+sc.nextLine();	  
	            }
	        }
			System.out.println("------------------------------------------------------------------------------\n");
			Patient++;
			dijkstra_GetMinDistances(add);				//function call
			System.out.println("------------------------------------------------------------------------------\n");
			System.out.print("Do you want to continue Yes-1 No-0 : ");
			choice=sc.nextInt();
			
		}while(choice!=0 && flag==0);
		
		System.out.println();
	}
}
