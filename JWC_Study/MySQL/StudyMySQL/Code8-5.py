from tkinter import *
root = Tk()
root.geometry("300x100")

label1 = Label(root, text="혼공 SQL은")
label2 = Label(root, text="쉽습니다.", font=("궁서체", 30), bg="blue", fg="yellow")

label1.pack()
label2.pack()

root.mainloop()
