import java.util.Scanner;

public class AtmExample {
	
	public static void main(String[] args) {
		int bakiye = 200;
		int yatirma = 1;
		int cekme = 2;
		while (true) {
			System.out.println("muzaffer toplam bakiye : " + bakiye);
			System.out.println("para yatirmak için 1 'e basin. ");
			System.out.println("para çekmek  için 2 'e basin. ");
			System.out.println("çıkış için 3 'e basin. ");
			Scanner in = new Scanner(System.in);
			
			int islem = in.nextInt();
			
			if (islem == yatirma) {
				bakiye = paraYatir(bakiye);
			} else if (islem == cekme) {
				bakiye = paraCek(bakiye);
			} else if (islem == 3) {
				break;
			} else {
				System.out.println("geçersiz işlem");
			}
		}
	}
	
	public static int paraCek(int bakiye) {
		Scanner in = new Scanner(System.in);
		System.out.println("Ne kadar çekmek istiyorsun? : ");
		int cekmeTutari = in.nextInt();
		if (cekmeTutari <= bakiye) {
			System.out.println(cekmeTutari + " tutarı bölmeden alabilirsiniz");
			bakiye = bakiye - cekmeTutari;
		} else {
			System.out.println("Bakiyeniz yetersiz " + bakiye + " kadar para çekebilirsin");
		}
		return bakiye;
	}
	
	public static int paraYatir(int bakiye) {
		Scanner in = new Scanner(System.in);
		System.out.println("Ne kadar yatirmak istiyorsun? : ");
		int yatirmaTutari = in.nextInt();
		bakiye = bakiye + yatirmaTutari;
		
		return bakiye;
	}
	
}
