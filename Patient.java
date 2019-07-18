package HospitalManage;
public class Patient implements Comparable<Patient>
{
    private String Name;
    private String Gender;
    private int PatientAge;
    private String Disease;
    private String Prescrip;
    public Patient(String name, String gender, int patientAge, String disease,String prescrip) {
        Name = name;
        Gender = gender;
        PatientAge = patientAge;
        Disease = disease;
        Prescrip=prescrip;
    }

    public String getName() {
        return Name;
    }

    public String getDisease() {
        return Disease;
    }

    public int getPatientAge() {
        return PatientAge;
    }

    @Override
    public String toString() {
        return "Patient" +
                "Name=" + Name +
                ", Gender=" + Gender +
                ", PatientAge=" + PatientAge +
                ", Disease=" + Disease + "Prescription=" + Prescrip +"\n";
    }

	public int compareTo(Patient o) {
		// TODO Auto-generated method stub
		if(PatientAge>o.PatientAge)
		{
			return -1;
		}
		else if(PatientAge<o.PatientAge)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
}

