package crawler;

import java.util.Date;
/**
 * 
 * @author liugang
 *
 */
public class DateFormat {
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date){
		//System.out.println("[" + new Date().toString() + "]" + "***Spider.Tools.DateFormat***");
		final String[] MONTH = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		String javadate = date.toString();
		String month = "";
		String sqldate = "";
		String[] ds = javadate.split(" ");
		for(int i = 0;i < MONTH.length;i++)
			if(ds[1].equals(MONTH[i]))
				month = Integer.toString(i+1);
		sqldate = ds[5] + "-" + month + "-" + ds[2] + " " + ds[3];
		System.out.println(sqldate);
		return sqldate;	
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存�?
		DateFormat.dateFormat(new Date());
		System.out.println("Done");
	}

}
