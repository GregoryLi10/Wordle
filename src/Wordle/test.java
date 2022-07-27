package Wordle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
	private String a="ooooo\n"
			+ "oooox\n"
			+ "oooo-\n"
			+ "oooxo\n"
			+ "oooxx\n"
			+ "ooox-\n"
			+ "ooo-o\n"
			+ "ooo-x\n"
			+ "ooo--\n"
			+ "ooxoo\n"
			+ "ooxox\n"
			+ "ooxo-\n"
			+ "ooxxo\n"
			+ "ooxxx\n"
			+ "ooxx-\n"
			+ "oox-o\n"
			+ "oox-x\n"
			+ "oox--\n"
			+ "oo-oo\n"
			+ "oo-ox\n"
			+ "oo-o-\n"
			+ "oo-xo\n"
			+ "oo-xx\n"
			+ "oo-x-\n"
			+ "oo--o\n"
			+ "oo--x\n"
			+ "oo---\n"
			+ "oxooo\n"
			+ "oxoox\n"
			+ "oxoo-\n"
			+ "oxoxo\n"
			+ "oxoxx\n"
			+ "oxox-\n"
			+ "oxo-o\n"
			+ "oxo-x\n"
			+ "oxo--\n"
			+ "oxxoo\n"
			+ "oxxox\n"
			+ "oxxo-\n"
			+ "oxxxo\n"
			+ "oxxxx\n"
			+ "oxxx-\n"
			+ "oxx-o\n"
			+ "oxx-x\n"
			+ "oxx--\n"
			+ "ox-oo\n"
			+ "ox-ox\n"
			+ "ox-o-\n"
			+ "ox-xo\n"
			+ "ox-xx\n"
			+ "ox-x-\n"
			+ "ox--o\n"
			+ "ox--x\n"
			+ "ox---\n"
			+ "o-ooo\n"
			+ "o-oox\n"
			+ "o-oo-\n"
			+ "o-oxo\n"
			+ "o-oxx\n"
			+ "o-ox-\n"
			+ "o-o-o\n"
			+ "o-o-x\n"
			+ "o-o--\n"
			+ "o-xoo\n"
			+ "o-xox\n"
			+ "o-xo-\n"
			+ "o-xxo\n"
			+ "o-xxx\n"
			+ "o-xx-\n"
			+ "o-x-o\n"
			+ "o-x-x\n"
			+ "o-x--\n"
			+ "o--oo\n"
			+ "o--ox\n"
			+ "o--o-\n"
			+ "o--xo\n"
			+ "o--xx\n"
			+ "o--x-\n"
			+ "o---o\n"
			+ "o---x\n"
			+ "o----\n"
			+ "xoooo\n"
			+ "xooox\n"
			+ "xooo-\n"
			+ "xooxo\n"
			+ "xooxx\n"
			+ "xoox-\n"
			+ "xoo-o\n"
			+ "xoo-x\n"
			+ "xoo--\n"
			+ "xoxoo\n"
			+ "xoxox\n"
			+ "xoxo-\n"
			+ "xoxxo\n"
			+ "xoxxx\n"
			+ "xoxx-\n"
			+ "xox-o\n"
			+ "xox-x\n"
			+ "xox--\n"
			+ "xo-oo\n"
			+ "xo-ox\n"
			+ "xo-o-\n"
			+ "xo-xo\n"
			+ "xo-xx\n"
			+ "xo-x-\n"
			+ "xo--o\n"
			+ "xo--x\n"
			+ "xo---\n"
			+ "xxooo\n"
			+ "xxoox\n"
			+ "xxoo-\n"
			+ "xxoxo\n"
			+ "xxoxx\n"
			+ "xxox-\n"
			+ "xxo-o\n"
			+ "xxo-x\n"
			+ "xxo--\n"
			+ "xxxoo\n"
			+ "xxxox\n"
			+ "xxxo-\n"
			+ "xxxxo\n"
			+ "xxxxx\n"
			+ "xxxx-\n"
			+ "xxx-o\n"
			+ "xxx-x\n"
			+ "xxx--\n"
			+ "xx-oo\n"
			+ "xx-ox\n"
			+ "xx-o-\n"
			+ "xx-xo\n"
			+ "xx-xx\n"
			+ "xx-x-\n"
			+ "xx--o\n"
			+ "xx--x\n"
			+ "xx---\n"
			+ "x-ooo\n"
			+ "x-oox\n"
			+ "x-oo-\n"
			+ "x-oxo\n"
			+ "x-oxx\n"
			+ "x-ox-\n"
			+ "x-o-o\n"
			+ "x-o-x\n"
			+ "x-o--\n"
			+ "x-xoo\n"
			+ "x-xox\n"
			+ "x-xo-\n"
			+ "x-xxo\n"
			+ "x-xxx\n"
			+ "x-xx-\n"
			+ "x-x-o\n"
			+ "x-x-x\n"
			+ "x-x--\n"
			+ "x--oo\n"
			+ "x--ox\n"
			+ "x--o-\n"
			+ "x--xo\n"
			+ "x--xx\n"
			+ "x--x-\n"
			+ "x---o\n"
			+ "x---x\n"
			+ "x----\n"
			+ "-oooo\n"
			+ "-ooox\n"
			+ "-ooo-\n"
			+ "-ooxo\n"
			+ "-ooxx\n"
			+ "-oox-\n"
			+ "-oo-o\n"
			+ "-oo-x\n"
			+ "-oo--\n"
			+ "-oxoo\n"
			+ "-oxox\n"
			+ "-oxo-\n"
			+ "-oxxo\n"
			+ "-oxxx\n"
			+ "-oxx-\n"
			+ "-ox-o\n"
			+ "-ox-x\n"
			+ "-ox--\n"
			+ "-o-oo\n"
			+ "-o-ox\n"
			+ "-o-o-\n"
			+ "-o-xo\n"
			+ "-o-xx\n"
			+ "-o-x-\n"
			+ "-o--o\n"
			+ "-o--x\n"
			+ "-o---\n"
			+ "-xooo\n"
			+ "-xoox\n"
			+ "-xoo-\n"
			+ "-xoxo\n"
			+ "-xoxx\n"
			+ "-xox-\n"
			+ "-xo-o\n"
			+ "-xo-x\n"
			+ "-xo--\n"
			+ "-xxoo\n"
			+ "-xxox\n"
			+ "-xxo-\n"
			+ "-xxxo\n"
			+ "-xxxx\n"
			+ "-xxx-\n"
			+ "-xx-o\n"
			+ "-xx-x\n"
			+ "-xx--\n"
			+ "-x-oo\n"
			+ "-x-ox\n"
			+ "-x-o-\n"
			+ "-x-xo\n"
			+ "-x-xx\n"
			+ "-x-x-\n"
			+ "-x--o\n"
			+ "-x--x\n"
			+ "-x---\n"
			+ "--ooo\n"
			+ "--oox\n"
			+ "--oo-\n"
			+ "--oxo\n"
			+ "--oxx\n"
			+ "--ox-\n"
			+ "--o-o\n"
			+ "--o-x\n"
			+ "--o--\n"
			+ "--xoo\n"
			+ "--xox\n"
			+ "--xo-\n"
			+ "--xxo\n"
			+ "--xxx\n"
			+ "--xx-\n"
			+ "--x-o\n"
			+ "--x-x\n"
			+ "--x--\n"
			+ "---oo\n"
			+ "---ox\n"
			+ "---o-\n"
			+ "---xo\n"
			+ "---xx\n"
			+ "---x-\n"
			+ "----o\n"
			+ "----x\n"
			+ "-----\n";
	public void tester() throws IOException {
		File file = new File("tester");
//		FileWriter writer = new FileWriter(file);
		String[] hints=a.split("\n");
		wordle2 run=new wordle2();
		run.getWordList();
		ArrayList<String> arr = new ArrayList<String>();
		BufferedReader reader;
		try{
			String line = "";
			reader = new BufferedReader(new FileReader("tester"));
			int i=0;
			int[] max=new int[run.words.length];
			while((line = reader.readLine())!=null) {
				if (!line.contains(" ")) continue;
				String[] a=line.split(" ");
				for (int j=0; j<a.length; j++) {
					try{
						max[i]=Integer.parseInt(a[j]) > max[i]  ? Integer.parseInt(a[j]) : max[i];
			        }
			        catch (NumberFormatException ex){
			            continue;
			        }
				}
				i++;
			}
			int min=max[0];
			int[] ind=new int[run.words.length];
			for (int j=1; j<max.length; j++) 
				min=max[j]<min?max[j]:min;
			for (int j=0, k=0; j<max.length; j++) {
				if (max[j]==min) {
					ind[k]=j; k++;
				}
			}
			System.out.println(Arrays.toString(ind));
			System.out.println(run.words[105]);
			System.out.println(run.words[1534]);
			System.out.println(run.words[2428]);
			System.out.println(run.words[9729]);
			System.out.println(run.words[10424]);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
//		String[] lines=new String[arr.size()];
//		for (int i=0; i<lines.length; i++) 
//			lines[i]=arr.get(i);
//		System.out.println(Arrays.toString(lines));
//		System.out.println(lines.length);
//		for (int i=0; i<run.words.length; i++) {
//			int sum=0, c=hints.length;
////			System.out.print(run.words[i]+" ");
////			writer.write(run.words[i]+" ");
//			for (int j=0; j<hints.length; j++) {
//				int t=run.reduce(hints[j], run.words[i], run.words).length;
////				System.out.print(t+" ");
////				writer.write(t+" ");
//				sum+=t;
//				if (t==0) c--;
//			}
//			if (sum/c<min) {
//				min=sum/c; index=i;
//			}
//			System.out.println("\n"+sum/c);
//			writer.write("\n"+sum/c+"\n");
//		}
//		writer.write(run.words[index]+" "+min);
//		System.out.println(run.words[index]+" "+min);
//		writer.close();
	}
	
	public static void main (String[] args) {
		test runner=new test();
		try {
			runner.tester();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
