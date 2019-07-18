package HospitalManage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;
public class Doctor //implements Comparable<Doctor>
{
	 private String FirstName,LastName;
	    private String Designation;
	    List<Patient> PatList=new ArrayList<Patient>();
	    //Use hashmap
	    public Doctor(String FirstName,String LastName, String designation)
	    {
	        this.FirstName =FirstName;
	        this.LastName =LastName;
	        Designation = designation;
	    }

	    public String getFirstName()
	    {
	        return FirstName;
	    }

	    public String getLastName()
	    {
	    	return LastName;
	    }
	    
	    public String getDesignation()
	    {
	        return Designation;
	    }

	    public void getPatList()
	    {
	        Iterator itr=PatList.iterator();
	        while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }
	        PatList.clear();
	    }

	    public void AddPatientToDoc(Patient p1)
	    {
	        PatList.add(p1);
	    }



	    @Override
	    public String toString() {
	        return "Name of Doctor=" + LastName + " " + FirstName + " Designation='" + Designation +"\n";
	    }
}
