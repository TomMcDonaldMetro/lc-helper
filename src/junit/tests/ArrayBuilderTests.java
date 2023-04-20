package junit.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.helper.arrays.ArrayBuilder;

class ArrayBuilderTests {

	@Test
	void BuildStringArray() {
		
		String sampleInput = "[1,2,4,6]";
		String[] expectedArrayAfterBuild = {"1","2","4","6"};
		String[] actualStringArrayAfterBuild = ArrayBuilder.buildArray(sampleInput);
		assertArrayEquals(expectedArrayAfterBuild, actualStringArrayAfterBuild);
		
	}
	
	@Test
	void BuildIntegerArray() {
		
		String sampleInput = "[1,2,4,6]";
		int[] expectedArrayAfterBuild = {1, 2, 4, 6};
		int[] actualStringArrayAfterBuild = Arrays.stream(ArrayBuilder.buildArray(sampleInput)).mapToInt(Integer::parseInt).toArray();
		assertArrayEquals(expectedArrayAfterBuild, actualStringArrayAfterBuild);
		
	}
	
	@Test
	void BuildDoubleArray() {
		
		String sampleInput = "[1.55, 2.37, 4.45, 6.7]";
		double[] expectedArrayAfterBuild = {1.55, 2.37, 4.45, 6.7};
		double[] actualStringArrayAfterBuild = Arrays.stream(ArrayBuilder.buildArray(sampleInput)).mapToDouble(Double::parseDouble).toArray();
		assertArrayEquals(expectedArrayAfterBuild, actualStringArrayAfterBuild);
		
	}
	
	@Test
	void Build2dStringArray() throws Exception {
		String sampleInput = "[[1,2,3],[4,5,6],[7,8,9]]";
		String[][] expectedArrayAfterBuild = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		String[][] actualStringArrayAfterBuild = ArrayBuilder.string2dString(sampleInput);
		assertTrue(Arrays.deepEquals(expectedArrayAfterBuild, actualStringArrayAfterBuild));
	}
	
	@Test
	void Build2dIntegerArray() throws Exception {
		String sampleInput = "[[1,2,3],[4,5,6],[7,8,9]]";
		int[][] expectedArrayAfterBuild = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] actualStringArrayAfterBuild = ArrayBuilder.string2dInteger(sampleInput);
		assertTrue(Arrays.deepEquals(expectedArrayAfterBuild, actualStringArrayAfterBuild));
	}
	
	@Test
	void Build2dDoubleArray() throws Exception {
		String sampleInput = "[[1.5,2.3,3.7],[4.2,5.4,6.2],[7.7,8.5,9.9]]";
		double[][] expectedArrayAfterBuild = {{1.5,2.3,3.7},{4.2,5.4,6.2},{7.7,8.5,9.9}};
		double[][] actualStringArrayAfterBuild = ArrayBuilder.string2dDouble(sampleInput);
		assertTrue(Arrays.deepEquals(expectedArrayAfterBuild, actualStringArrayAfterBuild));
	}

}
