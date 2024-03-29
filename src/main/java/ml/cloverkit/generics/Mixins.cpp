#include <string>
#include <ctime>
#include <iostream>
using namespace std;

template<class T> class TimeStamped : public T {
    long timeStamp;
public:
    TimeStamped() {
        timeStamp = time(0);
    }
    long getStamp() {
        return timeStamp;
    }
};

template<class T> class SerialNumbered : public T {
    long serialNumber;
    static long counter;
public:
    SerialNumbered() {
        serialNumber = counter++;
    }

    long getSerialNumber() {
        return serialNumber;
    }
};

// 定义静态存储， 并进行初始化
template<class T> long SerialNumbered<T>::counter = 1;

class Basic {
    string value;
public:
    void set(string val) {
        value = val;
    }
    string get() {
        return value;
    }
};

int main() {
    TimeStamped<SerialNumbered<Basic>> mixin1, mixin2;
    mixin1.set("test string 1");
    mixin2.set("test string 2");
    cout << mixin1.get() << " " << mixin1.getStamp() << " " << mixin1.getSerialNumber()
}