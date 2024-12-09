public class OOP {
    public static void main(String[] args) {
        Pen p1 =new Pen();
        p1.setColor("voilet");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());


     Table t1 =new Table("kir",3);
        System.out.println("seat name-> "+t1.name+" seat num -> "+ t1.seatnumber);

     Student s1 =new Student();
     s1.name ="kumar";
     s1.age =32;
     s1.pass ="avc";
     Student s2 =new Student(s1);
     s2.pass ="sd";
    }
}

class Student{
    String name;
    int age;
    String pass;
     Student() {

     }
    //copy constructor
    Student(Student s1){
        this.name =s1.name;
        this.age =s1.age;
        this.pass =s1.pass;

    }

}

class Table{
    String name;
    int seatnumber;

   //constructor --nonParameterize
//    Table(){
//        System.out.println("constructor is callled");
//    }


    Table(String name, int seatnumber){
        this.name =name;
        this.seatnumber =seatnumber;
    }
}


 class Pen{
    private String color;
    private int tip;
    String getColor(){
        return this.color;
    }
    int getTip(){
        return this.tip;
    }

    void setColor(String newcolor){
        color=newcolor;
    }
    void setTip(int newTip){
        tip =newTip;
    }
}