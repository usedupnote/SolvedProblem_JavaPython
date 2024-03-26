function solution(nums) {
    var answer = 0;
    let numSet = new Set();
    nums.map(v => numSet.add(v))
    return answer = Math.min(nums.length/2, numSet.size);
}