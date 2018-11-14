package finiestab;

public class Jugador implements Comparable<Jugador>{

	String nombre;
	int score;
	public Jugador(String nombre, int score) {
		this.nombre = nombre;
		this.score = score;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public int compareTo(Jugador j) {
		
            if (score < j.score) {
                return 1;
            }
            if (score > j.score) {
                return -1;
            }
            return 0;
        }
	
	
	
}
