class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        version1_weight_sum = self._calculate_weight_sum(version1)
        version2_weight_sum = self._calculate_weight_sum(version2)
        if version1_weight_sum > version2_weight_sum:
            return 1
        elif version1_weight_sum < version2_weight_sum:
            return -1
        return 0
        
        
    def _calculate_weight_sum(self, version: str) -> int:
        numbers_str = version.split(".")
        weight_sum = 0
        weight = 10^250
        for number_str in numbers_str:
            weight_sum += int(number_str) * weight
            weight /= 10
            
        return weight_sum