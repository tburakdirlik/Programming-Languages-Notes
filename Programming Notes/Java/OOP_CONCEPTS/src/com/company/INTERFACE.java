package com.company;

/*
    Interfacelerin kod blokları yazılmaz.
    Final ve static tanımlama yapılabilir.
    Interfacelerden pbje oluşturulamaz.
    İnterface e özellik ekleyeceksek bunu mutlaka public ile başlaması gerekiyor.
    burda görevli metot kullanmak istediğin zaman static anahtarını kullanmalısın.
    */

public class INTERFACE {

    public static void main(String[] args) {
        SOFTWARE_ENGINEER software_engineer = new SOFTWARE_ENGINEER(false, false);

        software_engineer.checkMilitarySitutation();
        software_engineer.criminalRecord();
        String jobExperineces [] = {"havelsan", "roketsan", "tesla"};
        software_engineer.jobExperience(jobExperineces);
    }
}
interface InterfaceEngineer{

    void checkMilitarySitutation();
    String gpa(Double gpa);
    void criminalRecord();
    void jobExperience(String [] array);
}

class interfacedetay implements INTERFACE2{
    String link = "https://medium.com/codable/interfacelerin-mantigi-nedir-1-hikayeli-f9b960228328";

}
class SOFTWARE_ENGINEER implements InterfaceEngineer{

    private boolean crimimalRecord;
    private boolean militaryStatus;

    public SOFTWARE_ENGINEER(boolean crimimalRecord, boolean militaryStatus) {
        this.crimimalRecord = crimimalRecord;
        this.militaryStatus = militaryStatus;
    }

    @Override
    public void checkMilitarySitutation() {
        if (militaryStatus == true){
            System.out.println("I did my military");
        }
        else
        {
            System.out.println("I do not my military");
        }
    }

    @Override
    public String gpa(Double gpa) {
        return "gpa is" + gpa;
    }

    @Override
    public void criminalRecord() {

        if (crimimalRecord == false) {
            System.out.println("I do not have criminal record");
        }
        else{
            System.out.println("I have criminal record");
        }
    }

    @Override
    public void jobExperience(String[] array) {

        for (int i =0; i< array.length; i++){
            System.out.println(array[i]);

        }
    }
}




