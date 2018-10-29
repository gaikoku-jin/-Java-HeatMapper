package parametrized;

public class MeshGrid{
	private double [][]x,y,y_neg,z,T;
	private int []x_nod;

	MeshGrid(int ndp, double R, double interval, double[][]tempField,int time) {
		double []rad = new double[ndp+1]; 			//radial coordinates
		x_nod = new int[ndp+1]; 					//nodes count

		
		for (int n=0;n<=ndp;n++){
			x_nod[n]=2*(ndp-n)+1;
			rad[n] = (double)(ndp-n)*interval; 
		}
		
			x = new double[x_nod[0]][ndp+1];		//rectangular abscissae
			y = new double[x_nod[0]][ndp+1];		//rectangular ordinates
			y_neg = new double[x_nod[0]][ndp+1];	//rectangular negative ordinates
			z = new double[x_nod[0]][ndp+1];		//rectangular neutral coordinates (for 3D visualisation)
			T = new double[x_nod[0]][ndp+1];		//temperatures corresponding to particular coordinates
		
		
		
		for (int n=0;n<=ndp;n++){
			
			for (int i=0;i<x_nod[n];i++) {
			x[i][n]=-rad[n]+LinToCos(x_nod[n], interval,rad[n])[i];  
			y[i][n]=Math.sqrt(rad[n]*rad[n]-x[i][n]*x[i][n]);
			y_neg[i][n]=-y[i][n];
			z[i][n]=0.0;
			T[i][n]=tempField[time][n];
		
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

		
		double []LinToLog (int nodes,double interval){				//casting linear abscissae range to logarhytmic (redundant) 
			double [] linNod = new double [nodes];
			double [] logNod = new double [nodes];
			double [] logNodSym = new double [nodes];
			
			for (int i = 0;i<nodes;i++) 
				linNod[i] = interval*i;
			
			double topLin = linNod[nodes-1];
			double bottomLin = linNod[0];
			double topLog = topLin+interval;
			double bottomLog = bottomLin+interval;
			
			double b = Math.log(bottomLog/topLog)/(bottomLin-topLin);
			double a = interval;		//bottomLog/Math.exp(b*bottomLin)
			
			logNod[0]=0;
						
			for (int i = 1; i<nodes;i++)
				logNod[i] = a*Math.exp(b*linNod[i])-interval;
				
		
			for (int i = 0; i<=(nodes-1)/2;i++)
				logNodSym[i]=logNod[2*i]/2;
			
			for (int i = 0; i<(nodes-1)/2;i++)
				logNodSym[nodes-1-i]=topLin-logNodSym[i];
				
		return logNodSym;
		}
}


