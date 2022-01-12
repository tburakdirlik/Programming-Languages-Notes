package com.company;

public class INHERITANCE {

    public static void main(String[] args) {

        Director director= new Director("tunahan burak dirlik" , 8000, "IT",10);
        System.out.println();
        System.out.println(director.showInfos());
    }

}
class Worker{
    private String name;
    private Integer wage;
    private String departmant;

    public Worker(String name, Integer wage, String departmant) {
        this.name = name;
        this.wage = wage;
        this.departmant = departmant;
    }

    public static String work(){
        return "Worker is working";
    }
    public String showInfos(){

        return  "Name: " + name + "\n" +
                "Wage: " + wage + "\n" +
                "Departmant: " + departmant;
    }

    public void departmentChange(String newDepartment){
        System.out.println("Departmant is changing");
        this.departmant = newDepartment;
        System.out.println("New Department : " + this.departmant);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public String getDepartmant() {
        return departmant;
    }

    public void setDepartmant(String departmant) {
        this.departmant = departmant;
    }
}
class Director extends Worker{
    private  int responsible_person;

    public Director(String name, Integer wage, String departmant, int responsible_person) {
        super(name, 8000, "IT");
        this.responsible_person = responsible_person;
    }
    public void increaseSalary(int amount){
        System.out.println("Workers salary increased amount: " + amount );

    }
    public String showInfos(){
        return super.showInfos() + "Responsible person count is: " + this.responsible_person;
    }
}






