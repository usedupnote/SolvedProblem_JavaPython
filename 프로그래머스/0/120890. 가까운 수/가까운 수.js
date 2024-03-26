function solution(array, n) {
    var answer = -101;
    array = array.sort();
    array.map((v) => {
        if(Math.abs(answer - n) > Math.abs(n - v)) {
            answer = v;
        }
    })
    return answer;
}