package soict.hedspi.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public int getLength() 
	{
		return length;
	}

	public void setLength(int length) 
	{
		this.length = length;
	}

	public Track() 
	{
	}
	@Override
	public void Play()
	{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length " + this.getLength());
	}
}
