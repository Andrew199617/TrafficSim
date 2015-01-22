package edu.cs150;

public interface IListener {
	
	public void enteringIntersection();
	public void leavingIntersection();
	public void goneIntersection();
	public void setTest(boolean test);
	public boolean getTest();
	void approachingIntersection();
}
