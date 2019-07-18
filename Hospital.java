package HospitalManage;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Hospital
{
    Scanner s1=new Scanner(System.in);
    TreeSet<Doctor> DoctorList=new TreeSet<Doctor>(new Comparator<Doctor>() {
        public int compare(Doctor s1, Doctor s2) {
            return s1.getLastName().compareToIgnoreCase(s2.getLastName());
        }
    });
    HashMap<Integer,String> DocList=new HashMap<Integer,String>();
    HashMap<Integer,String> PatList=new HashMap<Integer,String>();
    PriorityQueue<Patient> PatientList=new PriorityQueue<Patient>();
    public String HospitalName;
    public Hospital(String hospitalName)
    {
        HospitalName = hospitalName;
    }


    public void AddPatients(int id,Patient p)
    {
        PatientList.add(p);
        PatList.put(id,p.getName());
    }

    public void AddDoctors(int id,Doctor d)
    {
        DoctorList.add(d);
        DocList.put(id,d.getFirstName());
    }
    
    public void getDoctorList()
    {
        Iterator itr=DoctorList.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }

    public void getDocListwithID()
    {
    	for(Map.Entry dm : DocList.entrySet())
    	{
    		System.out.println(dm.getKey() + " " + " " + dm.getValue());
    	}
    }
    public void getPatientList()
    {
        Iterator itr=PatientList.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }

    //Assign Doctor to a patient
    public void AssignDoctors()
    {
        for(Patient x: PatientList)
        {
            for(Doctor y:DoctorList)
            {
                if(x.getDisease().equalsIgnoreCase("Eye"))
                {
                    if(y.getDesignation().equals("Opthamologist"))
                    {
                        y.AddPatientToDoc(x);
                        break;
                    }
                }
                if(x.getDisease().equalsIgnoreCase("Heart"))
                {
                    if(y.getDesignation().equals("Surgeon"))
                    {
                        y.AddPatientToDoc(x);
                        break;
                    }
                }
                
                if(x.getDisease().equalsIgnoreCase("Headache"))
                {
                    if(y.getDesignation().equals("Neurologist"))
                    {
                        y.AddPatientToDoc(x);
                        break;
                    }
                }


                if(x.getDisease().equalsIgnoreCase("Ears") || x.getDisease().equalsIgnoreCase("Nose") || x.getDisease().equalsIgnoreCase("Throat"))
                {
                    if(y.getDesignation().equals("ENT"))
                    {
                        y.AddPatientToDoc(x);
                        break;
                    }
                }

                if(x.getDisease().equalsIgnoreCase("Pregnancy") || x.getDisease().equalsIgnoreCase("Female"))
                {
                    if(y.getDesignation().equalsIgnoreCase("Gyanacologist"))
                    {
                        y.AddPatientToDoc(x);
                        break;
                    }
                }
                
                if(x.getDisease().equalsIgnoreCase("Diet") || x.getDisease().equalsIgnoreCase("Weightloss"))
                {
                    if(y.getDesignation().equals("Dietician"))
                    {
                        y.AddPatientToDoc(x);
                        break;
                    }
                }
                
                if(x.getDisease().equalsIgnoreCase("Skin"))
                {
                    if(y.getDesignation().equals("Dermatologist"))
                    {
                        y.AddPatientToDoc(x);
                        break;
                    }
                }
                
            }
        }
    }
    
    public void ShowDocPat()
    {
    	Iterator itr=DoctorList.iterator();
    	while(itr.hasNext())
    	{
    		Doctor d1=(Doctor)itr.next();
    		System.out.println("Dr."+d1.getLastName() + " " + d1.getFirstName());
    		d1.getPatList();
    	}
    }
  
    
    //Search a doctor and show his patients;
    public void SearchDocShowPat(int id)
    {
    	if(DocList.containsKey(id))
    	{
    		System.out.println(DocList.get(id));
    	}
    }
}
