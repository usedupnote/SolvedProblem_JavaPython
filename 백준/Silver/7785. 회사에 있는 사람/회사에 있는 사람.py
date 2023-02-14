import sys
N = int(sys.stdin.readline())
a = {}
for n in range(N):
    name, status = map(str, sys.stdin.readline().split())
    if status == 'enter':
        a[name] = '1'
    elif status == 'leave':
        del a[name]
a = sorted(a.keys(), reverse = True)
for i in a:
    print(i)
