/**
Shalev Yohanan
Apr 21, 2021
*/
package ex2;

public class Cartesian implements Point2D {
	private double x;
	private double y;
	
	

	public Cartesian(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double getRho() {
		return Math.sqrt(x*x + y*y);
	}

	@Override
	public void setRho(double rho) {
		double phi = getPhi();
		x = rho * Math.cos(phi);
		y = rho * Math.sin(phi);
	}

	@Override
	public double getPhi() {
		return Math.atan(y/x);
	}

	@Override
	public void setPhi(double phi) {
		double rho = getRho();
		x = rho * Math.cos(phi);
		y = rho * Math.sin(phi);
	}
	
	@Override
	public double getTanPhi() {
		return Math.tan(getPhi());
	}

	@Override
	public double distance(Point2D p) {
		double b = Math.abs(x - p.getX());
		double a = Math.abs(y - p.getY());
		return Math.sqrt(b*b + a*a);
	}

	@Override
	public double angle(Point2D p) {
		return (p.getPhi() - getPhi())*180/Math.PI;
		}

	@Override
	public Point2D middle(Point2D p) {
		return new Cartesian((x + p.getX()) / 2, (y + p.getY()) / 2);
	}

}
