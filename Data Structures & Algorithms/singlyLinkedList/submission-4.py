class Node :
    def __init__(self, val):
        self.val = val 
        self.next = None
class LinkedList:
    
    def __init__(self):
        self.head = None
    
    def get(self, index: int) -> int:
        current = self.head
        for i in range(index) :
            if not current.next :
                return -1
            current = current.next
        return current and current.val or -1

    def insertHead(self, val: int) -> None:
        new = Node(val)
        new.next = self.head
        self.head = new

    def insertTail(self, val: int) -> None:
        new = Node(val)
        current = self.head
        if not current :
            self.head = new
            return 
        while (current.next) :
            current = current.next
        current.next = new


    def remove(self, index: int) -> bool:
        if index == 0:
            if self.head is None:
                return False

            self.head = self.head.next
            return True

        current = self.head

        for _ in range(index - 1):
            if current is None or current.next is None:
                return False
            current = current.next

        if current.next is None:
            return False

        current.next = current.next.next
        return True
        

    def getValues(self) -> List[int]: 
        L = [] 
        current = self.head 
        while current:
             L.append(current.val) 
             current = current.next 
             
        return L
