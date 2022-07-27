package Wordle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class wordleBotInterface {
	Scanner in=new Scanner(System.in);
	private wordle2 wordle=new wordle2();
	private String w="raise", h;
	public void run() {
		String[] words=wordle.getWordList(), possible=words;
		System.out.print("Word: ");
		w=in.next();
		while (possible.length!=1) {
			System.out.println("Word: "+w);
			System.out.print("Hint: ");
			h=in.next();
			String[] prev=possible;
			possible=reduce(h, w, possible);
			System.out.println(Arrays.toString(possible)+"\n"+possible.length);
			int[][]matrix=new int[words.length][possible.length];
			int[] max=new int[words.length];
			int min=possible.length, index=0;
			if (possible.length==1) {
				return;
			}
			else if (possible.length==2) {
				w=possible[0]; continue;
			}
			else if (possible.length==0) {
				possible=prev;
				continue;
			}
			for (int k=0; k<matrix.length; k++) {
				if (k/100!=(k-1)/100) System.out.print(k/100+" ");
				for (int j=0; j<matrix[k].length; j++) {
					if (words[k].equals(possible[j])) matrix[k][j]=1;
					else { 
						matrix[k][j]=reduce(wordle.eval(words[k], possible[j]), words[k], possible).length;
					}
					if (matrix[k][j]>max[k]) max[k]=matrix[k][j];
				}
				if (max[k]<min) {
					min=max[k];
					index=k;
				}
			}
			System.out.println("\n"+words[index]);
			w=words[index];
		}
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
		wordleBotInterface bot=new wordleBotInterface();
		bot.run();
	}
}
