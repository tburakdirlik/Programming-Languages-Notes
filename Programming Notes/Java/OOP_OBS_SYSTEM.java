
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * @author Tunahan Burak Dirlik 20170808076
 * @since 1.8.0
 */
public class Assignment02_20170808076 {

    public static void main(String[] args) {
        
        Department d = new Department("CSE", "Computer Engineering");
        Department d2 = new Department("CSE2", "Computer Secrets");
        Teacher t = new Teacher("Joseph LEDET", "josephledet@akdeniz.edu.tr", 123L, d, 1);
        System.out.println(t);

        Course c1 = new Course(d, 101, "Programming 1", 6, t);
        Course c2 = new Course(d, 102, "Programming 2", 4, t);
        System.out.println(c1.courseCode() + " - " + c1.getTitle());
        System.out.println(c2);

        Student s = new Student("Test STUDENT", "me@somewhere.com", 455L, d);
        System.out.println(s);

        //s.addCourse(c1, 78);
        s.addCourse(c2, 65);
        System.out.println(s.getAKTS());
        System.out.println(s.getAttemptedAKTS());
        System.out.println(s.getGPA());
    }
}

class Department {

    private String ID;
    private String Name;
    private Teacher Chair;

    public Department(String ID, String Name) {
        if (Name == null || Name == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Name", "Computer Engineering");
        }
        if (!(ID.length() == 3 || ID.length() == 4)) {
            throw new InvalidDepartmentIdException(this.getClass(), "ID", ID);
        }
        this.ID = ID;
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        if (ID == null || ID == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "ID", "Computer Engineering ");
        }
        if (!(ID.length() == 3 || ID.length() == 4)) {
            throw new InvalidDepartmentIdException(this.getClass(), "ID", ID);
        }

        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        if (Name == null || Name == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Name", "Computer Engineering");
        }
        this.Name = Name;
    }

    public Teacher getChair() {
        return Chair;
    }

    public void setChair(Teacher Chair) {
        if (Chair == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Chair", "Teacher t = new Teacher('Joseph LEDET', 'josephledet@akdeniz.edu.tr', 123L, d, 1);");
        }
        if (this != Chair.getDepartment()) {
            throw new DepartmentMismatchException(this, Chair);
        }
        this.Chair = Chair;
    }
}

class Course {

    private Department Department;
    private Teacher Teacher;
    private int number;
    private String title;
    private int AKTS;

    public Course(Department Department, int number, String title, int AKTS, Teacher Teacher) {

        if (Department == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Course", "Course c1 = new Course(d, 101, 'Programming 1', 6, t)");
        }
        if (Teacher == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Teacher", "Teacher t = new Teacher('Joseph LEDET', 'josephledet@akdeniz.edu.tr', 123L, d, 1)");
        }
        if (Teacher.getDepartment() != Department) {
            throw new DepartmentMismatchException(Department, Teacher);
        }

        this.Department = Department;

        if (!(number >= 100 && number <= 499) || (number >= 5000 && number <= 5999) || (number >= 7000 && number <= 7999)) {
            throw new InvalidNumberRangeException(this.getClass(), number);
        }
        this.number = number;

        if (title == null || title == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Title", "Programming 1");
        }
        this.title = title;

        if (!(AKTS > 0)) {
            throw new InvalidAktsException(this.getClass(), AKTS);
        }
        this.AKTS = AKTS;
        this.Teacher = Teacher;
    }

    public Department getDepartment() {
        return Department;
    }

    public void setDepartment(Department Department) {

        if (Department == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), " Department ", " course department should be valid");
        }
        /*
        if (Teacher.getDepartment() != Department) {
            throw new DepartmentMismatchException(Department, Teacher);
        }
        */
        this.Department = Department;
        this.Department = Department;
    }

    public Teacher getTeacher() {
        return Teacher;
    }

    public void setTeacher(Teacher Teacher) {

        if (Teacher.getDepartment() != Department) {
            throw new DepartmentMismatchException(this.Department, Teacher);
        }
        this.Teacher = Teacher;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {

        if (!(number >= 100 && number <= 499) || (number >= 5000 && number <= 5999) || (number >= 7000 && number <= 7999)) {
            throw new InvalidNumberRangeException(this.getClass(), number);
        }
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Title", "Programming 1");
        }
        this.title = title;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void setAKTS(int AKTS) {
        if (!(AKTS > 0)) {
            throw new InvalidAktsException(this.getClass(), AKTS);
        }
        this.AKTS = AKTS;
    }

    public String courseCode() {
        return Department.getID() + " " + getNumber();
    }

    @Override
    public String toString() {

        return "{" + getDepartment().getID() + "}" + " " + "{" + getNumber() + "}" + "-" + "{" + getTitle() + "} " + " " + "{" + getAKTS() + "}";
    }
}

