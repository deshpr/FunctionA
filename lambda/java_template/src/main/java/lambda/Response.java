/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import faasinspector.fiResponse;
import java.lang.annotation.Native;

/**
 *
 * @author wlloyd
 */
public class Response extends fiResponse {
    
    //
    // User Defined Attributes
    //
    //
    // ADD getters and setters for custom attributes here.
    //

    private String msg;
    public String getMsg()
    {
        return msg;
    }
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    private int shift;
    public int getShift()
    {
        return shift;
    }
    public void setShift(int shift)
    {
        this.shift = shift;
    }
    long decodeTime;
    public long getDecodeTime()
    {
        return decodeTime;
    }    
    
     public void setDecodeTime(long decodeTime)
    {
        this.decodeTime = decodeTime;
    }
    long encodeTime;
    public long getEncodeTime()
    {
        return encodeTime;
    }
    public void setEncodeTime(long encodeTime)
    {
        this.encodeTime = encodeTime;
    }
    
    @Override
    public String toString()
    {
        return "value=" + this.getMsg()+ super.toString(); 
    }

}
