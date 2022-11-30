import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Doctor {

    public Doctor(String firstName, String lastName, String speciality, boolean isAvailable) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.isAvailable = isAvailable;
    }

    public static final List<String> firstNames = new ArrayList<>(Arrays.asList(
            "John","Mike","Alex","Anna","Valentina","Jane","Islamjon","Olena","Matthew"
    ));
    public static final List<String> lastNames = new ArrayList<>(Arrays.asList(
            "Doe","Margo","Sunflower","Smith","Potter","Washington","Carma","Franklin","Biden"
    ));

    public String firstName;
    public String lastName;
    public String speciality;
    public boolean isAvailable;

    public static Doctor gerDoctor(String problem){

        problem = problem.toLowerCase();

        int randomIndexForFirstName = RandomNumberGenerator.getRandomNumber(0,firstNames.size()-1);
        String firstName = firstNames.get(randomIndexForFirstName);

        int randomIndexForLastName = RandomNumberGenerator.getRandomNumber(0,lastNames.size()-1);
        String lastName = lastNames.get(randomIndexForFirstName);

        String speciality = "";
        if(problem.contains("emergency") || problem.contains("life") || problem.contains("threat")) speciality = "ER";
        else if(problem.contains("heart")) speciality = "Cardiologist";
        else if(problem.contains("ear") || problem.contains("throat") || problem.contains("nose")) speciality = "ENT";
        else if(problem.contains("eye") || problem.contains("see")) speciality = "Ophthalmologist";
        else if(problem.contains("skin")) speciality = "Dermatologist";
        else speciality = "PCP";

        return new Doctor(firstName,lastName,speciality,true);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(gerDoctor("My heart is hurting"));
        System.out.println(gerDoctor("I cannot see!"));
        System.out.println(gerDoctor("My life is in danger"));
        System.out.println(gerDoctor("My nose is bleeding"));
    }
}
