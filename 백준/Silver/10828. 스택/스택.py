import sys

T = int(sys.stdin.readline())

queue = []

commandList = ["push", "pop", "size", "empty", "top"]

for i in range(T) :
    command = list(sys.stdin.readline().split())

    if command[0] == commandList[0] :
        queue.append(command[1])
    elif command[0] == commandList[1] :
        if len(queue) != 0 :
            print(queue.pop())
        else :
            print(-1)
    elif command[0] == commandList[2] :
        print(len(queue))
    elif command[0] == commandList[3] :
        if len(queue) != 0 :
            print(0)
        else :
            print(1)
    else :
        if len(queue) != 0 :
            print(queue[len(queue) - 1])
        else :
            print(-1)