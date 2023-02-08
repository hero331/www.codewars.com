public class Animal {
    public static void main(String args[]) {
        Dog dog = new Dog();
        dog.Voice();
        
        Cat cat = new Cat();
        cat.Voice();
    }
    public void Voice(){
        System.out.println("Voice!"); 
    }
}
