/**
 * 
 */
package basic;

import org.apache.log4j.Logger;

/**
 * @author Administrator
 * 
 */
public class ArrayTest
{
    /**
     * 日志对象
     */
    private static final Logger log = Logger.getLogger(ArrayTest.class);

    public static Integer[] convert(Object[] obs)
    {
        // 通过Object转换也会报ClassCastException
        // Object result = (Object) obs;
        // if (result.getClass().isArray())
        // {
        // return (Integer[]) result;
        // }
        // else
        // {
        // return null;
        // }

        // 不能直接转换,报ClassCastException
        // return (Integer[])obs;

        Integer[] result = new Integer[obs.length];
        System.arraycopy(obs, 0, result, 0, obs.length);
        return result;
    }

    public static void print(Integer[] array)
    {
        if (array == null)
        {
            if (log.isDebugEnabled())
            {
                log.debug("print(Integer[]) - null"); //$NON-NLS-1$
            }
            return;
        }
        for (Integer i : array)
        {
            if (log.isDebugEnabled())
            {
                log.debug("print(Integer[]) - " + i); //$NON-NLS-1$
            }
            if (log.isDebugEnabled())
            {
                log.debug("print(Integer[]) - t"); //$NON-NLS-1$
            }
        }
    }

    public static void main(String[] args)
    {
        Object[] obs = new Object[]
        { 1, 2 };
        Integer[] iArray = convert(obs);
        print(iArray);
    }
}
