import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * HumanInvolker.
 *
 * @author Ilya_Sukhachev
 */
public class HumanInvolker implements InvocationHandler {

    private Human human;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanLoader humanLoader = new HumanLoader(proxy
                .getClass().getClassLoader());

        Class humanClass = humanLoader.loadClass("WhiteHuman");

        Method newMethod = humanClass.getMethod(method.getName());

        return newMethod.invoke(humanClass.newInstance(), args);
    }
}
