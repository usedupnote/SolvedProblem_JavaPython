function solution(sizes) {
    var answer = 0;
    let maxV = 0;
    let maxH = 0;
    sizes.map((v) => {
        let min = Math.min(...v);
        let max = Math.max(...v);
        if(maxV < min) maxV = min;
        if(maxH < max) maxH = max;
    })
    return answer = maxV * maxH;
}