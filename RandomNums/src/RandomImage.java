/**
 * File: RandomImage.java
 * 
 * Description:
 * Create a random color image.
 * 
 * @author Yusuf Shakeel
 * Date: 01-04-2014 tue
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class RandomImage{
  public static void main(String args[])throws IOException{
	  HttpURLConnectionExample httpURLConnectionExample = new HttpURLConnectionExample();
	  int numOfRequests = 4;
	  int numPerRequest = 10000; //max
	  //making Java object instead of primitive
	  ArrayList<Integer> bigNumArray = new ArrayList<Integer>(numOfRequests*numPerRequest);
	  
	  for(int i = 0; i < numOfRequests; i++){
		  httpURLConnectionExample.sendGET();
		  bigNumArray.addAll(httpURLConnectionExample.numArray);
		  
	  }
	  System.out.println("GET DONE");
     //image dimension
     int width = 198;
     int height = 198;
     //create buffered image object img
     BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
     //file object
     File f = null;
     //create random image pixel by pixel
     for(int y = 0; y < height; y++){
       for(int x = 0; x < width; x++){
    	   
    	   //this takes into account the rows and cols 
    	   //(y*198) keeps track of which rows, then (x%198) goes along x axis until width
    	   //then multiply by 4 to jump to the next set of 4 
    	   
    	   int alpha = bigNumArray.get((y*198)+(x%198)*4);
    	   int red = bigNumArray.get(((y*198)+(x%198)*4)+1);
    	   int green = bigNumArray.get(((y*198)+(x%198)*4)+2);
    	   int blue = bigNumArray.get(((y*198)+(x%198)*4)+3);
    	  
 
         int pixel = (alpha<<24) | (red<<16) | (green<<8) | blue; //pixel
    	   //bit shifting:
    	   //ex: 0x88 00F5EE - this is in hexadecimal, but we want binary
    	   //move alpha 24 bits to the left, red 16 bits, green 8 bits, and blue no bits
 
         img.setRGB(x, y, pixel);
       }
     }
     //write image
     try{
    	 f = new File("randomImage.png");
       ImageIO.write(img, "png", f);
     }catch(IOException e){
       System.out.println("Error: " + e);
     }
  }//main() ends here
}//class ends here