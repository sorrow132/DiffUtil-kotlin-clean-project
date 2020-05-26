package yuresko.diffutilkotlincleanproject

class SomeRepository {

    private var arr: List<Something> = listOf(

        (Something(1, "one", 32)),
        (Something(2, "two", 331)),
        (Something(3, "three", 31)),
        (Something(4, "four", 354)),
        (Something(5, "five", 344)),
        (Something(6, "six", 466)),
        (Something(7, "seven", 54)),
        (Something(8, "eight", 676)),
        (Something(9, "nine", 533)),
        (Something(10, "ten", 5)),
        (Something(11, "eleven", 446)),
        (Something(12, "twelve", 566)),
        (Something(13, "thirteen", 67)),
        (Something(14, "fourteen", 866))
    )

    val arrSortedById: List<Something>
        get() = arr.sortedBy { it.id }

    val arrSortedByPrice: List<Something>
        get() = arr.sortedBy { it.price }

}