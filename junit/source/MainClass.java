package source;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        URL url = null;
        HttpURLConnection httpurlconnection = null;
        try
        {
            url = new URL("http://www.baidu.com");
            httpurlconnection = (HttpURLConnection) url.openConnection();
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setRequestMethod("GET");
            
            String username = "username=02000001";
//            httpurlconnection.getOutputStream();
//            httpurlconnection.getOutputStream().write(username.getBytes());
//            httpurlconnection.getOutputStream().flush();
//            httpurlconnection.getOutputStream().close();
            int code = httpurlconnection.getResponseCode();
            System.out.println("Response code: " + code);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (httpurlconnection != null)
            {
                httpurlconnection.disconnect();
            }
        }
    }
}
