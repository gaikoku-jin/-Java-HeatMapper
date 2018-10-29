package forPhD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

	
	public static void save (double[][] xMesh, double[][] yMesh, double[][] y_negMesh, double[][] zMesh, double[][] TMesh, int[] nodes, int N, int t) {
		
		String outputFileName = System.getProperty("user.dir")+"\\"+"output"+t+".csv";
		File output = new File (outputFileName);
		
		try(PrintWriter out = new PrintWriter(output)){
			
			out.print("x;y;z;T");
			out.println();
			
			for (int n=0;n<=N;n++)
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
			e.printStackTrace();
		}
	}

	
	
	public static double[][] load (File inputFileName, int t, int layers) {
		
		double[][]tempField = new double[t+1][layers];
		
		try (Scanner sc = new Scanner(inputFileName)){
			
			int m=0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				String []data = line.split(";");
				
				for (int n=0;n<layers;n++)
					tempField[m][n]=Double.parseDouble(data[n]);
					m++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tempField;		
	}
}