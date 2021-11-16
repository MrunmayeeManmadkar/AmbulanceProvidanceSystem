package MiniDSA;

public class Info   //Node class for storing information of Areas and Hospitals
{
	int vertex_id;
	int Bed;
	boolean Ambulance_flag;
	Info(int id,int bed,boolean af)     //parameterized constructor includes vertex id,number of beds, availability of ambulance
	{
		this.vertex_id=id;                
		this.Bed=bed;
		this.Ambulance_flag=af;
	}
}
