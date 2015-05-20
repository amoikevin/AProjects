package android.anthology.models;

public class Poetry
{
	private String title;
	private String author;
	private String album;
	private String[] lines;
	private String phrases;
	private String info;
	private String notes;

	public String getTitle()
	{
		return title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(final String author)
	{
		this.author = author;
	}

	public String getAlbum()
	{
		return album;
	}

	public void setAlbum(final String album)
	{
		this.album = album;
	}

	public String[] getLines()
	{
		return lines;
	}

	public void setLines(final String[] lines)
	{
		this.lines = lines;
	}

	public String getPhrases()
	{
		return phrases;
	}

	public void setPhrases(final String phrases)
	{
		this.phrases = phrases;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(final String info)
	{
		this.info = info;
	}

	public String getNotes()
	{
		return notes;
	}

	public void setNotes(final String notes)
	{
		this.notes = notes;
	}

}
