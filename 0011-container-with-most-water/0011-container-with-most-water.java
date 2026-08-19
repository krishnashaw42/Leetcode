class Solution {
    public int maxArea(int[] height) 
    {
     int p1=0;
     int p2=height.length-1;
     int maxarea=0;
     while (p1<p2)
     {
         int beadth=p2-p1;
         int length=(int)Math.min(height[p1],height[p2]);
         int area=length*beadth;
         if(area>maxarea)
         {
            maxarea=area;
         }
         if(height[p1]<height[p2])
         {
            p1++;
         }else 
         {
            p2--;
         }
     }
     return maxarea;   
    }
}