import java.util.Scanner;

public class Matrix {
	
	int row=0;
	int column=0;
	int[][] matrix;

	int NOT_POSSIBLE=-1;
	int SUCCESSFULL=1;
	
	public static void main(String[] args) {
		
		System.out.println("Enter dimentation for input Matrix");
		Matrix m1=new Matrix(0, 0);
		int row1 = m1.getIntfromUser("Row ");
		int column1 = m1.getIntfromUser("Column");
		m1=new Matrix(row1,column1);
		m1.setMatrix();
		m1.showMatrix();
		
		System.out.println("Press 1 for Transpose \nPress 2 for Addition \nPress 3 for Multiplication ");
		int choice =0;
		while(true){
		choice=m1.getIntfromUser("Choice");
		if(choice>=1 && choice <= 3)
		 break;
		else
			System.out.println("Invalid Choice, Try again");
		}
		
		
		switch (choice) {
			case 1:
				{
					Matrix m1Transposed= m1.getTranspose();
					m1Transposed.showMatrix();
					break;
				}
		
			case 2:
				{
					Matrix m2= new Matrix(row1,column1);
					m2.setMatrix();
					m2.showMatrix();
					Matrix result= m2.addMatrix(m1);
					result.showMatrix();
					break;
				}
			case 3:
				{
					System.out.println("Matrix row will be "+column1+"\nInsert No of columns");
					int col = m1.getIntfromUser(" ");
					Matrix m2= new Matrix(column1,col);
					m2.setMatrix();
					m2.showMatrix();
					Matrix result= new Matrix(row1, col);
					result=m1.multiply(m2);
					if(result!=null)
					{
						result.showMatrix();
					}
					else
					{
						System.out.println("Multiplication not possible");
					}
						break;
				}
		}
		

	}
	
	
	/**
	 * Contractor  
	 * @param row int
	 * @param column int
	 */
	public Matrix(int row,int column) {
		this.row=row;
		this.column=column;
		matrix=new int[row][column];
	}
	
	
	
	/**
	 * To show matrix
	 */
	public void showMatrix() {
		System.out.println("");
		for(int i=0;i<this.row;i++)
		{
			for(int j=0;j<this.column;j++)
			{
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	
	
	/**
	 * To get current matrix
	 * @return Matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}
	
	
	
	/**
	 * To get matrix from user
	 */
	public void setMatrix() {
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				matrix[i][j]=getMatrixElementsfromUser("element ["+i+" "+j+"]");
			}
		}
	}
	
	
	
	/**
	 * To get matrix from array
	 * @param in int[][] input array
	 */
	public void setMatrixbyArray(int[][] in)
	{
		this.row=in.length;
		this.column=in[0].length;
		matrix=in;
	}
	
	
	
	/**
	 * To add two matrix
	 * @param in input matrix
	 * @return Matrix output
	 */
	public Matrix addMatrix(Matrix in) {
		if(isSameDimentation(in)){
			Matrix tmp=new Matrix(in.row,in.column);
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					tmp.matrix[i][j]=matrix[i][j]+in.matrix[i][j];
				}
			}
			return tmp;
		}
		else
		{
			return null;
		}
	}
	
	
	
	/**
	 * To check matrix is of same dimentation or not
	 * @param in input Matrix
	 * @return boolean
	 */
	public boolean isSameDimentation(Matrix in) {
		if(this.row==in.row&& this.column==in.column)
			{return true;}
		else
			{return false;}
	}
	
	
	
	/**
	 * To check matrix is multiplicable or not  
	 * @param in Matrix
	 * @return boolean
	 */
	public boolean isMultiplicable(Matrix in) {
		//System.out.println(this.column+" "+in.row);
		if(this.column==in.row)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	
	
	/**
	 * To Multiply two matrix
	 * @param in input matrix
	 * @return Matrix output
	 */
	public Matrix multiply(Matrix in) {
		int resultRow=this.row;
		int resultColumn=in.column;
		int x=in.row;
		if(isMultiplicable(in))
		{
			Matrix result = new Matrix(resultRow, resultColumn);
			for (int i = 0; i < resultRow; i++) {
				for(int j=0;j<resultColumn;j++)
				{
					int tmp=0;
					for(int k=0;k<x;k++)
					{
						tmp=tmp+matrix[i][k]*in.matrix[k][j];
					}
					result.matrix[i][j]=tmp;
				}	
			}
			return result;
		}
		else
		{
			System.out.println("return null");
			return null;
		}
	}
	
	
	
	/**
	 * To get transpose of matrix
	 * @return Matrix
	 */
	public Matrix getTranspose() {
		Matrix tmp=new Matrix(this.column, this.row);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				tmp.matrix[j][i]=matrix[i][j];
			}
		}
		return tmp;
	}
	
	
	
    /**
	 * Method to read integer data from standard input
	 * @param Name of variable to print 
	 * @return int value of integer
	 */
	public int getMatrixElementsfromUser(String Name) 
	{
		Scanner s= new Scanner(System.in);
		int number = 0;		
		while(true){
			try {
				System.out.println("Enter "+Name);
				number=s.nextInt();
				if(true)
				{
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid, Try again");
				s.next();
			}
		}
		return number;
	}
	
	
	
	/**
	 * Method to read integer data from standard input
	 * @param Name of variable to print 
	 * @return int value of integer
	 */
	public int getIntfromUser(String Name) 
	{
		Scanner s= new Scanner(System.in);
		int number = 0;		
		while(true){
			try {
				System.out.println("Enter "+Name);
				number=s.nextInt();
				if(number>0)
				{
					break;
				}
				else
				{
					System.out.println("Invalid, Try Again");
				}
			} catch (Exception e) {
				System.out.println("Invalid, Try again");
				s.next();
			}
		}
		return number;
	}

}
