package soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;	
	private List<Track> trackList = new ArrayList<Track>();
	
	//	Constructor
	public CompactDisc() 
	{
		super();
	}
	public CompactDisc(String title, String category)
	{
		super(title, category);
	}
	//
	public String getArtist() 
	{
		return artist;
	}
	
	public boolean addTrack(Track track)
	{
		if (trackList.contains(track))
			return false;
		trackList.add(track);
		this.length = getLength();
		return true;
	}

	public boolean removeTrack(Track track)
	{
		if (trackList.contains(track))
		{
			trackList.remove(track);
			this.length = getLength();
			return true;
		}
		return false;
	}
	
	public int getLength() 
	{
		if (trackList == null)
			return 0;
		int length = 0;
		for (int i = 0; i < trackList.size(); i++)
		{
			length += trackList.get(i).getLength();
		}
		return length;
	}
	@Override
	public void Play() 
	{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length " + getLength());
	}
}
