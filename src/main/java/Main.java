import java.io.File;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.util.concurrent.locks.LockSupport;

public class Main {
    static {
        System.out.println("Сейчас будет магия...");
    }

    public static void main(String[] args) throws Exception {

        Human human = new WhiteHuman();
        System.out.println(human.saySome());
        Human humanProxy = (Human) Proxy.newProxyInstance(WhiteHuman.class.getClassLoader(),
                new Class[]{Human.class},
                new HumanInvolker());

        System.out.println(humanProxy.saySome());
//        Magic magic = new KindMagic();
//        magic.doMagic();
//
//        while (true) {
//            LockSupport.parkNanos(5_000_000_000L);
//            useCustomClassLoader();
//        }
    }

    private static void useCustomClassLoader() throws Exception {
        ClassLoader cl = new MyClassLoader();
        Class<?> kindClass = cl.loadClass("KindMagic");
//        kindClass.getMethod("doMagic").invoke(kindClass.newInstance());
        Magic kindMagic = (Magic) kindClass.newInstance();
        kindMagic.doMagic();

//        KindMagic km1 = new KindMagic();
//        KindMagic km2 = (KindMagic) kindMagic;
    }
}
