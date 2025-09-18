import java.awt.*;

public class BigRectangleFilter implements Filter {

    @Override
    public boolean accept(Object X)
    {
        boolean ret = false;
        double perimeter = 0;
        Rectangle r = (Rectangle)X;

        perimeter = 2 * r.getHeight() + 2 * r.getWidth();

        if(perimeter > 10)
            ret = true;

        return ret;
    }
}
