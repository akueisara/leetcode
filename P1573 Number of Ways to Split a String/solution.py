class Solution:
    def numWays(self, s: str) -> int:
        mod_num = 10 ** 9 + 7
        num_of_ones = s.count('1')
        if num_of_ones % 3 != 0:
            return 0
        elif num_of_ones == 0:
            return (len(s) - 1) * (len(s) - 2) // 2 % mod_num
        else:
            ones_in_each_part = num_of_ones / 3
            ways_before_first_cut = 0
            ways_between_first_and_second_cut = 0
            count_of_one = 0
            for c in s:
                if c == '1':
                    count_of_one += 1
                if count_of_one == ones_in_each_part:
                    ways_before_first_cut +=1
                elif count_of_one == 2 * ones_in_each_part:
                    ways_between_first_and_second_cut += 1
            return ways_before_first_cut * ways_between_first_and_second_cut % mod_num