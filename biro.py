import time
import tkinter as tk
import tkinter.simpledialog
import htmllistparse
import requests


def biro(tb):
    h = tkinter.simpledialog.askstring("Név","Hallgató azonosítója: ")
    feladat = tkinter.simpledialog.askstring("Feladat", "feladat")
    pwd = tkinter.simpledialog.askstring("Jelszó", "Jelszó", show="*")
    try:
        cwd, listing = htmllistparse.fetch_listing(f"https://biro2.inf.u-szeged.hu/Hallg/IB088g/{feladat}/{h}/", auth=(h,pwd), timeout=30)
        for e in listing:
            tb.insert(tk.END, f"{e.name}. beadás - Legutóbb módosítva: {time.strftime('%Y-%m-%dT%H:%M:%SZ', e.modified)}\n")
            tb.insert(tk.END, f"{requests.get(f'https://biro2.inf.u-szeged.hu/Hallg/IB088g/{feladat}/{h}/{e.name[:-1]}/pont.txt'), }\n")

    except Exception as e:
        tb.insert(0.0, "Hiba történt!" + str(e))
        print(e)


def main():
    win=tk.Tk()
    canvas = tk.Canvas(win,width=700, height=500 ,bg="skyblue")
    canvas.grid(columnspan=2, rowspan=5)
    szoveg = tk.Label(win, font=('Arial', 12, 'bold'), text="Bíró app", bg="skyblue")
    szoveg.grid(columnspan=2,column=0,row=0)
    tb = tk.Text(win, height=20, width=70, padx=10, pady=10)
    tb.grid(columnspan=2,row=2)
    btn = tk.Button(win, text="Adatok betöltése", command=lambda: biro(tb), font=('Arial', 12, 'bold'))
    btn.grid(columnspan=2,row=3)
    tk.mainloop()

if __name__ == '__main__':
    main()