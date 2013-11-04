/**
 * 
 */
package crawler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author lichuanyang 2013-9-29
 * 
 */
public class GetToken {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      String[] tokens=new String[5];
      tokens=get("token.txt");
      for (int i=0;i<=4;i++){
         System.out.println(tokens[i]);
      }

   }

   public static String[] get(String file) {
      String[] tokens=new String[10];
      int i=0;
      try {
         InputStream fis = new FileInputStream(file);
         InputStreamReader is = new InputStreamReader(fis, "utf-8");
         BufferedReader reader = new BufferedReader(is);
         

         String line = reader.readLine();
         while(line!=null){
            
            tokens[i]=line;
            i++;
            line=reader.readLine();
         }
         
         
      } catch (IOException e) {
      }
      return tokens;
   }

}
