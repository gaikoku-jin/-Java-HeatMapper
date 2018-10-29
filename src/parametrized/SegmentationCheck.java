package parametrized;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SegmentationCheck {


	static int check (File input){
		int columns=0;		
		
		try (Scanner sc = new Scanner(input)){
			
			String layerLine = sc.nextLine();
			String []layerCount = layerLine.split(";");
			columns=layerCount.length;
			
			return columns-1;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return columns;
		}
	}
		
	}



