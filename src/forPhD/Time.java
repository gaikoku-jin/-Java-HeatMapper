package forPhD;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Time {


	static int check (File input){
		int rows=0;		
		
		try (Scanner sc = new Scanner(input)){
			
			while (sc.hasNextLine())
				{sc.nextLine();
				rows++;
				}

		return rows-1;
			
		} catch (IOException e) {
			e.printStackTrace();
			return rows;
		}
	}	
}



