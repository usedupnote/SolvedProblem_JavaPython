function solution(before, after) {
    var answer = 1;
    var listBefore = before.split("");
    var listAfter = after.split("");
    var listChr = new Map();
    
    for (let i = 0 ; i < 26 ; i++) listChr.set(i, 0);
    
    listBefore.map((chr) => {
        listChr.set(chr.charCodeAt() - 'a'.charCodeAt(), listChr.get(chr.charCodeAt() - 'a'.charCodeAt()) + 1);
    });
    
    listAfter.map((chr) => {
        if(listChr.get(chr.charCodeAt() - 'a'.charCodeAt()) === 0) {
            answer = 0;
        };
        listChr.set(chr.charCodeAt() - 'a'.charCodeAt(), listChr.get(chr.charCodeAt() - 'a'.charCodeAt()) - 1);
    });
    return answer;
}