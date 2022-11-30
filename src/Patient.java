public class Patient {

    public Patient(String problem, String firstName, String lastName, String dateOfBirth, boolean hasInsurance) {
        this.problem = problem;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.hasInsurance = hasInsurance;
    }

    public static final String askProblem = "What are your symptoms?";
    public static final String askFirstName = "What are your first name?";
    public static final String askLastName = "What are your last name?";
    public static final String askDateOfBirth = "What are your date of birth?";
    public static final String askDateOfBirthAgain = "Date of birth is invalid please enter a valid date? mm/dd/yyyy";
    public static final String askInsurance = "Do you have insurance?";


    public String problem;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean hasInsurance;
    public Doctor patientDoctor;

    public static Patient createPatient(){
        String problem = ScannerHelper.getString(askProblem);
        if(problem.contains("emergency") || problem.contains("life") || problem.contains("threat")){
            System.out.println(QuestionsAndMessages.emergencyMessage);
            return new Patient(problem,"ER patient","N/A","N/A",false);
        }
        String firstName = ScannerHelper.getString(askFirstName);
        String lastName = ScannerHelper.getString(askLastName);
       String dateOfBirth = ScannerHelper.getString(askDateOfBirth);

       while (!isDateOfBirthValid(dateOfBirth)){
           dateOfBirth = ScannerHelper.getString(askDateOfBirthAgain);
       }
       boolean hasInsurance = ScannerHelper.getString(askInsurance).toUpperCase().startsWith("Y");
       if(!hasInsurance) System.out.println(QuestionsAndMessages.noInsuranceMessage);
       return new Patient(problem,firstName,lastName,dateOfBirth,hasInsurance);
   }

    public static boolean isDateOfBirthValid(String dateOfBirth) {

        //(0[1-9]|1[0-2])(\/)(0[1-9]|[1-2][0-9]|3[0-1])(\/)(19[0-9]{2}|20[0-1][0-9]|202[0-2])
        // mm/dd/yyyy
        // 1-12/1-31/1900+ - 2022
        String[] digits = dateOfBirth.split("/");

        String mm = digits[0];
        // validation for checking the characters are only digits
        for (int i = 0; i < mm.length(); i++) {
            if (!Character.isDigit(mm.charAt(i))) return false;
        }
        // validation of 1- 12
        int mmInt = Integer.parseInt(mm); // converting String into an int variable
        if (mmInt < 1 || mmInt > 12) return false;
        // validation of the length 2
        if (mm.length() != 2) return false;

        String dd = digits[1];
        // validation for checking the characters are only digits
        for (int i = 0; i < dd.length(); i++) {
            if (!Character.isDigit(dd.charAt(i))) return false;
        }
        // validation of 1- 31
        int ddInt = Integer.parseInt(dd); // converting String into an int variable
        if (ddInt < 1 || ddInt > 31) return false;
        // validation of the length 2
        if (dd.length() != 2) return false;

        String yyyy = digits[2];
        for (int i = 0; i < yyyy.length(); i++) {
            if (!Character.isDigit(yyyy.charAt(i))) return false;
        }
        int yyyyInt = Integer.parseInt(yyyy); // converting String into an int variable
        if (yyyyInt < 1900 || yyyyInt > 2022) return false;

        if (yyyy.length() != 4) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "problem='" + problem + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", hasInsurance=" + hasInsurance +
                ", patientDoctor='" + (patientDoctor == null ? "You have no doctor available!" :
                patientDoctor.firstName + " "  + patientDoctor.lastName)  + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Patient patient = createPatient();

        System.out.println(patient);

        patient.patientDoctor = Doctor.gerDoctor(patient.problem);
        System.out.println(patient);
        System.out.println(patient.patientDoctor);
    }

}