abstract class Person {

    private String name;
    private String email;
    private long ID;
    private Department Department;

    public Person(String name, String email, long ID, Department department) {

        if (name == null || name == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Name", "Taha YİGİT");
        }
        this.name = name;

        if (email == null || email == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Email", "josephledet@akdeniz.edu.tr");
        }
        if (!(isValid(email))) {
            throw new EmailFormatException(this.getClass(), email);
        }
        this.email = email;
        this.ID = ID;
        if (department == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Department", "Department d = new Department('CSE', 'Computer Programming');");
        }
        this.Department = department;
    }

    public boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null || email == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Email", "Email can not be null or empty");
        }
        return pattern.matcher(email).matches();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "name", "Joseph LEDET");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email == null || email == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Email", "me@somewhere.com");
        }
        if (!(isValid(email))) {
            throw new EmailFormatException(this.getClass(), email);
        }
        this.email = email;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Department getDepartment() {
        return Department;
    }

    public void setDepartment(Department Department) {
        if (Department == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Department", "Department d2 = new Department('CSE2', 'Computer Engineering');");
        }
        this.Department = Department;
    }

    @Override
    public String toString() {
        return getName() + " - " + "(" + getID() + ")" + " - " + getEmail();
    }
}

class Teacher extends Person {

    private int rank;

    public Teacher(String name, String email, long ID, Department department, int rank) {
        super(name, email, ID, department);
        if (!(rank >= 1 && rank <= 4)) {
            throw new InvalidRankException(rank);
        }
        this.rank = rank;
    }

    @Override
    public void setDepartment(Department Department) {

        if (Department == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Department", "Department cannot be null");
        }
        if (Department.getChair() == this) {
            Department.setChair(null);
        }
        super.setDepartment(Department);
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {

        String title = "";
        if (getRank() == 1) {
            title = "Lecturer";
        }
        if (getRank() == 2) {
            title = "Assistant Professor";
        }
        if (getRank() == 3) {
            title = "Associate Professor";
        }
        if (getRank() == 4) {
            title = "Professor";
        }
        return title;
    }

    public void promote() {

        if (getRank() < 1 || getRank() > 4) {
            throw new InvalidRankException(rank);
        }
        if (getRank() >= 1 && getRank() < 3) {
            this.rank += 1;
        }
    }

    public void demote() {
        if (getRank() < 1 || getRank() > 4) {
            throw new InvalidRankException(rank);
        }
        if (getRank() >= 2 && getRank() <= 4) {
            this.rank -= 1;
        }
    }

    @Override
    public String toString() {
        return getTitle() + " " + super.toString();
    }
}

class Student extends Person {

    HashMap<Course, Double> takenCourses = new HashMap<Course, Double>();
    HashMap<Course, Double> passedCourses = new HashMap<Course, Double>();
    HashMap<Course, Double> conditionallypassedCourses = new HashMap<Course, Double>();
    HashMap<Course, Double> failedCourses = new HashMap<Course, Double>();

    public Student(String name, String email, long ID, Department department) {

        super(name, email, ID, department);
        if (ID % 2 == 0) {
            throw new EvenIdException(this.getClass(), ID);
        }

    }

    @Override
    public void setID(long ID) {
        if (ID % 2 == 0) {
            throw new EvenIdException(this.getClass(), ID);
        }
        super.setID(ID);

    }

    public int getAKTS() {
        int passedakts = 0;
        for (Course value : passedCourses.keySet()) {
            passedakts += value.getAKTS();
        }
        return passedakts;
    }

    public int getAttemptedAKTS() {
        int takenakts = 0;
        for (Course value : takenCourses.keySet()) {
            takenakts += value.getAKTS();
        }
        return takenakts;
    }

    public void addCourse(Course course, double grade) {

        if (course == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Course ", "Course cannot be null");
        }
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException(grade);
        }
        if (takenCourses.containsKey(course)) {
            takenCourses.replace(course, grade);
        } else {
            takenCourses.put(course, grade);
        }
        if (grade >= 60 && grade <= 100) {
            passedCourses.put(course, grade);
        }
        if (grade >= 46 && grade <= 59) {
            conditionallypassedCourses.put(course, grade);
        }
        if (grade >= 0 && grade < 46) {
            failedCourses.put(course, grade);
        }
    }

