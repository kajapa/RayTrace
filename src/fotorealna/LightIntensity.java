package fotorealna;


public class LightIntensity {

	private float r, g, b;
	
	//-------------------------------------------------------------------------------//
	
	// KONSTRUKTOR 
	LightIntensity(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
		if(r < 0) this.r = 0;
		else if(r > 1) this.r = 1;
		if(g < 0) this.g = 0;
		else if(g > 1) this.g = 1;
		if(b < 0) this.b = 0;
		else if(b > 1) this.b = 1;
	}
	
	LightIntensity(float r, float g) {
		this.r = r;
		this.g = g;
		this.b = 0;
		if(r < 0) this.r = 0;
		else if(r > 1) this.r = 1;
		if(g < 0) this.g = 0;
		else if(g > 1) this.g = 1;
	}
	
	LightIntensity(float r) {
		this.r = r;
		this.g = 0;
		this.b = 0;
		if(r < 0) this.r = 0;
		else if(r > 1) this.r = 1;
	}
	
	LightIntensity(LightIntensity lightIntensity) {
		this.r = lightIntensity.getR();
		this.g = lightIntensity.getG();
		this.b = lightIntensity.getB();
	}
	
	LightIntensity() {
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}
	
	// GET
	public float getR() { return this.r; }
	public float getG() { return this.g; }
	public float getB() { return this.b; }
	
	// SET
	public void setR(float value) { 
		this.r = value; 
		if(value < 0) this.r = 0;
		else if(value > 1) this.r = 1;
	}
	public void setG(float value) { 
		this.g = value;
		if(value < 0) this.g = 0;
		else if(value > 1) this.b = 1;
	}
	public void setB(float value) { 
		this.b = value; 
		if(value < 0) this.b = 0;
		else if(value > 1) this.b = 1;
	}
	
	// TO STRING
	@Override public String toString() {
		return "LightIntensity [r=" + r + ", g=" + g + ", b=" + b + "]";
	}
	
	//-------------------------------------------------------------------------------//

	// MNOZENIE PRZEZ ZMIENNA
	public void multiply(float value) {
		this.r *= value;
		this.g *= value;
		this.b *= value;
	}
	
	// DZIELENIE PRZEZ ZMIENNA
	public void divide(float value) {
		if (value != 0) { 
			value = 1 / value;
			this.r *= value;
			this.g *= value;
			this.b *= value;
		}
	}
	
	
	public void add(LightIntensity lightIntensity) {
		this.r += lightIntensity.getR();
		this.g += lightIntensity.getG();
		this.b += lightIntensity.getB();
	}
	
	public void add(LightIntensity lightIntensityA, LightIntensity lightIntensityB) {
		this.r = lightIntensityA.getR() + lightIntensityB.getR();
		this.g = lightIntensityA.getG() + lightIntensityB.getR();
		this.b = lightIntensityA.getB() + lightIntensityB.getR();
	}
	
	
	public void subtract(LightIntensity lightIntensity) {
		this.r -= lightIntensity.getR();
		this.g -= lightIntensity.getG();
		this.b -= lightIntensity.getB();
	}
	
	public void subtract(LightIntensity lightIntensityA, LightIntensity lightIntensityB) {
		this.r = lightIntensityA.getR() - lightIntensityB.getR();
		this.g = lightIntensityA.getG() - lightIntensityB.getR();
		this.b = lightIntensityA.getB() - lightIntensityB.getR();
	}
	
	
	public void multiply(LightIntensity lightIntensity) {
		this.r *= lightIntensity.getR();
		this.g *= lightIntensity.getG();
		this.b *= lightIntensity.getB();
	}
	
	public void multiply(LightIntensity lightIntensityA, LightIntensity lightIntensityB) {
		this.r = lightIntensityA.getR() * lightIntensityB.getR();
		this.g = lightIntensityA.getG() * lightIntensityB.getR();
		this.b = lightIntensityA.getB() * lightIntensityB.getR();
	}
	
	
	public void divide(LightIntensity lightIntensity) {
		if(lightIntensity.getR() != 0 && lightIntensity.getG() != 0 && lightIntensity.getB() != 0) {
			this.r /= lightIntensity.getR();
			this.g /= lightIntensity.getG();
			this.b /= lightIntensity.getB();
		}
	}
	
	public void divide(LightIntensity lightIntensityA, LightIntensity lightIntensityB) {
		if(lightIntensityB.getR() != 0 && lightIntensityB.getG() != 0 && lightIntensityB.getB() != 0) {
			this.r = lightIntensityA.getR() / lightIntensityB.getR();
			this.g = lightIntensityA.getG() / lightIntensityB.getG();
			this.b = lightIntensityA.getB() / lightIntensityB.getB();
		}
	}
	
	// CZY ROWNY
	public boolean isEqual(LightIntensity lightIntensity) {
		return ((this.r == lightIntensity.getR()) && (this.g == lightIntensity.getG()) && (this.b == lightIntensity.getB()));
	}
	
	public boolean isNotEqual(LightIntensity lightIntensity) {
		return !(isEqual(lightIntensity));
	}
	
	public boolean isEqualContrast(LightIntensity B, LightIntensity C, LightIntensity D) {
		float contrast = 0.05f;
		return ( (this.r - B.getR() < contrast) && (this.g - B.getG() < contrast) && (this.b - B.getB() < contrast) &&
				 (this.r - C.getR() < contrast) && (this.g - C.getG() < contrast) && (this.b - C.getB() < contrast) &&
				 (this.r - D.getR() < contrast) && (this.g - D.getG() < contrast) && (this.b - D.getB() < contrast) );
	}
}
