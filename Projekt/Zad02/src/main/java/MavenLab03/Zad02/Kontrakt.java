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
		String liczbaToString = Integer.toString(liczba);
		int option = random.nextInt(3);
		if(option == 0){
			if(liczbaToString.indexOf('3')>=0){
				liczbaToString = liczbaToString.replace('3', '8');
			} else if(liczbaToString.indexOf('7')>=0){
				liczbaToString = liczbaToString.replace('7', '1');
			} else if(liczbaToString.indexOf('6')>=0){
				liczbaToString = liczbaToString.replace('6', '9');
			}
		}
		else if(option == 1){
			if(liczbaToString.indexOf('7')>=0){
				liczbaToString = liczbaToString.replace('7', '1');
			} else if(liczbaToString.indexOf('6')>=0){
				liczbaToString = liczbaToString.replace('6', '9');
			} else if(liczbaToString.indexOf('3')>=0){
				liczbaToString = liczbaToString.replace('3', '8');
			}
		}
		else if(option == 2){
			if(liczbaToString.indexOf('6')>=0){
				liczbaToString = liczbaToString.replace('6', '9');
			} else if(liczbaToString.indexOf('3')>=0){
				liczbaToString = liczbaToString.replace('3', '8');
			} else if(liczbaToString.indexOf('7')>=0){
				liczbaToString = liczbaToString.replace('7', '1');
			}
		}
		return Integer.parseInt(liczbaToString);
	}


	public int Heheszki(int liczba) {
		if(liczba == 0){
			return 0;
		} else if(liczba < 0){
			throw new IllegalArgumentException();
		} else{
			return random.nextInt(liczba);
		}
	}

	public boolean Titit(int liczba_dziel) {
		// TODO Auto-generated method stub
		return false;
	}

}
