package MavenLab03.Zad02;
import java.util.Random;
public class Kontrakt implements Psikus {

	private Random random = new Random();
	
	public int CyfroKrad(int liczba) {
		if(liczba <= 9 && liczba >= -9){
			return (Integer) null;
		} else {
			if(liczba > 0){
				String liczbaToString = Integer.toString(liczba);
				int position = random.nextInt(liczbaToString.length());
				return (Integer.parseInt(liczbaToString.substring(0,position)+liczbaToString.substring(position+1)));
		
			} else {
				String liczbaToString = Integer.toString(liczba);
				int position = random.nextInt(liczbaToString.length()-1)+1;
				return (Integer.parseInt(liczbaToString.substring(0,position)+liczbaToString.substring(position+1)));
			}
		}  
	}

	public int HultajChochla(int liczba) throws NieudanyPsikusException {
		if(liczba >=9 && liczba<=-9){
			throw new NieudanyPsikusException();
		} else {
			if(liczba > 0){
				char tmp = 0;
				String liczbaToString = Integer.toString(liczba);
				int firstDigit = random.nextInt(liczbaToString.length());
				int secondDigit =  random.nextInt(liczbaToString.length());
				char[] liczbaArray = liczbaToString.toCharArray();
				tmp = liczbaArray[firstDigit];
				liczbaArray[firstDigit] =  liczbaArray[secondDigit];
				liczbaArray[secondDigit] = tmp;
				return Integer.parseInt(String.valueOf(liczbaArray));
				
			} else {
				char tmp = 0;
				String liczbaToString = Integer.toString(liczba);
				int firstDigit = random.nextInt(liczbaToString.length()-1)+1;
				int secondDigit =  random.nextInt(liczbaToString.length()-1)+1;
				char[] liczbaArray = liczbaToString.toCharArray();
				tmp = liczbaArray[firstDigit];
				liczbaArray[firstDigit] =  liczbaArray[secondDigit];
				liczbaArray[secondDigit] = tmp;
				return Integer.parseInt(String.valueOf(liczbaArray));
			}
		}
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
