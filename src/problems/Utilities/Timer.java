package problems.Utilities;

import java.util.Date;

public class Timer {
	long _startTime;
	
	/**
	 * You can either create a new instance whenever
	 * you want to time something, or you can reset()
	 * an existing instance.
	 */
	public Timer() { this.reset(); }
	
	public void reset() {
		_startTime = this.timeNow();
	}
	
	/**
	 * How many milliseconds have elapsed since the last reset()? 
	 * NB: does not reset the timer!
	 */
	public long timeElapsed() {
		return this.timeNow() - _startTime;
	}

	protected long timeNow() {
		return new Date().getTime();
	}
}