#include <iostream>
#include <ostream>

using std::cout, std::endl;

class Animal {
    public:
        virtual void eat() {cout << "animal eats" << endl;}
};

class Dog : public Animal {
    public:
        void bark() {cout << "dog barks" << endl;}
};

int main() {
    Dog one;
    Animal* two = new Dog();
    one.eat();
    //one.bark();
    two->eat();
}