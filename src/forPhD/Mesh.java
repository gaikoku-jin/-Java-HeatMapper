package forPhD;

public class Mesh{
	private double [][]x,y,y_neg,z,T;
	private int []x_nod;

	Mesh(int N, double Radius, double interval, double[][]tempField,int currentTime) {
		double []rad = new double[N+1]; 			//radial coordinates
		x_nod = new int[N+1]; 					//nodes count

		
		for (int n=0;n<=N;n++){
			x_nod[n]=2*(N-n)+1;
			rad[n] = (double)(N-n)*interval; 
		}
		
			x = new double[x_nod[0]][N+1];		//rectangular abscissae
			y = new double[x_nod[0]][N+1];		//rectangular ordinates
			y_neg = new double[x_nod[0]][N+1];	//rectangular negative ordinates
			z = new double[x_nod[0]][N+1];		//rectangular neutral coordinates (for 3D visualisation)
			T = new double[x_nod[0]][N+1];		//temperatures corresponding to particular coordinates
		
		
		
		for (int n=0;n<=N;n++){
			
			for (int i=0;i<x_nod[n];i++) {
			x[i][n]=-rad[n]+LinToCos(x_nod[n], interval,rad[n])[i];  
			y[i][n]=Math.sqrt(rad[n]*rad[n]-x[i][n]*x[i][n]);
			y_neg[i][n]=-y[i][n];
			z[i][n]=0.0;
			T[i][n]=tempField[currentTime][n];
		
			}
		
		}
	
	}
	
		
		double []LinToCos (int nodes,double interval,double layerRad){		//casting linear abscissae range to trigonometric
			double [] linNod = new double [nodes];
			double [] cosNod = new double [nodes];
			double [] arg = new double [nodes];
			double x;
			
			for (int i = 0;i<nodes;i++) 
				{linNod[i] = interval*i;
				x=-layerRad+linNod[i];
				arg[i]=x*Math.PI/(2.0*layerRad);
				}
			
			for (int i = 0; i<=(nodes-1)/2;i++)
				cosNod[i]=Math.cos(arg[i])*linNod[i];
			
			for (int i = 0; i<(nodes-1)/2;i++)
				cosNod[nodes-1-i]=2*layerRad-Math.cos(arg[i])*linNod[i];
			
			if (nodes==1) cosNod[0]=0.0;
			
		return cosNod;
		}

		
		
		public double[][] getX() {
			return x;
		}

		public double[][] getY() {
			return y;
		}

		public double[][] getY_neg() {
			return y_neg;
		}

		public double[][] getZ() {
			return z;
		}

		public double[][] getT() {
			return T;
		}

		public int[] getX_nod() {
			return x_nod;
		}

		
}


