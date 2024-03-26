function solution(my_string) {
    var answer = '';
    let visit = new Map();
    
    my_string.split('').map((v) => {
        if (!visit.has(v)){
            visit.set(v, 0);
            answer += v;
        }
    })
    return answer;
}