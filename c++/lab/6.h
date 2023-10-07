class Stroka {
    char *str;

public:
    Stroka(){
        str = new char [50];
    };
    Stroka(char*);
    Stroka(const Stroka&);
    Stroka & operator=(const Stroka&);
    Stroka & operator+(const Stroka&);

    int operator==(const Stroka&);
    int dlina();

    void vvod();
    void vyvod();

    // >> Дополнение для ЛР №8
    friend std::istream& operator >> (std::istream& s, Stroka& str);
    friend std::ostream& operator << (std::ostream& s, Stroka& str);
};

// >> Дополнение для ЛР №8
std::istream& operator >> (std::istream& s, Stroka& str);
std::ostream& operator << (std::ostream& s, Stroka& str);
