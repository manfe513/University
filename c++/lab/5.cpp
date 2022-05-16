#include <string.h>
#include <iostream>
#include <stdio.h>

void search(FILE *in);

using namespace std;

// 2. visible / invisible
void visibleInvisible(FILE *in) {
    char ch;
    int visible=0, invisible=0;

    while (!feof(in)) {
        ch = getc(in);
        if((int) ch <= 32) invisible++;
        else visible++;
    }
    cout << "Visible chars count = " << visible << ", invisible chars count = " << invisible << endl;
}
// 3. search_3
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

void replacePages_4() {

    char buff[1024] = {0};
    char *line;
    FILE *in, *out;

    if((in = fopen("5-4-input.txt", "r"))==NULL) {
        printf("5-4-input.txt file not opened");
        return;
    }

    if((out = fopen("5-4-output.txt", "w"))==NULL) {
        printf("5-4-output.txt file not opened");
        return;
    }

    char *pageNumStr = new char[1024];
    while((line = fgets(buff, 1024,in))) {

        if (strstr(line, "-") != nullptr) {
            strcpy(pageNumStr, line);
        } else {

            if(strstr(line, "\f") != nullptr) {
                fputs(pageNumStr, out);
                fputs(line, out);
            } else fputs(line, out);
        }
    }
}

int main() {
    char name [50] = "5-3-input.txt";
    FILE *in;

//    printf("Enter file name: ");
//    scanf("%s", name);

    if((in= fopen(name, "r"))==NULL) printf("File %s not opened", name);
    else {
        // 2.
//        visibleInvisible(in);

//        search_3(in, "banana");

        replacePages_4();
    }

    return 0;
}


