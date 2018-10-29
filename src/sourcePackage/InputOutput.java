package sourcePackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutput {

	
	public static void save (double[][] xMesh, double[][] yMesh, double[][] y_negMesh, double[][] zMesh, double[][] TMesh, int[] nodes, int ndp, int time) {
		
		String outputName = System.getProperty("user.dir")+"\\"+"output"+time+".csv";
		File plik = new File (outputName);
		
		try(PrintWriter out = new PrintWriter(plik)){
			
			out.print("x;y;z;T");
			out.println();
			
			for (int n=0;n<=ndp;n++)
			{
				for (int i=0;i<nodes[n];i++) {
					double x=xMesh[i][n];
					double y=yMesh[i][n];
					double y_neg=y_negMesh[i][n];
					double z=zMesh[i][n];
					double T=TMesh[i][n];

			out.print(x+";"+y+";"+z+";"+T);
			out.println();
			out.print(x+";"+y_neg+";"+z+";"+T);
			out.println();
				}
				}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public static double[][] load (File plik, int time, int layers) {
		
		double[][]tempField = new double[time+1][layers];
		
		try (Scanner sc = new Scanner(plik)){
			
			int m=0;
			while (sc.hasNextLine()) {
				String linia = sc.nextLine();

				String []dane = linia.split(";");
				
				for (int n=0;n<layers;n++)
					tempField[m][n]=Double.parseDouble(dane[n]);
					m++;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempField;		
	}
}