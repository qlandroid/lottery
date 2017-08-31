package shopping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileChangeUtils {
	public static void main(String[] args) {
		String fileStr = "";
		File file = new File(fileStr);
		String saveFile = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));
			String t;
			while((t = br.readLine()) != null){
				if(t.startsWith("") && t.endsWith("")){
					t="";
				}
				bw.write(t);
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
