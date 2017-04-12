package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import obj.InputMessage;

public class Summary{
	
	private int RenameCounter;
	private int ModifiCounter;
	private int PathChangedCounter;
	private int SizeChangedCounter;
	
	public Summary(){
		RenameCounter = 0;
		ModifiCounter = 0;
		PathChangedCounter = 0;
		SizeChangedCounter = 0;
	}
	
	public void recordSummary(File file, String type) throws FileNotFoundException{
		String content = null;
		if(type.equals("modified")){
			ModifiCounter += 1;
			content = "[INFO]Type: " + type + ", " + ModifiCounter + " times!";
		}else if(type.equals("path-changed")){
			PathChangedCounter += 1;
			content = "[INFO]Type: " + type + ", " + PathChangedCounter + " times!";
		}else if(type.equals("renamed")){
			RenameCounter += 1;
			content = "[INFO]Type: " + type + ", " + RenameCounter + " times!";
		}else if(type.equals("size-changed")){
			SizeChangedCounter += 1;
			content = "[INFO]Type: " + type + ", " + SizeChangedCounter + " times!";
		}
		File f = new File("F:\\Java\\ThreadMonitor\\output\\Output.txt");
		@SuppressWarnings("resource")
		PrintStream pstream = new PrintStream(f); 
		pstream.append(content);
	}
}
