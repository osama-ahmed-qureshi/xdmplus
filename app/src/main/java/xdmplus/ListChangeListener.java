package xdmplus;

public interface ListChangeListener {
	public void listChanged();

	public void listItemUpdated(String id);
}
