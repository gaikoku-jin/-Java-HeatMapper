package forPhD;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File input = new File(System.getProperty("user.dir")+"\\"+"input.csv");
		
		int ndp = Layers.check(input);	//segments count	(read from input file)
		int layers = ndp+1;							//layers (nodes) count
		
		double R = 10.0/2.0; 						//sample total radius
		double interval = R/(double)ndp;			//interval between layers along the radius
				
		int time = Time.check(input);			//time of simulation (read from input file)
		
		double [][] tempField = IO.load(input, time, layers);
		
		for (int i =0; i<=time;i++) {
			Mesh circMesh = new Mesh(ndp,R,interval,tempField,i);
			
			IO.save(circMesh.getX(), circMesh.getY(), circMesh.getY_neg(), circMesh.getZ(), circMesh.getT(), circMesh.getX_nod(), ndp, i);
		}
			
	}
}
	