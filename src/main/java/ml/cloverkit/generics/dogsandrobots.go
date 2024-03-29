package main

import "fmt"

type Dog struct{}

func (this Dog) speak() {
	fmt.Printf("Arf!\n")
}

func (this Dog) sit() {
	fmt.Printf("Siting\n")
}

func (this Dog) reproduce() {}

type Robot struct{}

func (this Robot) speak() {
	fmt.Printf("Click!\n")
}
func (this Robot) sit() {
	fmt.Printf("Clank!\n")
}
func (this Robot) oilChange() {}

func perform(speaker interface {
	speak()
	sit()
}) {
	speaker.speak()
	speaker.sit()
}

func main() {
	perform(Dog{})
	perform(Robot{})
}
