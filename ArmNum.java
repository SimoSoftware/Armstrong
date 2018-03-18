import java.util.*;

public class ArmNum{

	public static Integer[] dividiDigit(int n){
		int qCifre = 1;
		int copia = n;
		ArrayList<Integer> digits = new ArrayList<>();

		while(copia>9){
			copia /= 10;
			qCifre++;
		}
		digits.add(new Integer(copia));

		while(qCifre>1){
			if(copia!=0){
				n = n % (copia*(int)Math.pow(10,--qCifre));
				copia = n;
			}
			if(copia<Math.pow(10,qCifre-1)){
				qCifre--;
				digits.add(new Integer(0));
				//System.out.println("0");
				if(qCifre==1)
					digits.add(new Integer(copia));
			}else{
				while(copia>9) copia /= 10;
				//System.out.println("Copia "+copia);
				digits.add(new Integer(copia));
			}
		}
		return digits.toArray(new Integer[digits.size()]);
	}
	public static boolean isArmNum(int n){
		Integer[] cifre = dividiDigit(n);
		int       sum   = 0;

		for(int i=0; i<cifre.length; i++)
			sum += Math.pow(cifre[i].intValue(), cifre.length);

		return (sum==n? true : false);
	}

	public static void main(String[] args){
		int     num   = 0,
				range = 0;
		Scanner in = new Scanner(System.in);

		System.out.print("Inserire numero intero => ");
		num = in.nextInt();

		if(isArmNum(num)) System.out.println("E` un numero di Armstrong.");
		else System.out.println("Non e` un numero di Armstrong.");

		System.out.println("Stampo tutti i numeri di Armstrong fino al ? => ");
		range = in.nextInt();

		for(int i=0, j=1; i<range; i++)
			if(isArmNum(i))
				System.out.println("ArmNum "+ (j++) +" "+ + i);
	}
}
