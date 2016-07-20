import static org.junit.Assert.*;

import org.junit.Test;


public class TestMatrix {
	
	Matrix m1 = new Matrix(2, 2);
	
	int[][] input1 = {{1,2},{3,4}};

	//Test case for addition
	@Test
	public void testAddMatrix() {
		int [][] expacted = {{2,4},{6,8}};
		m1.setMatrixbyArray(input1);
		Matrix actual = m1.addMatrix(m1);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(expacted[i][j],actual.matrix[i][j]);
			}
		}
	}

	//Test case for Multiplication
	@Test
	public void testMultiply() {
		int [][] expacted = {{7,10},{15,22}};
		m1.setMatrixbyArray(input1);
		Matrix actual = m1.multiply(m1);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(expacted[i][j],actual.matrix[i][j]);
			}
		}
	}

	//Test case for transpose
	@Test
	public void testGetTranspose() {
		int [][] expacted = {{1,3},{2,4}};
		m1.setMatrixbyArray(input1);
		Matrix actual = m1.getTranspose();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(expacted[i][j],actual.matrix[i][j]);
			}
		}
	}

}
