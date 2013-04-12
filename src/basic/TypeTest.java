package basic;


public class TypeTest implements Cloneable
{
    public String p;
    public Object clone()
    {
        TypeTest t = new TypeTest();
        t.p = this.p;
        return t;
    }
    
    public String toString()
    {
        return "{"+p+"}";
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        TypeTest t = new TypeTest();
        t.p = "t";
        
        TypeTest t2 = (TypeTest)t.clone();
        t2.p = "t2";
        
        System.out.println(t);
        System.out.println(t2);
    }
}
