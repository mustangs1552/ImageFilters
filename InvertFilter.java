import java.awt.Color;

public class InvertFilter extends Filter
{
	public InvertFilter(String name)
	{
		super(name);
	}
	
	public void apply(OFImage image)
	{
		int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++)
		{
            for(int x = 0; x < width; x++)
			{
                Color pixel = image.getPixel(x, y);
                int r = 255 - pixel.getRed();
                int g = 255 - pixel.getGreen();
                int b = 255 - pixel.getBlue();
                image.setPixel(x, y, new Color(r, g, b));
            }
        }
	}
}