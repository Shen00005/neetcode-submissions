class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        L = {}
        for num in nums:
            L[num] = L.get(num, 0) + 1
            
        sorted_items = sorted(L.items(), key=lambda x: x[1], reverse=True)
        
        return [item[0] for item in sorted_items[:k]]
