public class Singleton {
    private static Singleton singletonIntance = new Singleton();

    private Singleton() {
        System.out.println("Creating...");
    }
    
    public static Singleton getInstance() {
        return singletonIntance;
    }

}

class TestClass {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        print("s1", s1);
        print("s2", s2);
    }
    static void print(String name, Singleton obj) {
        System.out.println(String.format("Object: %s, Hashcode: %d", name, obj.hashCode()));
    }
}