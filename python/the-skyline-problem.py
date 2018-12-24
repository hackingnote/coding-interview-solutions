from heapq import heappush, heappop

class Solution:
    """
    @param buildings: A list of lists of integers
    @return: Find the outline of those buildings
    """
    def buildingOutline(self, buildings):
        edges = []
        result = []
        deleted = {}
        for (start, end, height) in buildings:
            edges.append((start, height, True))
            edges.append((end, height, False))  
        edges.sort(key=lambda tup: (tup[0], not tup[2]))
        print(edges)
        heap = []
        prevX = 0
        for (x, y, isStart) in edges: 
            if not heap:
                heappush(heap, -y)
                prevX = x
            elif isStart:
                if y > -heap[0]:
                    if prevX != x:
                        result.append([prevX, x, -heap[0]])
                    heappush(heap, -y)
                    prevX = x
                else:
                    heappush(heap, -y)
            else:
                if y < -heap[0]:
                    deleted[y] = deleted.get(y, 0) + 1
                else:
                    highest = -heappop(heap)
                    if heap and highest == -heap[0]: continue
                    if prevX != x:
                        result.append([prevX, x, y])
                    while heap and deleted.get(-heap[0], 0) > 0:
                        deleted[-heap[0]] -= 1
                        heappop(heap)            
                  prevX = x
        return result

print(Solution().buildingOutline([[1,3,3],[2,4,4],[5,6,1]]))