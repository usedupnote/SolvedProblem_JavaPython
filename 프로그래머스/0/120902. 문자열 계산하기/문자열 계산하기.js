function solution(my_string) {
    var answer = 0;
    my_string.replaceAll(" - ", " + -").split(" + ").map(v => answer += parseInt(v))
    return answer;
}