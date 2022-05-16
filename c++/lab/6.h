class Stroka {
    char str[80];

public:
    Stroka(char*);
    Stroka(){};
    Stroka(const Stroka&);
    Stroka & operator=(const Stroka&);
    Stroka & operator+(const Stroka&);

    int operator==(const Stroka&);
    int dlina();

    void vvod();
    void vyvod();
};
