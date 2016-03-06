package MavenLab03.Zad02;
import java.util.Random;
public class Kontrakt implements Psikus {
/*Metoda CyfroKrad działa w ten sposób, że w liczbie przekazanej jako argument, usuwa
losowo jedną cyfrę. Gdy jednocyfrowa zwraca null.*/
	private Random random = new Random();
	public int CyfroKrad(int liczba) {
		if(liczba <= 9 && liczba >= -9){
			return (Integer) null;
		} else {
			String liczbaToString = Integer.toString(liczba);
			int position = random.nextInt(liczbaToString.length());
	        return (Integer.parseInt(liczbaToString.substring(0,position)+liczbaToString.substring(position+1)));
		}  
	}

	public int HultajChochla(int liczba) throws NieudanyPsikusException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Nieksztaltek(int liczba) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Heheszki(int liczba) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean Titit(int liczba_dziel) {
		// TODO Auto-generated method stub
		return false;
	}

}
