class Stroka {
    char *str;

private:
    int dlina(char *str);

    void copy(char* s1, char* s2);

    int compare(char *str1, char *str2);

    void concat(char *str1, char *str2);

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
};
