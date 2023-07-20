# arrays/PythonLists.py

aList = [1, 2, 3, 4, 5]
print(type(aList))
print(aList)
print(aList[4])
aList.append(6)
aList += [7, 8]
print(aList)
aSlice = aList[2:4]
print(aSlice)


class MyList(list):  # 继承自 list
    # 定义方法，并显式地使用 "this" 指针
    def getReserved(self):
        reversed = self[:]  # Copy list using slices
        reversed.reverse()  # Built-inlist method
        return reversed


# 无须使用 "new" 来创建对象
list2 = MyList(aList)
print(type(list2))
print(list2.getReserved())
