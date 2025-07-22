import java.util.Arrays;

/* 
 1. ------------------------------------ in place of # there was "" space
     *                      *
     #   *              *   #     	
     *   #	 *      *   #   *
     #	 *   #   *  #   *   #  
     *   #   *      *   #   *
     #   *              *   #
     *                      *
     
     
 2.-----------------------------------------------
       [-1, 3, 5,-3, 2]    
       
       *
         ***
         *****
     ***
         **
         
         
  3.------------------------------------------------
   [-1, 3, 5,-3, 2]
  
             *
             *
           * *
           * *    *
           * *    *
         *     *                
               *
               *
               
   4. -------------------------------------------------    
                *
              *    *
           *     *    *
         *    *     *    *
               
 */


public class Patterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] arr = {-1, 3, 5, -3, 2};
		int[] arr = { 1, -2, 3, 4, 5};
		//Patterns.makePattern2(arr);
		
		Patterns.makePattern3(arr);
		//Patterns.makePattern4();
        
		//Patterns.makePattern1();
		
	}
	
	public static int findMax(int[] arr)
	{
		int max = arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	
	public static int findMin(int[] arr)
	{
		int min = arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] < min)
				min = arr[i];
		}
		return min;
	}
	
	public static void makePattern2(int[] arr)
	{
		int min = Patterns.findMin(arr);
		for(int i=0; i<arr.length; i++)
		{
			int space;
			
			if(arr[i] < 0)
			{	space = Math.abs(min - arr[i]);
			
			//System.out.println(" space ="+space);
			}
			else
				space = Math.abs(min);
			
			//System.out.println(" space ="+space);
			
			for(int j=1; j<= space; j++)
				System.out.print("#");
			
			for(int k=1; k<=Math.abs(arr[i]); k++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	//to see - not correct
	public static void makePattern3(int[] arr)
	{
		
		int max = Patterns.findMax(arr);
		int min = Patterns.findMin(arr);
		
		System.out.println(" min = "+min + "   max = "+max + " array = "+Arrays.toString(arr));
		for(int i = max; i >= 0; i--)
		{
			
			for(int j=0; j<arr.length; j++)
			{
				if(arr[j] > 0 && arr[j] >= i)
				    System.out.print("* ");
				else
					System.out.print("  ");
			}	
			System.out.println();
		}	
		
		for(int i= 0; i>= min; i--)
		{
			
			for(int j=0; j<arr.length; j++)
			{
				if(arr[j] < 0 && arr[j] <= i)
				    System.out.print("* ");
				else
					System.out.print("  ");
			}	
			System.out.println();
		}		
		
		
	}
	
	public static void makePattern4()
	{
		int num_of_rows =4, space;
		
		for(int row=1; row <= num_of_rows; row++ )
		{
			space = num_of_rows - row;
			
			for(int i=1; i<= space; i++)
				System.out.print(" ");
			
			for(int j=1; j<= (2*row -1); j++)
			{
				if(j %2 == 0)
					System.out.print(" ");	
				else
				    System.out.print("* ");	
			}
			
			System.out.println();
			
		}	
		
	}
	
	public static void makePattern1()
	{
		int n=10;
		
		int width = 2*n -1;
		
		String pattern = "";
		//making upper half
		for(int row =1; row <= n; row++)
		{
			
			if(row %2 == 0)
				 pattern = " ";
			else
				pattern =  "*";
			
			if( row == n)
			{
				
				for(int j =1; j<= width; j++)
				{
                   System.out.print(pattern + "  ");	
					
					if(pattern.equals(" "))
						pattern = "*";
					else
						pattern = " ";
				}	
					
			}	
			else
			{
				for(int j =1; j<= row; j++)
				{
					System.out.print(pattern + "  ");	
					
					if(pattern.equals(" "))
						pattern = "*";
					else
						pattern = " ";
				}	
				
			
			int space = width - 2*row;
			for(int j=1; j<= space; j++)
				System.out.print("   ");
			
			for(int j =1; j<= row; j++)
			{
				if(pattern.equals(" "))
					pattern = "*";
				else
					pattern = " ";
				System.out.print(pattern + "  ");		
			}	
				
			}
			System.out.println();
			
		}
		
		//Making lower half
		for(int row = n-1; row >=1; row--)
		{
		    if(row %2 == 0)
				 pattern = " ";
			else
				pattern =  "*";
				
			for(int j =1; j<= row; j++)
				{
					System.out.print(pattern + "  ");	
					
					if(pattern.equals(" "))
						pattern = "*";
					else
						pattern = " ";
				}	
			
			int space = width - 2*row;
			for(int j=1; j<= space; j++)
				System.out.print("   ");
			
			for(int j =1; j<= row; j++)
			{
				if(pattern.equals(" "))
					pattern = "*";
				else
					pattern = " ";
				System.out.print(pattern + "  ");		
			}	
			
			System.out.println();
		}
		
	}

}
