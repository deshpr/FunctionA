/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

/**
 *
 * @author wlloyd
 */
public class Request {
    
    
    public String GetEncryptedMessage(){
           String encrypted="";
           String message = new String(msg);
        for(int i=0;i<message.length();i++)
        {
            int c=message.charAt(i);
            if(Character.isUpperCase(c))
            {
                c=c+(shift%26);
                if(c>'Z')
                    c=c-26;
            }
            else if(Character.isLowerCase(c))
            {
                c=c+(shift%26);
                if(c>'z')
                    c=c-26;
            }
            encrypted=encrypted+(char) c;
        }
        return encrypted;
    }
    
    String msg;
    int shift;

    public String getMsg(){
        return msg;
    }
    
    public void setMsg(String message){
        msg = message;
    }
    
    public int getShift()
    {
        return shift;
    }
    public void setShift(int shift)
    {
        this.shift = shift;
    }
    public Request(String message, int shift)
    {
        this.msg = message;
        this.shift = shift;
    }
    public Request()
    {
        
    }
}
