class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        
        """
        
        point1=0
        point2=len(height)-1
        maxArea=abs(point2-point1)*min(height[point1],height[point2])
        temp=0
        while(point1!=point2):
            if(height[point1] >=height[point2]):
                point2=point2-1
            else:
                point1=point1+1
            temp=abs(point2-point1)*min(height[point1],height[point2])
            if(temp>maxArea):
                maxArea=temp
        
        return maxArea
