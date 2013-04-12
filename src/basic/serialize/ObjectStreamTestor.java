package basic.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 通过序列化与反序列化克隆对象
 * 
 * @author rambo
 * @since 2013-1-27
 */
public class ObjectStreamTestor
{
    @SuppressWarnings("unchecked")
    public static <T> T cloneTo(T src) throws RuntimeException
    {
        ByteArrayOutputStream memoryBuffer = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        T dist = null;

        try
        {
            out = new ObjectOutputStream(memoryBuffer);
            out.writeObject(src);
            out.flush();
            in = new ObjectInputStream(new ByteArrayInputStream(
                    memoryBuffer.toByteArray()));
            dist = (T) in.readObject();

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            if (out != null)
            {
                try
                {
                    out.close();
                    out = null;
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
            if (in != null)
            {
                try
                {
                    in.close();
                    in = null;
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args)
    {
        Husband husband = new Husband(1);
        Wife wife = new Wife(1, "jin");
        husband.setWife(wife);
        Husband husband2 = cloneTo(husband);// 运用反序列生成了一个对象

        System.out.println("husband=" + husband);
        System.out.println("husband2=" + husband2);
    }
}

class Husband implements Serializable
{
    private static final long serialVersionUID = 7443362560508795580L;

    private int age;

    private Wife wife;

    Husband(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Wife getWife()
    {
        return wife;
    }

    public void setWife(Wife wife)
    {
        this.wife = wife;
    }
}

class Wife implements Serializable
{
    private static final long serialVersionUID = 1405455747543580562L;

    private int age;

    private String name;

    Wife(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
