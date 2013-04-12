package source;

public class MsgIdFactory
{
    private String getMsgId(String gatewayId, int sequenceId)
    {
        String msgId = "0812142423";
        
        return msgId;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String gatewayId = String.format("%06X", 1234345435);
        System.out.println(gatewayId);
        gatewayId = gatewayId.substring(0, 6);
        System.out.println(gatewayId);
    }
    
}
