def solution(data, ext, val_ext, sort_by):
    sortBy = {"code":0, "date":1, "maximum":2, "remain":3}
    answer = []
    
    for dataItem in data:
        if dataItem[sortBy[ext]] < val_ext :
            answer.append(dataItem)
    
    answer.sort(key = lambda x:x[sortBy[sort_by]])
    
    return answer