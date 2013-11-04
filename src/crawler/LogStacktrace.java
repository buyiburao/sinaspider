package crawler;

import java.io.IOException;
import java.io.OutputStreamWriter;
/**
 * 
 */

/**
 * @author lichuanyang
 * 2013-10-14
 * 
 */
public class LogStacktrace {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
   }
   
   public static void log(Exception e,OutputStreamWriter osw)  {
      try{
      e.printStackTrace();
      StackTraceElement[] ste= e.getStackTrace();
      int length=ste.length;
      osw.write(e.toString()+"\n");
      for (int i=0;i<length;i++){
         osw.write(ste[i].toString()+"\n");
      }
      osw.flush();
      }catch(IOException ee){
         ee.printStackTrace();
      }
   }
   
   

}
