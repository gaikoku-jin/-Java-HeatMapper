package sourcePackage;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File inputFileName = new File(System.getProperty("user.dir")+"\\"+"input.csv");
		
		int N = SegmentationCheck.check(inputFileName);	//segments count	(read from input file)
		int layers = N+1;							//layers (nodes) count
		
		double Radius = 10.0/2.0; 						//sample total radius
		double interval = Radius/(double)N;			//interval between layers along the radius
				
		int t = TimeCheck.check(inputFileName);			//time of simulation (read from input file)
		
		double [][] tempField = InputOutput.load(inputFileName, t, layers);
		
		for (int i =0; i<=t;i++) {
			MeshGrid circMesh = new MeshGrid(N,Radius,interval,tempField,i);
			
			InputOutput.save(circMesh.getX(), circMesh.getY(), circMesh.getY_neg(), circMesh.getZ(), circMesh.getT(), circMesh.getX_nod(), N, i);
		}
	}
}
	