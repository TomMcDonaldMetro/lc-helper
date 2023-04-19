package junit.tests;

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

}
