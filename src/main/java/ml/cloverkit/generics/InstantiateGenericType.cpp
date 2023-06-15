
template<class T> class Foo {
    // 创建 T 的一个字段
    T x;
    // 指向 T 的指针
    T* y;

public:
    // 初始化指针:
    Foo()
};

class Bar {};

int main() {
    Foo<Bar> fb;
    // 并且可以使用基本类型
    Foo<int> fi;
}
