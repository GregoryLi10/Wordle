package Wordle;
import java.util.Arrays;

public class wordleBot {
	private wordle2 wordle=new wordle2();
	private String w="raise";
	public void run() {
		wordle.set();
		String[] words=wordle.getWordList();
		String[] possible=words;
		String a="";
		w=reduce(wordle.game("soare"), "soare",words).length>reduce(wordle.game("raise"), "raise",words).length?"raise":"soare";
		a=wordle.game(w);
		System.out.println(w+"\n"+a);
//		if (a==null) i--;
		possible=reduce(a, w, possible);
		System.out.println(Arrays.toString(possible)+"\n"+possible.length);
		for (int c=0; c<6; c++) {
			int[][]matrix=new int[words.length][possible.length];
			int[] max=new int[words.length];
			int min=possible.length, index=0;
			if (possible.length==1) {
				break;
			}
			else if (possible.length==2) {
				a=wordle.game(possible[0]);
				String temp=possible[1], temp1=possible[0];
				possible=new String[1];
				possible[0]=temp;
				if (a.equals("ooooo")) {
					System.out.println(temp1+"\n"+a+"\n["+temp1+"]\n"+possible.length);
					return;
				}
				System.out.println(temp1+"\n"+a+"\n"+Arrays.toString(possible)+"\n"+possible.length);
				break;
			}
			for (int i=0; i<matrix.length; i++) {
				if (i/100!=(i-1)/100) System.out.print(i/100+" ");
				for (int j=0; j<matrix[i].length; j++) {
					if (words[i].equals(possible[j])) matrix[i][j]=1;
					else { 
						matrix[i][j]=reduce(wordle.eval(words[i], possible[j]), words[i], possible).length;
					}
					if (matrix[i][j]>max[i]) max[i]=matrix[i][j];
				}
				if (max[i]<min) {
					min=max[i];
					index=i;
				}
			}
			System.out.println();
			a=wordle.game(words[index]);
			possible=reduce(wordle.eval(words[index]), words[index], possible);
			System.out.println(words[index]+"\n"+a+"\n"+Arrays.toString(possible)+"\n"+possible.length);
			if (a.equals("ooooo")) return;
		}
		a=wordle.game(possible[0]);
		System.out.println(possible[0]+"\n"+a+"\n"+Arrays.toString(possible)+"\n"+possible.length);
	}
	
	public String[] reduce(String e, String w, String[] possible) {
		String[] temp=new String[possible.length]; boolean[] a=new boolean[possible.length];
		for (int i=0; i<possible.length; i++) {
			a[i]=reducer(e, w, possible[i]);
		}
		for (int i=0, j=0; i<a.length; i++, j++) {
			if (a[i]) temp[j]=possible[i];
			else j--;
		}
		int t=temp.length;
		for (int i=0; i<temp.length; i++) {
			if (temp[i]==null) {
				t=i; break;
			}
		}
		possible=new String[t];
		for (int i=0; i<possible.length; i++) {
			possible[i]=temp[i];
		}
		return possible;
	}
	
	public boolean reducer(String e, String w, String possible) {
		boolean a=true;
		for (int i=0; i<w.length(); i++) {
			if (e.charAt(i)=='o') {
				a=possible.charAt(i)==w.charAt(i); 
			}
			else if (e.charAt(i)=='x') {
				a=possible.contains(w.charAt(i)+"")&&w.charAt(i)!=possible.charAt(i);
			}
			else {
				a=!possible.contains(w.charAt(i)+"");
			}
			if (!a) return false;
		}
		return true;
	}
	
	public static void main (String[] args) {
		wordleBot bot=new wordleBot();
		bot.run();
	}
}
