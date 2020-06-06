
public class Dice {

	public static void main(String[] args) {
		int[][] a = new int[10][10];
		int x,y;
		int[] counter = new int[11];
		
		for(int i = 0; i < 11; i++) {
			counter[i]=0;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				x=randInt();
				y=randInt();
				a[i][j]=x+y;
				System.out.print(a[i][j]+"("+x+","+y+")  ");
				counter[x+y-2]=counter[x+y-2]+1;
			}
			System.out.println("");
		}
		for(int i = 0; i < 11; i++) {
			System.out.println("Frequency of "+(i+2)+ ": "+ counter[i]);
		}

	}	
	private static int randInt() {
		int rand= (int)(Math.random()*((6-1)+1)+1);
		return rand;
	}
}
