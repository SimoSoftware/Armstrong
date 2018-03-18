import java.util.*;

public class ArmS{
	public static boolean isArm(String num){
		int cifre = num.length(),
			sum   = 0;

		for(int i=0; i<cifre; i++)
			sum += Math.pow( num.charAt(i)-'0', cifre );
		if(sum == Integer.parseInt(num))
			return true;
		else return false;
	}
	public static boolean isArm(int num){
		return isArm(Integer.toString(num));
	}
	public static void main(String[] args) {
		String  num   = null;
		int     range = 0;
		Scanner in    = new Scanner(System.in);

		System.out.println("Inserire numero => ");
		num = in.next();

		if(!isArm(num))
			System.out.print("Non ");
		System.out.println("e` un numero di Armstrong");

		System.out.println("Inserire range => ");
		range = in.nextInt();

		for(int i=0, j=1; i<=range; i++)
			if( isArm(i) )
				System.out.println("Numero arm "+(j++)+" "+i);
	}
}
