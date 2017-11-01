public class Fractal_Estructure {
	
	public int [][] Matriz;
	public int [] Rule = {0,1,1,1,0,1,1,0};
	
	public Fractal_Estructure (int width , int height , int rule)
	{
		this.Matriz = new int [height][width];
		//this.Rule = new int [8];
		
		this.Initialize(width);
		//this.binary_rule(rule, 0);
		this.Generate_Fractal();
		
	}
	
	private void Initialize (int width)
	{
		for (int i = 0; i < width; i++) {
			this.Matriz [0][i] = Math.random() < 0.7 ? 1:0;
		}
	}
	
	public void binary_rule(int rule , int index)
	{
		
		if(rule > 1)
		{
			if(rule > Math.pow(2, 7 - index))
			{
				this.Rule[index] = 1;
				rule -= Math.pow(2, 7 - index); 
			}
			
			this.binary_rule(rule, index + 1);
			
		}else{
			this.Rule[0] = rule;
		}
	}
	
	public void Generate_Fractal()
	{
		int M = this.Matriz.length;
		int N = this.Matriz[0].length;
		
		for (int i = 1; i < M; i++) {
			for (int j = 0; j < N; j++) {
				this.Matriz[i][j] = this.Rule[4 * this.Matriz[i-1][(j - 1 + N)%N] + (2 * this.Matriz[i - 1][j]) + (1 * this.Matriz[i + 1][(j + 1) % N])];	
			}
		}
		
		for (int j = 0; j < N ; j++) {
			this.Matriz[0][j] = this.Rule[ (this.Matriz [M - 1][(j - 1 + N) % N]) + (2 * this.Matriz[N - 1][j]) + (4 * this.Matriz[M - 1][(j + 1) % N])];
		}			
	}
}
