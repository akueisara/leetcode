class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int primeLength = primes.length;
        int[] primeIndexs = new int[primeLength];
        
        int[] nextMultipleOfPrimes = Arrays.copyOf(primes, primeLength);
    
        for(int i = 1; i < n; i++) {
            uglyNumbers[i] = getMinValue(nextMultipleOfPrimes);
            for(int j = 0; j < primeLength; j++) {
                if(uglyNumbers[i] == nextMultipleOfPrimes[j]) {
                    primeIndexs[j]++;
                    nextMultipleOfPrimes[j] = uglyNumbers[primeIndexs[j]] * primes[j];
                }
            }
        }
        return uglyNumbers[n -1];
    }
    
    private static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}