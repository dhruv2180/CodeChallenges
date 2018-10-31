class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row=len(matrix)-1
        if row==0:
            if len(matrix[0])==0:
                return False
        col=0        
        while row>=0 and col<len(matrix[row]):
            if target==matrix[row][col]:
                return True
            elif target>matrix[row][col]:
                lastrow=row
                lastcol=col
                col=col+1
            elif target<matrix[row][col]:
                lastrow=row
                lastcol=col
                row=row-1
        return False
