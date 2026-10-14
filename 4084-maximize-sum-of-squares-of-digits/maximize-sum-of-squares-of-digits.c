inline int min2int(int a, int b) {
    return (a < b) ? a : b;
}

void rec(int num, int sum, char* write) {
    if (num) {
        int digit = min2int(9, sum);
        *write = '0' + digit;
        rec(num - 1, sum - digit, write + 1);
    } else {
        *write = '\0';
    }
}

char* maxSumOfSquares(int num, int sum) {
    if (sum > 9 * num) {return "";}
    char* n = malloc((num + 1) * sizeof(char));
    rec(num, sum, n);
    return n;
}