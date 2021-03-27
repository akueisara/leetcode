class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        ugly_numbers = [0] * n
        ugly_numbers[0] = 1
        prime_indexs = [0] * len(primes)
        
        # copying a list using slicing
        next_multiple_of_primes = primes[:]
        for i in range(1, n):
            ugly_numbers[i] = min(next_multiple_of_primes)
            for j in range(len(primes)):
                if ugly_numbers[i] == next_multiple_of_primes[j]:
                    prime_indexs[j] += 1
                    next_multiple_of_primes[j] = ugly_numbers[prime_indexs[j]] * primes[j]
        return ugly_numbers[-1]
