package Hello;


import java.util.*;

public class Test extends Question{
	
	private String[] option;
	
	private int numOfOPtions;

	private ArrayList<Character> labels;

	public Test(String description, String answer, String[] option, int numOfOPtions, ArrayList<Character> labels)
	{
		super.setDescription(description);
		super.setAnswer(answer);
		this.option = option;
		this.numOfOPtions = numOfOPtions;
		this.labels = labels;
	} 
	public void setOptions(String[] list)
	{
		this.option = list;
	}
	
	public String getOption(int n)
	{
		return option[n];
	}
	public String toString()
	{
		String q = this.getDescription() + "\n";
		
		for(String v : option)
		{
			q=q+v+"\n";
		}
		return q;
	}
}