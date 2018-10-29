package parametrized;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TimeCheck {


	static int check (File input){
		int lines=0;		
		
		try (Scanner sc = new Scanner(input)){
			
			while (sc.hasNextLine())
				{sc.nextLine();
				lines++;
				}

		return lines-1;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return lines;
		}
	}
		
	}



