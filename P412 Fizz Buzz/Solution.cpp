class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> output(n);
        for(int i=0;i<n;i++) {
            if((i+1)%3==0 && (i+1)%5==0) {
                output[i] = "FizzBuzz";
            }
            else if((i+1)%5==0) {
                output[i] = "Buzz";
            }
			else if((i+1)%3==0) {
                output[i] = "Fizz";
            }
            else {
                output[i] = to_string(i+1);
            }
        }
        return output;
    }
};