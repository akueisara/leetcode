class Solution:
    def totalFruit(self, tree: List[int]) -> int:
        types  = []
        # j goes backward
        max_count = temp_count = i = j = 0
        while i < len(tree):
            n = tree[i]
            if n in types:
                temp_count += 1
            else:
                if len(types) == 2:
                    if max_count < temp_count:
                        max_count = temp_count
                    temp_count = 0
                    j = i
                    types = []
                    while len(types) < 2:
                        j-=1
                        if tree[j] not in types:
                            types.append(tree[j])
                    i = j+1
                    types = []
                    continue
                else:
                    types.append(n)
                    temp_count += 1
            i+=1
                    
        if max_count < temp_count:
            max_count = temp_count
                    
        return max_count