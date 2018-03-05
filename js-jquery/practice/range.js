function printRange(start, end, skip) {

    for (i = 1; i < 10; i++) {
        if (i % 2 == 0) {
            console.log(i)
        }
        else {
            continue;
        }
    }
}
    printRange(2, 10, 2);