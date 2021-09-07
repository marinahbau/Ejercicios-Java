package modelo;

public class Operaciones {
	int operando_a;
	int operando_b;
	public Operaciones(int operando_a, int operando_b) {
		super();
		this.operando_a = operando_a;
		this.operando_b = operando_b;
	}
	public int getOperando_a() {
		return operando_a;
	}
	public void setOperando_a(int operando_a) {
		this.operando_a = operando_a;
	}
	public int getOperando_b() {
		return operando_b;
	}
	public void setOperando_b(int operando_b) {
		this.operando_b = operando_b;
	}
	
	public int suma() {
		return operando_a+operando_b;
	}
	public int resta() {
		return operando_a-operando_b;
	}
	public int producto() {
		return operando_a*operando_b;
	}
	public int division() {
		return operando_a/operando_b;
	}
}
