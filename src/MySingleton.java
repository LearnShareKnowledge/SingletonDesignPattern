import java.io.Serializable;

/**
 * Created by 310124463 on 13/01/17.
 */
public class MySingleton implements Serializable {

    private static final long serialVersionUID = 44L;

    private static MySingleton mySingleton ;

    private MySingleton()
    {
        throw new IllegalStateException("Already instantiated");
    }


    public static synchronized MySingleton getInstance()
    {
        if(mySingleton==null)
        {
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }

    public Object readResolve()
    {
        return mySingleton;
    }

    public Object writeReplace()
    {
        return mySingleton;
    }

    public Object clone () throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported !!!");
    }

    public static Class getClass(String className) throws ClassNotFoundException
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        if(classLoader==null)
        {
            classLoader = MySingleton.class.getClassLoader();
        }

        return classLoader.loadClass(className);
    }


}
