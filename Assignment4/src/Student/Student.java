package Student;

public class Student implements Comparable<Student> {

	private String sStudentID;
	private String sStudentName;
	private String sCourse;
	private Integer iGrade;
	
	public Student (String sStudentID, String sStudentName, String sCourse, Integer iGrade) {
		setsStudentID(sStudentID);
		setsStudentName(sStudentName);
		setsCourse(sCourse);
		setsGrade(iGrade);
	}

	public String getsStudentID() {
		return sStudentID;
	}

	public void setsStudentID(String sStudentID) {
		this.sStudentID = sStudentID;
	}

	public String getsStudentName() {
		return sStudentName;
	}

	public void setsStudentName(String sStudentName) {
		this.sStudentName = sStudentName;
	}

	public String getsCourse() {
		return sCourse;
	}

	public void setsCourse(String sCourse) {
		this.sCourse = sCourse;
	}

	public Integer getsGrade() {
		return iGrade;
	}

	public void setsGrade(Integer iGrade) {
		this.iGrade = iGrade;
	}

	@Override
	public int compareTo(Student o) {
		
			if (iGrade > o.getsGrade()) {
				return -1;
			} else if (iGrade.equals(o.getsGrade())) {
				return 0;
			} else {
				return +1;	
			}
	}
}
