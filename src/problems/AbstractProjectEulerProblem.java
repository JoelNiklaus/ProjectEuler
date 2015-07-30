package problems;

import problems.Utilities.EulerTimer;

public abstract class AbstractProjectEulerProblem {

	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();

		execute();

		System.out.println("The computation of the solution took " + timer.timeElapsed() + " ms.");
	}
	
	protected static void execute() {

	}

}
