
public class Practice__oop {
    public static void main(String[] args) {
//Stud s =new Stud();
//s.name ="aman";
//s.age =32;
//        System.out.println(s.name+s.age);



        Complex c =new Complex(4,5);
        Complex d=new Complex(9,4);

        Complex e =Complex.add(c,d);
        Complex f =Complex.sub(c,d);
        Complex g =Complex.mul(c,d);

        e.printComplex();
        f.printComplex();
        g.printComplex();
    }

}


//class Stud{
//    String name;
//    int age;
//}


class  Complex{
    int real ;
    int img;

    public Complex(int r,int i){
        real =r;
        img =i;

    }

    public static Complex add(Complex a,Complex b){
        return  new Complex((a.real+b.real),(a.img+b.img));
    }


    public static Complex sub(Complex a,Complex b){
        return  new Complex((a.real-b.real),(a.img-b.img));
    }


    public static Complex mul(Complex a,Complex b){
        return  new Complex(((a.real*b.real)-(a.img*b.img)),((a.real*b.img)+(a.img+b.real)));
    }

    public void printComplex(){
        if(real ==0 && img!=0){
            System.out.println(img+" i");
        } else if (img==0 && real!=0) {
            System.out.println(real);

        }
        else{
            System.out.println(real+"+"+img+"i");
        }
    }
}