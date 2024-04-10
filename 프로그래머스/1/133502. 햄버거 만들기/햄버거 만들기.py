def solution(ingredient):
    answer = 0
    st = []
    for i in ingredient:
        if i == 1 and st[len(st)-3:] == [1, 2, 3]:
            st.pop()
            st.pop()
            st.pop()
            answer += 1
            continue
        st.append(i)
    
    return answer