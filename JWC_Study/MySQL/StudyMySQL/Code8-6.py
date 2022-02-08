from tkinter import *
from tkinter import messagebox

def clickButton() :
    messagebox.showinfo('버튼 클릭', '버튼을 눌렀습니다..')

root = Tk()
root.geometry("200x200")

button1 = Button(root, text="여기를 클릭하세요", fg="red", bg="yellow", command=clickButton)
button1.pack(expand = 1)

root.mainloop()
