package data.structures.patterns;

public class MySingleton {

    private static final MySingleton instance = new MySingleton();

    public static MySingleton getInstance() {
        return instance;
    }

    private MySingleton () {
        //
    }

}
