function solution(k, dungeons) {
    var answer = 0;
    dSize = dungeons.length;
    const visited = new Array(dSize).fill(false);
    
    function DFS(hp, L) {
        if(answer < L) answer = L;
        for(let i = 0 ; i < dSize ; i++) {
            if(visited[i]) continue;
            
            if(hp >= dungeons[i][0]) {
                visited[i] = true;
                DFS(hp - dungeons[i][1], L+1);
                visited[i] = false;
            }
        }
    }
    
    DFS(k, 0);
    
    return answer;
}