def knapSack(Flag, weight, value, n): 
    if n == 0 or Flag == 0 : 
        return 0 
    if (weight[n-1] > Flag): 
        return knapSack(Flag, weight, value, n-1) 
    else: 
        return max( 
            value[n-1] + knapSack( 
                Flag-weight[n-1], weight, value, n-1),  
                knapSack(Flag, weight, value, n-1))  
value = [60, 100, 120] 
weight = [10, 20, 30] 
Flag = 50
n = len(value) 
print knapSack(Flag, weight, value, n) 
  
