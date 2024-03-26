import tkinter as tk

def main():
    win=tk.TK()
    canvas = tk.Canvas(win,width=700, height=500)
    canvas.grid(columspan=2, rowspan=5)

if __name__ == '__main__':
    main()