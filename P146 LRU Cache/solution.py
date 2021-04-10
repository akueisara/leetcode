# Time complexity : O(1)
# Space complexity : O(capacity)
class LRUCache:

    def __init__(self, capacity: int):
        self.dict = collections.OrderedDict()
        self.size = capacity

    # O(1)
    def get(self, key: int) -> int:
        if key in self.dict:
            value = self.dict.pop(key)
            self.dict[key] = value
            return value
        return -1

    # O(1)
    def put(self, key: int, value: int) -> None:
        if key in self.dict:
            self.dict.pop(key)
        elif len(self.dict) == self.size:
            self.dict.popitem(last=False) 
        self.dict[key] = value


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
