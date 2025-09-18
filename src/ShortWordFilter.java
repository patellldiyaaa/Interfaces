public class ShortWordFilter implements Filter
{
    @Override
    public boolean accept (Object X)
    {
        String s = (String) X;
        boolean ret = false;

        if(s.length() < 5)
            ret = true;

        return ret;

    }
}
