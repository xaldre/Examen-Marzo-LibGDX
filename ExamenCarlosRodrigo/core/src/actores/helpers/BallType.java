package actores.helpers;

public enum BallType {
	amarilla("amarilla", 20),
	azul("azul", 20),
	bolon("bolon",40),
	naranja("naranja", 20), 
	roja("roja", 20), 
	verde("verde", 20);

	private String color;
	private int size;

	private BallType(String color, int size) {
		this.color = "bola" + color;
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public int getSize() {
		return size;
	}

}
