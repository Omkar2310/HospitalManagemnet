package HospitalManage;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.io.*;
public class ClientReq 
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://10.10.11.163/te3237db","te3237","te3237");
		PreparedStatement ps=con.prepareStatement("insert into Doctor values(?,?,?,?)");
		PreparedStatement pat=con.prepareStatement("insert into Patient values(?,?,?,?,?,?)");
       String lname,fname,spl;//docs
       String nop,gen,disease,prescrip;
       int  age;
       Socket s=new Socket("localhost",9999);
	   DataOutputStream dout=new DataOutputStream(s.getOutputStream());
	   System.out.println("Connected to Server!!");
	   int key;
	   do
	   {
		   System.out.println("1.Enter Doctor data\n2.Enter Patient Data\n");
	       Scanner s1=new Scanner(System.in);
		   key=s1.nextInt();
		   
		   switch(key)
		   {
		   case 1:
			   System.out.println("Enter Details of Doctors");
			  		       
			   System.out.println("Enter Last Name of Doctor");
		       lname=s1.next();
		       	ps.setString(2,lname);
				
				
		       System.out.println("Enter First Name of Doctor");
		       fname=s1.next();
		       ps.setString(3,fname);
		       
		       System.out.println("Enter Speciality");
		       spl=s1.next();
		       ps.setString(4,spl);
		      
		       System.out.println("Enter id");
		       int id=s1.nextInt();
		       ps.setInt(1,id);
		       
		       int i=ps.executeUpdate();
		       System.out.println("Recorde inserted " + i);

			   dout.writeUTF("doc");
		       dout.writeUTF(lname);
		       dout.writeUTF(fname);
		       dout.writeUTF(spl);
		       dout.writeInt(id);
		       dout.flush();
			   dout.close();
			   break;
			   
		   case 2:
			   System.out.println("Enter Details of Patient");
		       
			   System.out.println("Enter ID");
		       int pid=s1.nextInt();
			   pat.setInt(1,pid);
		       
		       System.out.println("Enter Name of Patient");
		       nop=s1.next();
		       pat.setString(2,nop);
		       
		       System.out.println("Enter Gender");
		       gen=s1.next();
		       pat.setString(3,gen);
		       
		       
		       System.out.println("Enter Age");
		       age=s1.nextInt();
		       pat.setInt(4,age);
		       
		       System.out.println("Enter disease");
		       disease=s1.next();
		       pat.setString(5,disease);
		       
		       System.out.println("Enter Prescription");
		       prescrip=s1.next();
		       pat.setString(6,prescrip);

		       int j=pat.executeUpdate();
		       System.out.println("Record inserted " + j);
		       
		       dout.writeUTF("pat");
		       dout.writeUTF(nop);
		       dout.writeUTF(gen);
		       dout.writeUTF(disease);
		       dout.writeUTF(prescrip);
		       dout.writeInt(age);
		       dout.writeInt(pid);
		       dout.flush();
			   dout.close();
			   break;
			   
		   }
	   }while(key!=0);
	   s.close();

	   
	}

}