package com.company;
public class ABSTRACTION {

    //abstract classlardan obje oluşturamayız,
    //abstract claslarda hem gövdeil hem gövdesiz metotlar bir arada bulunur.
    //abstarct classa özellelik eklenebilir.
    //abstract classlarda en az bir tane abstarct metot bulunmalıdır.
    public static void main(String[] args) {

        SQUARE square= new SQUARE("kare1",6);
        CIRCLE circle = new CIRCLE("daire1", 6.0);

        square.calculateArea();
        square.calculateperimeter();
        circle.calculateArea();
        circle.calculateperimeter();

    }
}

abstract class SHAPE{
    private String name;

    public SHAPE(String name) {
        this.name = name;
    }

    abstract void calculateArea();
    abstract void calculateperimeter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class SQUARE extends SHAPE{

    private Integer edge;
    private Integer area;
    private Integer perimeter;

    public SQUARE(String name, Integer edge) {
        super(name);
        this.edge = edge;
    }

    @Override
    void calculateArea() {

        area = edge*edge;
        System.out.println("Area of the square is : " + area);
    }

    @Override
    void calculateperimeter() {
        perimeter = 4*edge;
        System.out.println("Perimeter of the square is : " + perimeter);
    }
}
class CIRCLE extends SHAPE{

    private Double radius;
    private Double area;
    private Double perimeter;

    public CIRCLE(String name, Double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    void calculateArea() {

        area = Math.PI*radius*radius;
        System.out.println("Area of the circle is :" + area);
    }

    @Override
    void calculateperimeter() {

        perimeter = 2*Math.PI*radius;
        System.out.println("Perimeter of the circle is : " + perimeter);

    }
}




















