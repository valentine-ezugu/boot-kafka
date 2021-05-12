

public class SingleTon {

    private static SingleTon singleTon;

    public SingleTon() {
    }

    public static SingleTon getConnection() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                singleTon = new SingleTon();
            }
        }
        return singleTon;
    }

}
