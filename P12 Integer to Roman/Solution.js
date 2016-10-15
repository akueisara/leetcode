/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    if(num <= 0) {
		return "";
	}
    var nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
	var symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];
	var res = "";
	var digit = 0;
	while (num > 0) {
        var times = Math.floor(num / nums[digit]);
        num %= nums[digit];
        while (times>0){
                res += symbols[digit];
                times--;
        }
        digit++;
	}
    return res;
};