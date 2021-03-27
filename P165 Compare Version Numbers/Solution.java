class Solution {
    public int compareVersion(String version1, String version2) {
        double version1Weight = calculateWeightSum(version1);
        double version2Weight = calculateWeightSum(version2);
        if(version1Weight > version2Weight) {
            return 1;
        } else if(version1Weight < version2Weight) {
            return -1;
        } else {
            return 0;
        }
    }
    
    private static double calculateWeightSum(String version) {
        String[] numbersStr = version.split("\\.");
        double weightSum = 0;
        double weight = Math.pow(10, 250);
        for(int i = 0; i < numbersStr.length; i++) {
            System.out.print(numbersStr[i] + " ");
            System.out.println(weight);
            weightSum += Integer.valueOf(numbersStr[i]) * weight;
            weight /= 10;
        }
         return weightSum;
    }
}