package task;

import java.io.File;
import java.util.ArrayList;

import obj.InputMessage;
import triger.ModifiedTriger;
import triger.PathChangedTriger;
import triger.RenameTriger;
import triger.SizeChangedTriger;

public class Task{

	public void TaskDist(ArrayList<InputMessage> inList) throws Exception{
		String content = null;
		String file = null;
		Detail dt = new Detail();
		Summary sum = new Summary();
		for(int i = 0; i < inList.size(); i++){
			if(inList.get(i).getContext().endsWith("]") == true){
				file = inList.get(i).getContext().substring(1, inList.get(i).getContext().length() - 1);
			}else{
				file = inList.get(i).getContext();
			}
			if(inList.get(i).getTriger().equals("renamed")){
				File dir = new File(file);
				Thread t = new RenameTriger(dir);
				t.start();
			}else if(inList.get(i).getTriger().equals("modified")){
				File dir = new File(file);
				Thread t = new ModifiedTriger(dir);
				t.start();
			}else if(inList.get(i).getTriger().equals("path-changed")){
				File dir = new File(file);
				Thread t = new PathChangedTriger(dir);
				t.start();
			}else if(inList.get(i).getTriger().equals("size-changed")){
				File dir = new File(file);
				Thread t = new SizeChangedTriger(dir);
				t.start();
			}
		}
	}
}
