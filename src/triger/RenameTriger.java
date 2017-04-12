package triger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import task.Detail;
public class RenameTriger extends Thread{
	
	private static HashMap<File, Long> files = new HashMap<File,Long>();
	private static boolean flag;
	private File file;
	private String lastName;
	
	public RenameTriger(File file){
		this.file = file;
		this.lastName = file.getName();
	}
	
	public static void getAllFiles(File file){
		Detail dt = new Detail();
		System.out.println(file);
		File[] dirs = file.listFiles();
		for(int i=0; i<dirs.length; i++){
			if(!dirs[i].isDirectory()){
				if(flag && files.get(dirs[i].getAbsoluteFile())!= dirs[i].lastModified()){
					System.out.println("File name had been altered---");
					try {
						dt.recordDetail(file, "renamed");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				files.put(dirs[i].getAbsoluteFile(), dirs[i].lastModified());
				System.out.println(dirs[i].getName() + "(" + dirs[i].length() + "bytes)");
			} else getAllFiles(dirs[i]);
		}
	}
	
	public void run() {
		Detail dt = new Detail();
		// TODO Auto-generated method stub
		while(true){
			System.out.println(file.isDirectory());
			if(!file.isDirectory()){
				if(lastName != file.getName()){
					System.out.println("File name had been altered---");
					try {
						dt.recordDetail(file, "renamed");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}else{
					System.out.println("Monitoring ---------");
				}
				
			}else{
				getAllFiles(file);
			}
			flag = true;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void alterFile(String type, String fileName) throws IOException{
		if(type.equals("create")){
			File f = new File(fileName);
			if(!f.exists()){
				f.createNewFile();
			}
		}else if(type.equals("modified")){
			//not implements 
		}else if(type.equals("delete")){
			File f = new File(fileName);
			if(f.exists()){
				f.delete();
			}
		}
	}
}