    public double courseGPAPoints(Course course) {

        if ((takenCourses.containsKey(course)) == false) {
            throw new CourseNotFoundException(this, course);
        }

        double grade = takenCourses.get(course);
        double coureGPA = 0;

        if (grade >= 88 && grade <= 100) {
            coureGPA = 4.0;
        }
        if (grade >= 81 && grade <= 87) {
            coureGPA = 3.5;
        }
        if (grade >= 74 && grade <= 80) {
            coureGPA = 3.0;
        }
        if (grade >= 67 && grade <= 73) {
            coureGPA = 2.5;
        }
        if (grade >= 60 && grade <= 66) {
            coureGPA = 2.0;
        }
        if (grade >= 53 && grade <= 59) {
            coureGPA = 1.5;
        }
        if (grade >= 46 && grade <= 52) {
            coureGPA = 1.0;
        }
        if (grade >= 35 && grade <= 45) {
            coureGPA = 0.5;
        }
        if (grade >= 0 && grade < 35) {
            coureGPA = 0.0;
        }
        return coureGPA;

    }

    public String courseGradeLetter(Course course) {

        if (takenCourses.containsKey(course) == false) {
            throw new CourseNotFoundException(this, course);
        }
        double grade = takenCourses.get(course);

        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException(grade);
        }
        String letter = "";

        if (grade >= 88 && grade <= 100) {
            letter = "AA";
        }
        if (grade >= 81 && grade <= 87) {
            letter = "BA";
        }
        if (grade >= 74 && grade <= 80) {
            letter = "BB";
        }
        if (grade >= 67 && grade <= 73) {
            letter = "CB";
        }
        if (grade >= 60 && grade <= 66) {
            letter = "CC";
        }
        if (grade >= 53 && grade <= 59) {
            letter = "DC";
        }
        if (grade >= 46 && grade <= 52) {
            letter = "DD";
        }
        if (grade >= 35 && grade <= 45) {
            letter = "FD";
        }
        if (grade >= 0 && grade < 35) {
            letter = "FF";
        }
        return letter;
    }

    public String courseResult(Course course) {

        if (course == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Course", "Course can not be null");
        }
        if (takenCourses.containsKey(course) == false) {
            throw new CourseNotFoundException(this, course);
        }
        String result = "";
        
        if (passedCourses.containsKey(course)) {
            result = "Passed";
        }
        if (conditionallypassedCourses.containsKey(course)) {
            result = "Conditionally Passed";
        }
        if (failedCourses.containsKey(course)) {
            result = "Failed";
        }
        return result;
    }

    public double getGPA() {
        if (takenCourses.size() == 0) {
            return 0.0;
        }
        double courseakts_X_gpa = 0;
        for (Course key : takenCourses.keySet()) {
            courseakts_X_gpa += (key.getAKTS() * courseGPAPoints(key));
        }
        return courseakts_X_gpa / getAttemptedAKTS();

    }

    @Override
    public String toString() {
        return super.toString() + " - GPA: " + "{" + getGPA() + "}";
    }
}

class GradStudent extends Student {

    private String thesis;

    public GradStudent(String name, String email, long ID, Department department, String thesis) {
        super(name, email, ID, department);
        if (thesis == null || thesis == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Thesis ", "Thesis can not be null or empty");
        }
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        if (thesis == null || thesis == "") {
            throw new NullOrEmptyReferenceException(this.getClass(), "Thesis ", "Thesis can not be null or empty");
        }
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double courseGPAPoints(Course course) {

        if ((takenCourses.containsKey(course)) == false) {
            throw new CourseNotFoundException(this, course);
        }
        double grade = takenCourses.get(course);
        double couresGPA = 0;

        if (grade >= 90 && grade <= 100) {
            couresGPA = 4.0;
        }
        if (grade >= 85 && grade <= 89) {
            couresGPA = 3.5;
        }
        if (grade >= 80 && grade <= 84) {
            couresGPA = 3.0;
        }
        if (grade >= 75 && grade <= 79) {
            couresGPA = 2.5;
        }
        if (grade >= 70 && grade <= 74) {
            couresGPA = 2.0;
        }
        if (grade >= 0 && grade < 69) {
            couresGPA = 1.5;
        }
        return couresGPA;
    }

    @Override
    public String courseResult(Course course) {

        if (course == null) {
            throw new NullOrEmptyReferenceException(this.getClass(), "Course", "Course can not be null");
        }
        if (takenCourses.containsKey(course) == false) {
            throw new CourseNotFoundException(this, course);
        }
        String result = "";
        if (passedCourses.containsKey(course)) {
            result = "Passed";
        }
        if (failedCourses.containsKey(course)) {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String courseGradeLetter(Course course) {

        if (takenCourses.containsKey(course) == false) {
            throw new CourseNotFoundException(this, course);
        }
        double grade = takenCourses.get(course);
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException(grade);
        }
        String letter = "";

        if (grade >= 90) {
            letter = "AA";
        }
        if (grade >= 85 && grade <= 89) {
            letter = "BA";
        }
        if (grade >= 80 && grade <= 84) {
            letter = "BB";
        }
        if (grade >= 75 && grade <= 79) {
            letter = "CB";
        }
        if (grade >= 70 && grade <= 74) {
            letter = "CC";
        }
        if (grade >= 0 && grade <= 69) {
            letter = "DC";
        }
        return letter;
    }

    @Override
    public void addCourse(Course course, double grade) {

        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException(grade);
        }
        if (takenCourses.containsKey(course)) {
            takenCourses.replace(course, grade);
        } else {
            takenCourses.put(course, grade);
        }

        if (grade >= 70 && grade <= 100) {
            passedCourses.put(course, grade);
        }

        if (grade >= 0 && grade < 70) {
            failedCourses.put(course, grade);
        }
    }
}

class CourseNotFoundException extends RuntimeException {

