/**
Shalev Yohanan
Apr 21, 2021
*/
package ex2;

public class Polar implements Point2D {
	private double rho;
	private double phi;
	

	public Polar(double rho, double phi) {
		this.rho = rho;
		this.phi = phi;
	}

	@Override
	public double getX() {
		return rho*Math.cos(phi);
	}

	@Override
	public void setX(double x) {
		double y = getY();
		rho = Math.sqrt(x*x + y*y);
		phi = Math.atan(y /x);

	}

	@Override
	public double getY() {
		return rho*Math.sin(phi);
	}

	@Override
	public void setY(double y) {
		double x = getX();
		rho = Math.sqrt(x*x + y*y);
		phi = Math.atan(y / x);
	}

	@Override
	public double getRho() {
		return rho;
	}

	@Override
	public void setRho(double rho) {
		this.rho = rho;
	}

	@Override
	public double getPhi() {
		return phi;
	}
	
	@Override
	public void setPhi(double phi) {
		this.phi = phi;
	}

	@Override
	public double getTanPhi() {
		return Math.tan(phi);
	}

	@Override
	public double distance(Point2D p) {
																					/*return the angle to radians*/
		return Math.sqrt(rho*rho + p.getRho()*p.getRho() - 2*rho*p.getRho()*Math.cos(this.angle(p)*(Math.PI/180)));
	}

	@Override
	public double angle(Point2D p) {
		return (p.getPhi() - getPhi())*180/Math.PI;
	}

	@Override
	public Point2D middle(Point2D p) {
		double midX = (getX() + p.getX()) / 2;
		double midY = (getY() + p.getY()) / 2;
			return new Polar(Math.sqrt(midX*midX + midY*midY), Math.atan(midY/midX));
	}

}
