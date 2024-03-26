function solution(n) {
    var answer = 0;
    
    let arr = new Array(n+1).fill(0);
    
    for (let i = 2 ; i <= n ; i++) {
        if (arr[i] == 1) continue;
        
        for (let j = i*2 ; j <= n ; j+=i) {
            arr[j] = 1;
        }
    }
    arr.map((v) => answer += v);
    return answer;
}