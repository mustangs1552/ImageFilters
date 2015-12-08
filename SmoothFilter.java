import java.awt.Color;

public class SmoothFilter extends Filter
{
	public SmoothFilter(String name)
	{
    	super(name);
	}
	
	public void apply(OFImage image)
	{
    	int height = image.getHeight();
        int width = image.getWidth();
        for(int x = 0; x < width; x++)
        {
			System.out.println(x);
        	for(int y = 0; y < height; y++)
        	{
				boolean leftEdge = false;
				boolean rightEdge = false;
				boolean topEdge = false;
				boolean botEdge = false;
				
				// Find out where the pixel is
				if(x - 1 < 0) leftEdge = true;
				else if(x + 1 > width) rightEdge = true;
				if(y - 1 < 0) topEdge = true;
				else if(y + 1 > height) botEdge = true;
				
				Color pixel = image.getPixel(x, y);
				int avgRed = pixel.getRed();
				int avgGreen = pixel.getGreen();
				int avgBlue = pixel.getBlue();
				int pixelCount = 1;
				// Top left
				if (!leftEdge && !topEdge)
				{
					pixel = image.getPixel(x - 1, y + 1);
					avgRed += pixel.getRed();
					avgGreen += pixel.getGreen();
					avgBlue += pixel.getBlue();
					pixelCount++;
				}
				// Top
				if(!topEdge)
				{
                	pixel = image.getPixel(x, y + 1);
					avgRed += pixel.getRed();
					avgGreen += pixel.getGreen();
					avgBlue += pixel.getBlue();
					pixelCount++;
				}
				// Top right
				if(!topEdge && !rightEdge)
				{
                	pixel = image.getPixel(x + 1, y + 1);
					avgRed += pixel.getRed();
					avgGreen += pixel.getGreen();
					avgBlue += pixel.getBlue();
					pixelCount++;
				}
				// Left
				if(!leftEdge)
				{
                	pixel = image.getPixel(x - 1, y);
					avgRed += pixel.getRed();
					avgGreen += pixel.getGreen();
					avgBlue += pixel.getBlue();
					pixelCount++;
				}
				// Right
				if(!rightEdge)
				{
                	pixel = image.getPixel(x + 1, y);
					avgRed += pixel.getRed();
					avgGreen += pixel.getGreen();
					avgBlue += pixel.getBlue();
					pixelCount++;
				}
				// Bottom left
				if(!botEdge && !leftEdge)
				{
                	pixel = image.getPixel(x - 1, y - 1);
					avgRed += pixel.getRed();
					avgGreen += pixel.getGreen();
					avgBlue += pixel.getBlue();
					pixelCount++;
				}
				// Bottom
				if(!topEdge)
				{
                	pixel = image.getPixel(x, y - 1);
					avgRed += pixel.getRed();
					avgGreen += pixel.getGreen();
					avgBlue += pixel.getBlue();
					pixelCount++;
				}
				// Bottom right
				if(!topEdge)
				{
                	pixel = image.getPixel(x + 1, y - 1);
					avgRed += pixel.getRed();
					avgGreen += pixel.getGreen();
					avgBlue += pixel.getBlue();
					pixelCount++;
				}
				
				// Find average of each color
				int red = avgRed / pixelCount;
				int green = avgGreen / pixelCount;
				int blue = avgBlue / pixelCount;
				
				// Assign new values
				image.setPixel(x,y, new Color(red, green, blue));
			}
		}
	}
}