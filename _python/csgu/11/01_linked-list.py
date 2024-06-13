class Node:
    def __init__(self, data) -> None:
        self.data = data
    def breed(self, next_node):
        self.next_node = next_node

boyoung = Node("Boyoung Kim")
darren = Node("Darren Kim")
olivia = Node("Olivia Kim")
boyoung.breed(darren)
darren.breed(olivia)
print(boyoung.next_node.next_node.data)
