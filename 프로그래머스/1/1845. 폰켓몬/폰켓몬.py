def solution(nums):
    dic = {}
    for i in nums:
        dic[i] = True
    
    answer = min(len(dic), len(nums)//2)
    
    return answer