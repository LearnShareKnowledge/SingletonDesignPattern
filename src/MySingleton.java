import java.io.Serializable;

/**
 * Created by 310124463 on 13/01/17.
 */
public class MySingleton implements Serializable {

    private static final long serialVersionUID = -1093810940935189395L;

    private static MySingleton mySingleton ;

    private MySingleton()
    {
        if(mySingleton!=null)
        {
            throw new IllegalStateException("Already created !!!");
        }
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

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported!!!");
    }

    private static Class getClass(String classname) throws ClassNotFoundException
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        if(classLoader==null)
        {
            classLoader = MySingleton.class.getClassLoader();
        }

        return classLoader.loadClass(classname);

    }
}
