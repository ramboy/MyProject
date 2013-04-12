package source;

class MyException extends Exception
{
}

public class TestException
{
    private void throwMyException() throws MyException
    {
        throw new MyException();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            try
            {
                try
                {
                    TestException test = new TestException();
                    test.throwMyException();
                }
                catch (MyException e)
                {
                    throw new RuntimeException(e);
                }
            }
            catch (RuntimeException e)
            {
                throw e.getCause();
            }
        }
        catch (MyException e)
        {
            System.out.println("MyException.");
        }
        catch (Error e)
        {
            System.out.println("Error.");
        }
        catch (Throwable e)
        {
            System.out.println("Throwable.");
        }
        
        System.out.println("End.");
    }
}
