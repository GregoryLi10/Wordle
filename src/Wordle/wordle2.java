package Wordle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class wordle2 {
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
	
	public String game(String guess) {
		w="soare";
		
		if (valid(guess)) {
			return eval(guess, word);
		}
		return null;
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
		return (String[])temp.toArray();
	}
	
	public boolean reducer(String e, String w, String possible, String duplicate) {
		boolean a=true;
		for (int i=0; i<w.length(); i++) {
			if (duplicate.contains(w.charAt(i)+"")) {
				
			}
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
	
	public String eval(String w, String word) {
		String s="";
		for (int i=0; i<w.length(); i++) 
			s+=evaluate(w.charAt(i), i, word);
		return s;
	}
	
	public String eval(String w) {
		String s="";
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
	
//	public static void main(String[] args) {
//		wordle2 run=new wordle2();
//		run.set();
//		run.game("soare");
//	}

}
