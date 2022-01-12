package com.company;

public class COMPOSITION {
    public static void main (String args[]){

        RESOLUTION resolution =             new RESOLUTION(1920,1080);
        COMPUTER_MONITOR computer_monitor = new COMPUTER_MONITOR("520d", "Lenovo", "18,5", resolution);
        COMPUTER_CASE computer_case =       new COMPUTER_CASE("Show blade", "Shadow", "Glass");
        MAIN_CARD main_card =               new MAIN_CARD("15IKBR", "Lenovo", 8, "Windows");
        COMPUTER computer =                 new COMPUTER( computer_monitor, computer_case, main_card);


        computer.getComputer_case().openComputer();
        computer.getMain_card().loadOperatingSystem("Windows");
        computer.getComputer_monitor().closeMonitor();


    }

}
class COMPUTER{
    private COMPUTER_MONITOR computer_monitor;
    private COMPUTER_CASE computer_case;
    private MAIN_CARD main_card;

    public COMPUTER(COMPUTER_MONITOR computer_monitor, COMPUTER_CASE computer_case, MAIN_CARD main_card) {
        this.computer_monitor = computer_monitor;
        this.computer_case = computer_case;
        this.main_card = main_card;
    }

    public COMPUTER_MONITOR getComputer_monitor() {
        return computer_monitor;
    }

    public void setComputer_monitor(COMPUTER_MONITOR computer_monitor) {
        this.computer_monitor = computer_monitor;
    }

    public COMPUTER_CASE getComputer_case() {
        return computer_case;
    }

    public void setComputer_case(COMPUTER_CASE computer_case) {
        this.computer_case = computer_case;
    }

    public MAIN_CARD getMain_card() {
        return main_card;
    }

    public void setMain_card(MAIN_CARD main_card) {
        this.main_card = main_card;
    }
}
class COMPUTER_MONITOR{
    private String model;
    private String producer;
    private String size;
    private RESOLUTION resolution;

    public COMPUTER_MONITOR(String model, String producer, String size, RESOLUTION resolution) {
        this.model = model;
        this.producer = producer;
        this.size = size;
        this.resolution = resolution;
    }
    public void closeMonitor(){
        System.out.println("Monitor is closing");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public RESOLUTION getResolution() {
        return resolution;
    }

    public void setResolution(RESOLUTION resolution) {
        this.resolution = resolution;
    }
}

class RESOLUTION{
    private Integer width;
    private Integer height;

    public RESOLUTION(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
class COMPUTER_CASE{

    private String model;
    private String producer;
    private String material;

    public COMPUTER_CASE(String model, String producer, String material) {
        this.model = model;
        this.producer = producer;
        this.material = material;
    }
    public void openComputer(){
        System.out.println("Computer is opening");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
class MAIN_CARD{

    private String model;
    private String producer;
    private Integer slotNumber;
    private String operaitngSystem;

    public MAIN_CARD(String model, String producer, Integer slotNumber, String operaitngSystem) {
        this.model = model;
        this.producer = producer;
        this.slotNumber = slotNumber;
        this.operaitngSystem = operaitngSystem;
    }
    public void loadOperatingSystem(String operatingSystem){
        this.operaitngSystem = operatingSystem;
        System.out.println("Operating system is loaded: " + operatingSystem);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getOperaitngSystem() {
        return operaitngSystem;
    }

    public void setOperaitngSystem(String operaitngSystem) {
        this.operaitngSystem = operaitngSystem;
    }
}

