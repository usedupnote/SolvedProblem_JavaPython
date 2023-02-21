// [문제 링크]: https://www.acmicpc.net/problem/1371

import sys
inStr = sys.stdin.read()
word = [0 for i in range(26)]
​
for s in inStr:
    if s.islower():  # 소문자가 아니라면 패스
        word[ord(s) - 97] += 1  # 알파벳을 아스키코드로 변환
​
for i in range(26):
    if word[i] == max(word):
        print(chr(97 + i), end='')  # 아스키코드에 해당되는 문자로 변환