package com.operacion.quasar.services;
import org.springframework.stereotype.Service;
import com.operacion.quasar.interfaces.ILocationService;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

@Service
public class LocationService implements ILocationService{
	public double[] getLocation (double [][] positions, double[] distances) {
		TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
		NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());
		
		return nSolver.solve().getPoint().toArray();
	}
}
