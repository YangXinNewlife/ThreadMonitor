package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import obj.InputMessage;

public class Detail{
	public void recordDetail(File file, String trigType) throws FileNotFoundException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
		Date curDate = new Date(System.currentTimeMillis());
		String nowtime = formatter.format(curDate);
		String content = "[INFO]NowTime : " + nowtime + " Action: " + trigType;
		File f = new File("F:\\Java\\ThreadMonitor\\output\\Output.txt");
		PrintStream pstream = new PrintStream(f); 
		pstream.append(content);
	}
}
