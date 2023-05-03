package Hello;


public class Fillin extends Question{
	public Fillin(String description, String answer){
		
		super.setDescription(description);
		
		super.setAnswer(answer);
	}
	public String toString()
	{
		return this.getDescription()+"\n";
	}
}