package Wordle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class accurateWordleBot {
	Scanner in=new Scanner(System.in);
	private wordle3 wordle=new wordle3();
	private String w="raise", h;
	public void run() {
		String[] words=wordle.getWordList(), possible=words;
		System.out.print("Word: ");
		w=in.next();
		while (possible.length!=1) {
			System.out.print("Hint: ");
			h=in.next();
			String[] prev=possible;
			possible=reduce(h, w, possible);
			System.out.println(Arrays.toString(possible)+"\n"+possible.length);
			int[][]matrix=new int[words.length][possible.length];
			int[] max=new int[words.length];
			int[] min=new int[5], index=new int[5]; //number of "best guesses" you want
			Arrays.fill(min, possible.length); 
			if (possible.length==1) {
				return;
			}
			else if (possible.length==2) {
				System.out.print("Word: ");
				w=in.next(); continue;
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
				for (int i=0; i<min.length; i++) {
					if (max[k]<min[i]) {
						min[i]=max[k];
						index[i]=k;
						break;
					}
				}
			}
			System.out.println();
			ArrayList<String> guesses=new ArrayList<String>();
			for (int z:index)
				guesses.add(words[z]);
			System.out.println("Best guesses: "+guesses);
			System.out.print("Word: ");
			w=in.next();
		}
	}
	
	public String[] reduce(String ev, String w, String[] possible) {
		ArrayList<String> temp=new ArrayList<String>(); String dup="";
		if (w.chars().filter(e-> Collections.frequency(w.chars().boxed().collect(Collectors.toList()), e) > 1).count() > 1) {
			char[] duplicateFinder=w.toCharArray(); 
			Arrays.sort(duplicateFinder);
			for (int i=1; i<duplicateFinder.length; i++) 
				if (duplicateFinder[i]==duplicateFinder[i-1]&&!dup.contains(duplicateFinder[i]+"")) 
					dup+=duplicateFinder[i];
		}
		for (int i=0; i<possible.length; i++) 
			if (reducer(ev, w, possible[i], dup)) 
				temp.add(possible[i]);
		return temp.toArray(new String[temp.size()]);
	}
	
	public boolean reducer(String e, String w, String possible, String duplicate) {
		ArrayList<Character> dup=new ArrayList<Character>(); boolean a=true;
		for (int i=0; i<w.length(); i++) {
			if (duplicate.contains(w.charAt(i)+"")) Collections.addAll(dup, (char)i, w.charAt(i));
			else if (e.charAt(i)=='o') a=possible.charAt(i)==w.charAt(i); 
			else if (e.charAt(i)=='x') a=possible.contains(w.charAt(i)+"")&&w.charAt(i)!=possible.charAt(i);
			else a=!possible.contains(w.charAt(i)+"");
			if (!a) return false;
		}
		dup.sort(null); //w is guess, possible is possible answer || tints tears o---o
		for (int i=0; i<duplicate.length(); i++) {
			String s=""; int temp=i;
			for (int j=w.indexOf(duplicate.charAt(i)); j>=0; j=w.indexOf(duplicate.charAt(i), j+1)) 
				s+=e.charAt(j)+","; 
			if (Arrays.asList(s.split(",")).stream().allMatch(t -> t.toLowerCase().contains("-"))&&possible.contains(duplicate.charAt(i)+"")) 
				return false;
			else if (Arrays.asList(s.split(",")).stream().allMatch(t -> t.toLowerCase().contains("-"))&&!possible.contains(duplicate.charAt(i)+""))
				continue;
			if (possible.chars().filter(num -> num==duplicate.charAt(temp)).count()>dup.stream().filter(num->num==duplicate.charAt(temp)).count()) {
				if (s.contains("-")) return false;
				for (int j=0; j<w.length(); j++) {
					if (!duplicate.contains(w.charAt(j)+"")) continue;
					if (e.charAt(j)=='o') a=possible.charAt(j)==w.charAt(j); 
					else if (e.charAt(j)=='x') a=possible.contains(w.charAt(j)+"")&&w.charAt(j)!=possible.charAt(j);
					if (!a) return false;
				}
			} 
			else {
				long c=s.chars().filter(num -> num == 'o').count();
				if (c>possible.chars().filter(num -> num==duplicate.charAt(temp)).count()) return false;
				if (c==possible.chars().filter(num -> num==duplicate.charAt(temp)).count()) {
					if (s.contains("x")) return false;
				}
				else if (c==0&&s.charAt(0)=='-') 
					return false;
				else {
					for (int j=0; j<s.split(",").length; j++) {
						if (s.split(",")[j].equals("x")) c++;
						if (c!=possible.chars().filter(num -> num==duplicate.charAt(temp)).count()) 
							return false;
					}
				}
				for (int j=0; j<w.length(); j++) {
					if (!duplicate.contains(w.charAt(j)+"")) continue;
					if (e.charAt(j)=='o') a=possible.charAt(j)==w.charAt(j); 
					else if (e.charAt(j)=='x') a=possible.contains(w.charAt(j)+"")&&w.charAt(j)!=possible.charAt(j);
				}
			}
			if (!a) return false;
		}
		return true;
	}
	
	public static void main (String[] args) {
		accurateWordleBot bot=new accurateWordleBot();
		bot.run();
	}
}
