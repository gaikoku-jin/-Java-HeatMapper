package parametrized;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File inputFileName = new File(System.getProperty("user.dir")+"\\"+"input.csv");
		
		int N = SegmentationCheck.check(inputFileName);	//segments count	(read from input file)
		int layers = N+1;							//layers (nodes) count
		
		double Radius = 30.0/2.0; 						//sample total radius
		double interval = Radius/(double)N;			//interval between layers along the radius
				
		int t = TimeCheck.check(inputFileName);			//time of simulation (read from input file)
		
		double [][] tempField = InputOutput.load(inputFileName, t, layers);
		
		
		File parametry = new File ("parameters.csv");
		
		int parameters[] = InputOutput.param(parametry);
		
		for (int d : parameters) {
			System.out.println(d);
		}
		
		for (int i =0; i<=t;i++) {

		int x=0;
			while (x<15) {	
			
				if (i==parameters[x]) {	
					MeshGrid circMesh = new MeshGrid(N,Radius,interval,tempField,i);
					
					InputOutput.save(x, circMesh.getX(), circMesh.getY(), circMesh.getY_neg(), circMesh.getZ(), circMesh.getT(), circMesh.getX_nod(), N, i);
				break;
				}
			x++;
			}
		}
	}
}
	