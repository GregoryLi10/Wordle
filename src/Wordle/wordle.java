package Wordle;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class wordle {
	Scanner in=new Scanner(System.in);
	public String[] words;
	private String word;
	private String w="";
	
	public void set() {
		System.out.println("Rules: Try to guess a 5 letter word, enter valid 5 letter words and it will return o, x, or -.\n'o' means the letter is in the word and in the right position.\n'x' means the letter is in the word in the wrong position.\n'-' means the letter is not in the word.");
		getWordList();
		word=words[(int) (Math.random()*words.length)];
		System.out.println(word);
	}
	
	public void game() {
		set();
		for (int i=0; i<6; i++) {
			System.out.print("Enter a 5 letter word: ");
			w=in.next();
			while (!valid(w)) {
				System.out.print("Enter a valid 5 letter word: ");
				w=in.next();
			}
			w=w.toLowerCase();
			System.out.println(eval(w));
			if (eval(w).equals("ooooo")) {
				System.out.println("You win!"); return;
			}
		}
		System.out.println("You lose, the word was "+word);
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
	
	public String[] getWordList() {
		ArrayList<String> arr = new ArrayList<String>();
		BufferedReader reader;
		try{
			String line = "";
			reader = new BufferedReader(new FileReader("words"));
			while((line = reader.readLine())!=null) {
				arr.add(line);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		words=new String[arr.size()];
		for (int i=0; i<words.length; i++) 
			words[i]=arr.get(i);
		return words;
	}
	
	public String eval(String w) {
		String s="";
		if (w.chars().filter(e-> Collections.frequency(w.chars().boxed().collect(Collectors.toList()), e) > 1).count() > 1) {
			char[] g=w.toCharArray();
			Arrays.sort(g);
			String dup="";
			for (int i=1; i<g.length; i++) {
				if (g[i]==g[i-1]&&!dup.contains(g[i]+"")) dup+=g[i];
			}
			for (int i=0; i<w.length(); i++) {
				if (!dup.contains(w.charAt(i)+"")) s+=evaluate(w.charAt(i), i, word);
				else if (evaluate(w.charAt(i), i, word)=='o') s+='o';
				else {
//					for (int j=i+1; j<w.length(); j++) if (w.charAt(j)==w.charAt(i)&&evaluate(w.charAt(j)=='o'))
				}
			}
		}
		for (int i=0; i<w.length(); i++) 
			s+=evaluate(w.charAt(i), i, word);
		return s;
	}
	
	public boolean valid(String w) {
		w=w.toLowerCase();
		return w.length()==5&&val(word);
	}
	
	public boolean val(String w) {
		for (int i=0; i<words.length; i++) {
			if (w.equals(words[i])) return true;
		}
		return false;
	}
	
	private char evaluate(char a, int i, String word) {
		if (a==word.charAt(i)) return 'o';
		for (int j=0; j<word.length(); j++) {
			if (a==word.charAt(j)) return 'x';
		}
		return '-';
	}
	
	public static void main(String[] args) {
		wordle run=new wordle();
		run.game();
	}

}
