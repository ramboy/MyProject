package basic;

/**
 * 可变参数
 * 
 * @author rambo
 * @since 2012-11-25
 */
public class VariableParameter
{
    public static void main(String[] args)
    {
        System.out.println("printString():");
        VariableParameter.printString();

        System.out.println("\nprintString(null):");
        VariableParameter.printString((String[]) null);

        System.out.println("\nprintString((String)null):");
        VariableParameter.printString((String) null);

        System.out.println("\nprintString(null, null):");
        VariableParameter.printString(null, null);

        System.out.println("\nprintString((String[])null):");
        VariableParameter.printString((String[]) null);

        System.out.println("\nprintString(new String[2]):");
        VariableParameter.printString(new String[2]);

        System.out.println("\nprintString(new String[]{\"1\", \"2\"}):");
        VariableParameter.printString(new String[]
        { "1", "2" });
    }

    public static void printString(String... str)
    {
        if (str == null)
        {
            if (str instanceof String[])
            {
                System.out.println("Type: String[]. str == null");
            }
            else
            {
                System.out.println("Type: UnKnown. str == null");
            }
            return;
        }

        if (str.length <= 0)
        {
            if (str instanceof String[])
            {
                System.out.println("Type: String[]. str.length <= 0");
            }
            else
            {
                System.out.println("Type: UnKnown. str.length <= 0");
            }
            return;
        }

        for (String s : str)
        {
            if (str instanceof String[])
            {
                System.out.println("Type: String[]. " + s);
            }
            else
            {
                System.out.println("Type: UnKnown. " + s);
            }
        }
    }
}
