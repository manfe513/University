#include <iostream>
#include <iomanip>

using namespace std;

#define N 5

void minMax(float m[N][N]) {

    float min = m[0][0];
    float max = m[0][0];

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (m[i][j] < min) min = m[i][j];
            if (m[i][j] > max) max = m[i][j];
        }
    }

    cout << "MIN = " << min << endl;
    cout << "MAX = " << max << endl;
}

void minMaxTriangleBottom(float m[N][N]) {
    float min = m[0][0];
    float max = m[0][0];

    for (int i = 0; i < N; i++) {
        for (int j = i; j >= 0; j--) {
            if (m[i][j] < min) min = m[i][j];
            if (m[i][j] > max) max = m[i][j];
        }
    }

    cout << "MIN TRIANGLE BOTTOM = " << min << endl;
    cout << "MAX TRIANGLE BOTTOM = " << max << endl;
}

void minMaxTriangleTop(float m[N][N]) {
    float min = m[0][0];
    float max = m[0][0];

    for (int i = 0; i < N; i++) {
        for (int j = i; j < N; j++) {
            if (m[i][j] < min) min = m[i][j];
            if (m[i][j] > max) max = m[i][j];
        }
    }

    cout << "MIN TRIANGLE TOP = " << min << endl;
    cout << "MAX TRIANGLE TOP = " << max << endl;
}

void minMaxDiagonalMain(float m[N][N]) {
    float min = m[0][0];
    float max = m[0][0];

    for (int i = 0; i < N; i++) {
        if (m[i][i] < min) min = m[i][i];
        if (m[i][i] > max) max = m[i][i];
    }

    cout << "MIN DIAGONAL MAIN = " << min << endl;
    cout << "MAX DIAGONAL MAIN = " << max << endl;
}

void minMaxDiagonalSecondary(float m[N][N]) {
    float min = m[0][0];
    float max = m[0][0];

    for (int x = 0; x < N; x++) {
        int y = N - 1 - x;
        if (m[x][y] < min) min = m[x][y];
        if (m[x][y] > max) max = m[x][y];
    }

    cout << "MIN DIAGONAL SECONDARY = " << min << endl;
    cout << "MAX DIAGONAL SECONDARY = " << max << endl;
}

float getAverage(float m[N][N]) {
    float total = 0.;

    for (int i = 0; i < N; i++) {
        for (int j = i; j < N; j++) {
            total += m[i][j];
        }
    }

    return total / (N*N);
}

float printAverage(float m[N][N]) {

    float average = getAverage(m);
    cout << "AVERAGE  = " << average << endl;
}

void averageTriangleBottom(float m[N][N]) {
    float total = 0.;

    for (int i = 0; i < N; i++)
        for (int j = i; j >= 0; j--)
            total += m[i][j];

    float average = total / (N*N);

    cout << "AVERAGE TRIANGLE BOTTOM = " << average << endl;
}

void averageTriangleTop(float m[N][N]) {
    float total = 0.;

    for (int i = 0; i < N; i++)
        for (int j = i; j < N; j++)
            total += m[i][j];

    float average = total / (N*N);

    cout << "AVERAGE TRIANGLE TOP = " << average << endl;
}

void sumRows(float m[N][N]) {
    float total = 0.;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++)
            total += m[i][j];

        cout << "SUM (ROW "<< i <<") = " << total << endl;
        total = 0.;
    }
    cout << endl;
}

void sumCols(float m[N][N]) {
    float total = 0.;

    for (int y = 0; y < N; y++) {
        for (int x = 0; x < N; x++)
            total += m[x][y];

        cout << "SUM (COL "<< y <<") = " << total << endl;
        total = 0.;
    }
    cout << endl;
}

void minMaxRows(float m[N][N]) {
    float min;

    for (int i = 0; i < N; i++) {
        min = m[i][0];

        for (int j = 0; j < N; j++)
            if (m[i][j] < min) min = m[i][j];

        cout << "ROW MIN ("<< i <<") = " << min << endl;
    }
    cout << endl;
}

void minMaxCols(float m[N][N]) {
    float min = m[0][0];

    for (int y = 0; y < N; y++) {
        min = m[0][y];

        for (int x = 0; x < N; x++)
            if (m[x][y] < min) min = m[x][y];

        cout << "COL MIN ("<< y <<") = " << min << endl;
    }
    cout << endl;
}

void averageRowValue(float m[N][N]) {
    float rowTotal = 0., rowAverage;

    for (int i = 0; i < N; i++) {

        for (int j = 0; j < N; j++)
            rowTotal += m[i][j];

        rowAverage = rowTotal / N;
        cout << "ROW AVERAGE ("<< i <<") = " << rowAverage << endl;
        rowTotal = 0.;
    }
    cout << endl;
}

void averageColValue(float m[N][N]) {
    float colTotal = 0., colAverage;

    for (int y = 0; y < N; y++) {

        for (int x = 0; x < N; x++)
            colTotal += m[x][y];

        colAverage  = colTotal / N;
        cout << "COL AVERAGE ("<< y <<") = " << colAverage << endl;
        colTotal = 0.;
    }
    cout << endl;
}

void triangleBottomSum(float m[N][N]) {
    float total = 0.;

    for (int i = 0; i < N; i++)
        for (int j = i; j >= 0; j--)
            total += m[i][j];

    cout << "TRIANGLE BOTTOM SUM = " << total << endl;
}

void triangleTopSum(float m[N][N]) {
    float total = 0.;

    for (int i = 0; i < N; i++)
        for (int j = i; j < N; j++)
            total += m[i][j];

    cout << "TRIANGLE TOP SUM  = " << total << endl;
}

void printClosestToAverage(float m[N][N]) {

    float average = getAverage(m);
    float closest = m[0][0];

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            if (abs(m[i][j] - average) < closest) closest = m[i][j];

    cout << "CLOSEST TO AVERAGE MATRIX VALUE = " << closest << endl;
}

int main() {


    float m[N][N];
    int i, j;
    double sdf {2.3};

    srand((unsigned int) time(NULL));

    for (i = 0; i < N; i++)
        for (j = 0; j < N; j++)
            m[i][j] = float(rand() / 10.);

    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++)
            cout << setw(8) << setprecision(5) << m[i][j];
        cout << endl;
    }

    minMax(m);

    minMaxTriangleBottom(m);
    minMaxTriangleTop(m);

    minMaxDiagonalMain(m);
    minMaxDiagonalSecondary(m);

    printAverage(m);

    averageTriangleBottom(m);
    averageTriangleTop(m);

    sumRows(m);
    sumCols(m);

    minMaxRows(m);
    minMaxCols(m);

    averageRowValue(m);
    averageColValue(m);

    triangleBottomSum(m);
    triangleTopSum(m);

    printClosestToAverage(m);

    return 0;
}
