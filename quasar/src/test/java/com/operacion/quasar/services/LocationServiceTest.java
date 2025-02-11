package com.operacion.quasar.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.operacion.quasar.utils.Constants;

class LocationServiceTest {

	@Test
	public void getLocation_with_3_position_And_Trilateration_returns_point() {

		double [][] satellitesPosition = new double[][]
		{
			{Constants.kenobi_x, Constants.kenobi_y},
			{Constants.skywalker_x, Constants.skywalker_y},
			{Constants.sato_x, Constants.sato_y}
		};
				
		double [] satellitesDistance = new double[] {8.06, 13.97, 23.32};
		
		double [] expectedResult = new double [] {-157.950157623709, -106.02502322945861};
		
		LocationService locationServiceTest = new LocationService();
		

		double[] result = locationServiceTest.getLocation(satellitesPosition, satellitesDistance);
		

		assertEquals(result.length, 2);
		assertArrayEquals(expectedResult, result, 0);
	}

}
