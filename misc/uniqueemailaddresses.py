"""
1.  . --> remove it from string
2.  + --> ignore everything after it 
"""


class Solution(object):
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        emailSet=set()
        for x in emails:
            string=x.split("@")[0]
            stringAfter=x.split("@")[1]
            string=string.split('+')[0]
            temp=string.split('.')
            tempStr=''
            for t in temp:
                tempStr=tempStr+t
                
            emailSet.add(tempStr+"@"+stringAfter)
        print emailSet
        return len(emailSet)