    private Student student;
    private Course course;

    public CourseNotFoundException(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseNotFoundException: " + student.getID() + " has not yet taken " + course.getNumber();
    }
}

class DepartmentMismatchException extends RuntimeException {

    Department department;
    Teacher person;
    Course course;

    public DepartmentMismatchException(Course course, Teacher person) {

        this.course = course;
        this.person = person;
        this.department = null;
    }

    public DepartmentMismatchException(Department department, Teacher person) {
        this.department = department;
        this.person = person;
        this.course = null;
    }

    @Override
    public String toString() {
        if (course == null) {
            return "DepartmentMismatchException: " + person.getName() + "(" + person.getID() + ")" + " cannot be chair of " + department.getID()
                    + " because he/she is currently assignedd to " + person.getDepartment().getID();
        } else {
            return "DepartmentMismatchException: " + person.getName() + "(" + person.getID() + ")" + " cannot teach " + course.courseCode()
                    + " because he/she assigned to " + person.getDepartment().getID();
        }
    }
}

class InvalidGradeException extends RuntimeException {

    private double grade;

    public InvalidGradeException(double grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "InvalidGradeException:" + grade;
    }
}

class InvalidRankException extends RuntimeException {

    private int rank;
    public InvalidRankException(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "InvalidRankException: " + "attempted rank: " + rank + ", valid ranks: 1, 2, 3, 4";
    }
}
class InvalidDepartmentIdException extends RuntimeException {

    private Class c;
    private String attributeName;
    private String invalidValue;

    public InvalidDepartmentIdException(Class c, String attributeName, String invalidValue) {
        this.c = c;
        this.attributeName = attributeName;
        this.invalidValue = invalidValue;
    }

    @Override
    public String toString() {
        return "InvalidDepartmentIdException: " + "class name: " + c.getName() + ", attribute name : " + attributeName
                + ", invalid value: " + invalidValue + ", Department ID must be 3 or 4 characters, valid values: CSE, IEEE";
    }
}
class NullOrEmptyReferenceException extends RuntimeException {

    private Class c;
    private String attributeName;
    private String validValue;

    public NullOrEmptyReferenceException(Class c, String attributeName, String validValue) {
        this.c = c;
        this.attributeName = attributeName;
        this.validValue = validValue;
    }

    @Override
    public String toString() {
        return "NullOrEmptyReferenceException: " + "class name: " + c.getName() + ", attribute name: " + attributeName
                + ", cannot be null or empty, valid value example: " + validValue;
    }
}

class InvalidNumberRangeException extends RuntimeException {

    private Class c;
    private int attemptedValue;

    public InvalidNumberRangeException(Class c, int attemptedValue) {
        this.c = c;
        this.attemptedValue = attemptedValue;
    }

    @Override
    public String toString() {
        return "InvalidNumberRangeException: " + "class name: " + c.getName() + ", attribute name: Number" + ", attempted value: " + attemptedValue
                + ", cannot out of range, valid ranges: 100-499, 5000-5999, 7000-7999";
    }
}

class EmailFormatException extends RuntimeException {

    private Class c;
    private String attemptedEmail;

    public EmailFormatException(Class c, String attemptedEmail) {
        this.c = c;
        this.attemptedEmail = attemptedEmail;
    }
    @Override
    public String toString() {
        return "EmailFormatException: " + "class name: " + c.getName() + ", attribute name: Email, " + " invalid email: " + attemptedEmail
                + ", valid email example: me@somehere.com";
    }
}

class InvalidAktsException extends RuntimeException {

    private Class c;
    private int attemptedValue;

    public InvalidAktsException(Class c, int attemptedValue) {
        this.c = c;
        this.attemptedValue = attemptedValue;
    }

    @Override
    public String toString() {
        return "InvalidAktsException: " + "attemptedValue: " + attemptedValue + ", valid values: Akts must be positive ";
    }
}
class EvenIdException extends RuntimeException {

    private Class c;
    private long attemptedID;

    public EvenIdException(Class c, long attemptedID) {
        this.c = c;
        this.attemptedID = attemptedID;
    }

    @Override
    public String toString() {
        return "EvenIdException: " + "attempted id: " + attemptedID + ", id can not be even ";
    }
}
