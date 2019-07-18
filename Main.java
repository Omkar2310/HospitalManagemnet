package HospitalManage;
import HospitalManage.Hospital;

import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://10.10.11.163/te3237db","te3237","te3237");
        Hospital h=new Hospital("Shrirampur Rural Hospital");
        Doctor d[]=new Doctor[4];
        Patient p[]=new Patient[4];
        String lname="",fname="",spl="";	//for lname,fname,designation
        String nop="",gen="",disease="",precrip="";
        int age=-1;
        int a;
        int id=-1,idp=-1;
        int pno=0;
        do
          {
  
     	   System.out.println("1.Accept Data From Client\n2.Show Doctors Alphabetically\n3.Show Doctors with ID\n4.Show Patients\n5.Show Doctors and Patients"
     	   		+ "6.Show Doctor Database\n 7.Show Patient database");
           Scanner s = new Scanner(System.in); 
     	   a=s.nextInt();
            switch (a)
            {
                case 1:
                    System.out.println("Waiting for Client to Connect....");
                	ServerSocket ss=new ServerSocket(9999);
                    Socket s1=ss.accept();
                    DataInputStream din=new DataInputStream(s1.getInputStream());
                    String sig=din.readUTF();
                    int flag=-1;
                    if(sig.equals("doc"))
                    {
                    	flag=0;
                    	
                    	lname=din.readUTF();
                    	fname=din.readUTF();
                    	spl=din.readUTF();
                    	id=din.readInt();
                    }
                    if(sig.equals("pat"))
                    {
                    	flag=1;
                    	nop=din.readUTF();
                    	gen=din.readUTF();
                    	disease=din.readUTF();
                    	precrip=din.readUTF();
                    	age=din.readInt();
                    	idp=din.readInt();
                    }
                    if(flag==0)
                    {
                    	for(int i=0;i<4;i++)
                    	{                	
                    		d[i]=new Doctor(lname,fname,spl);
                    		h.AddDoctors(id,d[i]);
                    	}
                    }
                    else
                    {
                    	
                        {
                        p[pno]=new Patient(nop,gen,age,disease,precrip);
                        h.AddPatients(id,p[pno]);
                        pno++;
                        }
                    }
                	 ss.close();
                     s1.close();
                    break;

                case 2:
                    h.getDoctorList();
                    break;
                case 3:
                	h.getDocListwithID();break;
                 case 4:
                    h.getPatientList();
                    break;
                case 5:
                    h.AssignDoctors();
                    h.ShowDocPat();
                	break;
                case 6:
                	Statement st=con.createStatement();
            		ResultSet rs=st.executeQuery("Select * from Doctor");
            		while(rs.next())
            		{
            			System.out.println( rs.getInt(1) +"\t" +rs.getString(2) + "\t" +rs.getString(3) + "\t" +rs.getString(4) + "\t");
            		}
            		con.close();
            		break;
                case 7:
                	Statement st1=con.createStatement();
            		ResultSet rs1=st1.executeQuery("Select * from Patient");
            		System.out.println("PID \t Name \t Gender \t Age \t  Disease \t Prescription \t");
            		while(rs1.next())
            		{
            			System.out.println( rs1.getInt(1) +"\t" +rs1.getString(2) + "\t" +rs1.getString(3) + "\t"+ rs1.getInt(4)  + "\t" +rs1.getString(5) + "\t"+rs1.getString(6) + "\t");
            		}
            		con.close();
            		break;
                	
                case 8:
                	
            }
          }while (a!=0);
    }


}