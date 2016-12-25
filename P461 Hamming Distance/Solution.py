class Solution(object):
    def hammingDistance(self, x, y):
        """ Return the Hamming distance between equal-length sequences """
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        dist = 0
        val = x ^ y
        
        # Count the number of bits set
        while (val != 0):
            # A bit is set, so increment the count and clear the bit
            dist+=1
            val &= val - 1
        
        # Return the number of differing bits
        return dist