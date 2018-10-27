class Solution(object):
        
    def minCostClimbingStairs(self, cost):

        costToReach=[0]*(len(cost)+1)
        costToReach[0]=cost[0]
        costToReach[1]=cost[1]
        
        iter=2
        lastCost=0;
        
        
        for x in cost[2:]:
            
            lastCost=min(costToReach[iter-1],costToReach[iter-2])
            costToReach[iter]=lastCost+x
            iter+=1
           
        return min(costToReach[iter-1],costToReach[iter-2])
