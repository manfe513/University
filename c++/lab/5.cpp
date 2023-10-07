#include <cstring>
#include <iostream>
#include <cstdio>
#include <fstream>

using namespace std;

void visibleInvisible_2(FILE *in) {
    char ch;
    int visible=0, invisible=0;

    while (!feof(in)) {
        ch = getc(in);
        if((int) ch <= 32) invisible++;
        else visible++;
    }
    cout << "Visible chars count = " << visible << ", invisible chars count = " << invisible << endl;
}

void search_3(FILE *in, char *s) {

    char buff[1024] = {0};
    char *line;
    FILE *out;

    if((out = fopen("5-3-output.txt", "w"))==NULL) {
        printf("Output file not opened");
        return;
    }

    while((line = fgets(buff, 1024,in))) {

        if (strstr(line, s) != nullptr) {

            char const* c1 = "found line: ";
            char *r = new char[strlen(c1)+ strlen(line)];
            strcpy(r, c1);
            strcat(r,line);

            fputs(r, out);
        }
    }
}

// >>
// >> Метод переписан с использованием классов-потоков для ЛР №8
// >>
void replacePages_4() {

    char buff[1024] = {0};
    char *line;

    ifstream ifs("5-4-input.txt");
    if (!ifs) {
        printf("5-4-input.txt file not opened");
        return;
    }

    ofstream ofs("5-4-output.txt");
    if(!ofs) {
        printf("5-4-output.txt file not opened");
        return;
    }

    char *pageNumStr = new char[1024];
    while (ifs && ofs) {
        ifs.getline(line, 1024);

        if (strstr(line, "-") != nullptr) {
            strcpy(pageNumStr, line);
        } else {

            if(strstr(line, "\f") != nullptr) {
                ofs << pageNumStr << endl << "\f" << endl;
            } else ofs << line << endl;
        }
    }
}

void encodeDecode_5_6(FILE *in) {
    FILE *outEncoded, *inEncoded, *outDecoded;
    if((outEncoded = fopen("5-56-output-encoded.txt", "w"))==NULL) {
        printf("5-56-output-encoded.txt file not opened");
        return;
    }

    if((outDecoded = fopen("5-56-output-decoded.txt", "w"))==NULL) {
        printf("5-56-output-decoded.txt file not opened");
        return;
    }

    char *key;
    printf("Enter encryption key: ");
    scanf("%s", key);

    int keyIndex;
    int i=0;
    char ch;

    while(!feof(in)) {
        ch = getc(in);
        keyIndex = i> sizeof(key) ? i % sizeof(key) : i;
        char encryptedChar = ch^key[keyIndex];

        putc(encryptedChar, outEncoded);

        i++;
    }

    // start decoding process
    if((inEncoded = fopen("5-56-output-encoded.txt", "r"))==NULL) {
        printf("5-56-output-encoded.txt file not opened");
        return;
    }

    i=0;
    while(!feof(inEncoded)) {
        ch = getc(inEncoded);
        keyIndex = i> sizeof(key) ? i % sizeof(key) : i;
        char decryptedChar = ch&key[keyIndex];

        putc(decryptedChar, outDecoded);

        i++;
    }
}

int main() {
    char name [50];
    FILE *in;

    printf("Enter file name: ");
    scanf("%s", name);

    if((in= fopen(name, "r"))==NULL) printf("File %s not opened", name);
    else {
//        visibleInvisible_2(in);

//        search_3(in, "banana");

        replacePages_4();

//        encodeDecode_5_6(in);
    }

    return 0;
}


