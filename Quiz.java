package Hello;

import java.util.*;
import java.io.*;

public class Quiz{
	private String name;
	
	private ArrayList<Question> questions  = new ArrayList<>();
	
	public Quiz(){}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void addQuestion(Question q)
	{
		questions.add(q);
	}
	public static Quiz loadFromFile(String f) throws Exception
	{
		Scanner input;
		try{
			Apple apple = new Apple();

			File file = new File(apple.ReURL());
			input = new Scanner(file);
		}
		catch(FileNotFoundException e){
			System.out.println("Such a file does not exist!");
			return null;
		}
		ArrayList<String> list = new ArrayList<>();
		
		String q = "";
		
		try{
			Quiz quiz = new Quiz();
			
			while(input.hasNext()){
				String n = input.nextLine();
				q = q + n + "\n";
			}
			
			String[] u = q.split("\n\n");
			
			for(String g: u)
			{
				list.add(g);
			}
		
			Collections.shuffle(list);
			
			for(String i : list)
			{
				String[] s = i.split("\n");
				if(s.length==2)
				{
					String h = s[0].replace("{blank}","_______");
					Question t = new Fillin(h,s[1]);
					quiz.addQuestion(t);
				}
				else
				{
					ArrayList<Character> labels = new ArrayList<>();
					
					labels.add('A');labels.add('B');labels.add('C');labels.add('D');
					
					ArrayList<String> mp = new ArrayList<>();
					
					for(int j = 1; j<s.length;j++)
					{
						mp.add(s[j]);
					}
					
					Collections.shuffle(mp);
					
					String[] op = new String[mp.size()];
					
					int x=0;
					String answer = "";
					
					for(String k: mp)
					{
						op[x] = labels.get(x) + ") " + k.replace("{blank}","_______");
						if(k==s[1]){
							answer = labels.get(x) + ") " + k.replace("{blank}","_______");
						}
						x++;
					}
					Question t = new Test(s[0],answer,op,op.length,labels);
					quiz.addQuestion(t);
				}
			}
			return quiz;
		}
	catch(Exception e){
		throw new InvalidQuizFormatException(e.getMessage());
	}


	}
	public String toString()
	{
		return "WELCOME TO " + name + " QUIZ!\n";
	}
	public void start()
	{
		Scanner input = new Scanner(System.in);
		int score =0;
		for(Question quest: questions){
			
			int x =3;
			
			while(x!=0){	
			
				System.out.print(quest);
			
				System.out.print("Enter correct choice: ");
			
				String choice = input.nextLine();
			
				if(choice.toLowerCase().equals(quest.getAnswer().toLowerCase()) || choice.toLowerCase().equals(String.valueOf(quest.getAnswer().charAt(0)).toLowerCase()))
				{
					System.out.println("Correct!\n");
					score++;
					break;
				}
				else
				{
					System.out.println("Incorrect!\n");
					x--;
				}
			}
		}
		
		double percente = (double)(score)/questions.size() * 100;
		System.out.printf("Correct Answer: " + score + "/" + questions.size() + " %.2f", percente);

	}
}