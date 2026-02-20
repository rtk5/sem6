int a, b;
float x;

{
    a = 10;
    b = a + 5;

    if (a > b) {
        x = 3;
    } else {
        do {
            a = a - 1;
        } while (a > 0);
    }
}