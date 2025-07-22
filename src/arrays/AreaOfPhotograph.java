package arrays;

import java.util.Scanner;

/*   SOPRA
 * 
 * Given Height and width of n students. Each time a student click photo of rest of students (because he is clicking photo of all the other students).
 * Minimum Area of a photo is  = H * W where H is the maximum height of the student in the photo and W is the sum of width of all the student 
 * find the minimum area of n photos
 * 
 *  Input
 *  ------
 *  3       ( number of students)
 *  6 2     ( student has height 6 and width 2)
 *  7 9
 *  3 10  
 *  
 *  output
 *  ------
 *  133 72 77    ( max(7,3) * (10+9) , max(6,3) * (10+2), max(7,6) * (9+2)) 
 */
public class AreaOfPhotograph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int num_of_stu = sc.nextInt();
		int[] height = new int[num_of_stu];
		int[] width = new int[num_of_stu];
		
		for(int i =0; i< num_of_stu; i++)
		{
			height[i] = sc.nextInt();
			width[i] = sc.nextInt();
		}
		
		int maxHeight =0;
		int secMaxHeight =0;
		int sum_widths =0;
		
		//long time = System.currentTimeMillis();
		
		for(int i=0; i< num_of_stu; i++)
		{
			sum_widths += width[i];
			
			if(height[i] > maxHeight)
			{
				secMaxHeight = maxHeight;
				maxHeight = height[i];
				
			}	
			else if(height[i] > secMaxHeight && height[i] != maxHeight)
			{
				secMaxHeight = height[i];
			}
		}	
		
		//System.out.println(" max ="+maxHeight + " sec max ="+secMaxHeight);
		
		for(int i=0; i< num_of_stu; i++)
		{
			if(height[i] == maxHeight)
				System.out.print(secMaxHeight * (sum_widths - width[i]) + "  ");
			else
				System.out.print(maxHeight * (sum_widths - width[i]) + "  ");
		}	
        
		//System.out.println(" execution time = " + (System.currentTimeMillis() - time ));
	}

	
}
