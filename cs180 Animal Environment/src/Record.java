public class Record<T>
{
    private final int x, y;
    private final T data;

    public Record( int x, int y, T data )
    {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    public T getData()      { return data; }
    public int getX()       { return x; }
    public int getY()       { return y; }
}
