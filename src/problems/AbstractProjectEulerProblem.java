package problems;

import problems.Utilities.Timer;

public abstract class AbstractProjectEulerProblem {

	public static void main(String[] args) {
		Timer timer = new Timer();

		execute();

		System.out.println("The computation of the solution took " + timer.timeElapsed() + " ms.");
	}
	
	protected static void execute() {

	}

}
