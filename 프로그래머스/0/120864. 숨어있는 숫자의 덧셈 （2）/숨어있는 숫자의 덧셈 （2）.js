function solution(my_string) {
    var answer = 0;
    let num = 0;
    my_string.split("").map((v) =>{
        if(!isNaN(v)){
            num+=v;
        } else {
            answer += parseInt(num);
            num = 0;
        }
    })
    answer += parseInt(num);
    return answer;
}