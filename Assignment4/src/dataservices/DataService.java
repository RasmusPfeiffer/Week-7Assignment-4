package dataservices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import Student.Student;

public class DataService {

	String sData;
	int i = 0;
	Student[] aCOMPSCI = new Student[50];
	Student[] aAPMTH = new Student[50];
	Student[] aSTAT = new Student[50];
	Student[] aStudents = new Student[200];
	int iComp = 0;
	int iApm = 0;
	int iStat = 0;
	Integer iGrade;

	// reads data and fills Array
	public Student[] dataService(String sFilename) throws IOException {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(sFilename));
			while ((sData = reader.readLine()) != null) {
				String[] aTemporary = sData.split(",");
				if (i >= 1) {
					this.iGrade = Integer.parseInt(aTemporary[3]);
					Student oNewStudent = new Student(aTemporary[0], aTemporary[1], aTemporary[2], iGrade);
					aStudents[i] = oNewStudent;
				}
				i++;
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return aStudents;
	}

	// sorts cleaned Array
	public Student[] sort() {
		Arrays.sort(aStudents);
		return aStudents;
	}

	// split sorted arrays
	public void splitSortedArray() throws IOException {
		this.i = 0;
		for (int i = 0; i < aStudents.length - 1; i++) {
			while (aStudents[i] != null) {
				if (aStudents[i].getsCourse().contains("COMPSCI")) {
					aCOMPSCI[iComp] = aStudents[i];
					iComp++;
					break;
				} else if (aStudents[i].getsCourse().contains("APMTH")) {
					aAPMTH[iApm] = aStudents[i];
					iApm++;
					break;
				} else {
					aSTAT[iStat] = aStudents[i];
					iStat++;
					break;
				}
			}
		}
	}

	// remove null values
	public Student[] cleanArrayFromNull() {
		int count = -1;
		Student[] aPlaceholder = new Student[aStudents.length];
		for (Student oSort : aStudents) {
			if (oSort != null) {
				aPlaceholder[++count] = oSort;
			}
			aStudents = Arrays.copyOf(aPlaceholder, count + 1);
		}
		return aStudents;
	}

	// writes Arrays to files
	public void write() throws IOException {
		this.dataWriter(aCOMPSCI, "course1.csv");
		this.dataWriter(aAPMTH, "course2.csv");
		this.dataWriter(aSTAT, "course3.csv");
	}

	public void dataWriter(Student[] arrayName, String sFilename) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(sFilename));
			writer.write("StudentID,Student Name,Course,Grade\n");
			for (int i = 0; i <= arrayName.length - 1; i++) {
				if (arrayName[i] != null) {
					writer.write(arrayName[i].getsStudentID() + "," + arrayName[i].getsStudentName() + ","
							+ arrayName[i].getsCourse() + "," + arrayName[i].getsGrade() + "\n");
				} 
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}