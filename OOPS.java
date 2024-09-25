import java.util.*;

public class OOPS {
    public static void main(String[] args) {
        
        // Dog d = new Dog();
        // d.eat();
        // d.legs(4);

        // calculator result = new calculator();
        // System.out.println(result.sum(4, 5));
        // System.out.println(result.sum(4, 5,6));
        // System.out.println(result.sum(4.5f, 5.8f));


        // goat g = new goat();
        // g.eat();

        // Horse h = new Horse();
        // h.walk();

        // chiken c = new chiken();
        // c.walk();

        // Queen q = new Queen();
        // q.moves();

        // Test t = new Test(); 
        // t.set_marks(98); // Line 2
        // System.out.print(Test.marks); // Line 3


        Scanner scn = new Scanner(System.in);
        System.out.println("1st number");
        System.out.print("real part :");
        int real = scn.nextInt();
        System.out.print("Immaginary part :");
        int Immaginary = scn.nextInt();


        System.out.println("2nd number");
        System.out.print("real part :");
        int real1 = scn.nextInt();
        System.out.print("Immaginary part :");
        int Immaginary2 = scn.nextInt();
        
        complex comp = new complex(real, Immaginary);

    }
}

class complex {
    public int real;
    public int Immaginary;

    complex(int real, int Immaginary) {
        this.real = real;
        this.Immaginary = Immaginary;
    }
}

// Multi level inheritance
// class Animal {
//     void eat() {
//         System.out.println("eats");
//     }
//     void breathe(){
//         System.out.println("breathe");
//     }
// }
// class mammel extends Animal {
//     void legs(int leg){
//         System.out.println(leg);
//     }
// }
// class Dog extends mammel {
//     void Bark(){
//         System.out.println("barks");
//     }
// }

// hybrid inheritance
// class Animal {
//     void eat() {
//         System.out.println("eats");
//     }
//     void breathe(){
//         System.out.println("breathe");
//     }
// }
// class mammel extends Animal {
//     void legs(int leg){
//         System.out.println(leg);
//     }
// }
// class Dog extends mammel {
//     void Bark(){
//         System.out.println("Barks");
//     }
// }
// class Cat extends mammel {
//     void Mauu(){
//         System.out.println("mauu");
//     }
// }
// class Human extends mammel {
//     void Walk(int leg){
//         System.out.println("walks");
//     }
// }
// class Bird extends Animal {
//     void Fly(){
//         System.out.println("flys");
//     }
// }
// class Peacock extends Bird {
//     void PeacockPices(){
//         System.out.println("PeacockPices");
//     }
// }

//function overloading - compile time polymorphism
// class calculator {
//     int sum(int a, int b){
//         return a + b;
//     }
//     int sum(int a, int b, int c){
//         return a + b + c;
//     }
//     float sum(float a, float b){
//         return a + b;
//     }
// }

//funtion overriding - run time polymorphism
// class Animal {
//     void eat(){
//         System.out.println("eats anything");
//     }
// }
// class goat extends Animal {
//     void eat(){
//         System.out.println("eats grass");
//     }
// }

// Abstract class
// abstract class Animal {                      // cannot create the object of abstract class
//     void eat(){                             // non abstract function
//         System.out.println("eats");
//     }
//     abstract void walk();                  // cannot specify the body
// }
// class Horse extends Animal {               // it complusory for derived class to implement the abstract function
//     void run(){
//         System.out.println("run");
//     }
//     void walk(){
//         System.out.println("walks on 4 legs");
//     }
// }

// constructor in abstract class
// abstract class Animal {
//     Animal(){
//         System.out.println("animal constructor");
//     }
//     void eat(){                             
//         System.out.println("eats");
//     }
//     abstract void walk(); 
// }
// class Horse extends Animal { 
//     Horse(){
//         System.out.println("horse constructor");
//     }     
//     void walk(){
//         System.out.println("walks on 4 legs");
//     }
// }
// class chiken extends Horse { 
//     chiken(){
//         System.out.println("chiken constructor");
//     }     
//     void walk(){
//         System.out.println("walks on 2 legs");
//     }
// }

// Interface ex - 1
// interface ChessPlayer {
//     void moves();
// }
// class Queen implements ChessPlayer {
//     public void moves(){
//         System.out.println("up,down,left,right and diagonal in all directon");
//     }
// }
// class Elephent implements ChessPlayer {
//     public void moves(){
//         System.out.println("up,down,left,right");
//     }
// }
// class king implements ChessPlayer {
//     public void moves(){
//         System.out.println("up,down,left,right and diagonal in all directon - by 1 step");
//     }
// }

// Interface ex - 2
// interface Harbivores {
//     //write Harbivores properties
// }
// interface Carnivores {
//     //write Carnivores properties
// }
// class bear implements Harbivores, Carnivores {
//     //implement bear function
// }

class Test {
    static int marks;
    void set_marks(int marks) {
        this.marks = marks; // Line 1
    }
}

