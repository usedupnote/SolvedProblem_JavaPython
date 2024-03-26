function solution(i, j, k) {
    var answer = 0;
    for(let x = i ; x <= j ; x++) {
        x.toString().split("").map((v) => {
            if (v == k.toString()) answer++;                     
        })
    }
    return answer;
}