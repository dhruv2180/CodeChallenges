"""

A = [1,2,3,1,2,5]
B = [2,1,2,1,3,5]
out= [1,0,4,3,2,5]

A = map[0,1][1,2]....5[5]
B = map [2,0] [1,1] [2,[0,2]] [1,[1,3]]

A [1,]


"""
class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        map={}
        counter=0
        toReturn=[]
        
        for i in B: 
            if i not in map:
                map[i]=[]
            map[i].append(counter)
            counter+=1
        
        for i in A:
            temp=map[i]
            toReturn.append(temp[0])
            if len(temp)>1:
                map[i]=temp[1:]
        
        return toReturn
        
