package forPhD;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Layers {


	static int check (File input){
		int columns=0;		
		
		try (Scanner sc = new Scanner(input)){
			
			String layerLine = sc.nextLine();
			String []layerCount = layerLine.split(";");
			columns=layerCount.length;
			
			return columns-1;
			
		} catch (IOException e) {
			e.printStackTrace();
			return columns;
		}
	}
}



