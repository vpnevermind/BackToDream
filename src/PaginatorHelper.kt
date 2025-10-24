import kotlin.math.ceil

class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {

    /**
     * returns the number of items within the entire collection
     */
    val itemCount: Int
        get() {
            return collection.size
        }

    /**
     * returns the number of pages
     */
    val pageCount: Int
        get() {
            val div = collection.size.toDouble() / itemsPerPage.toDouble()
            return ceil(div).toInt()
        }


    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    fun pageItemCount(pageIndex: Int): Int {
        return when {
            pageIndex in 0..pageCount - 2 -> itemsPerPage
            pageIndex in 0..pageCount - 1 -> collection.size - ((pageCount - 1) * itemsPerPage)
            else -> -1
        }
    }


    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    fun pageIndex(itemIndex: Int): Int {
        var page = 0
        for (i in collection.indices step itemsPerPage) {
            if (itemIndex in i..i+itemsPerPage) {
                return page
            }
            page++
        }
        return -1
    }
}

fun main() {
    val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)

    println(helper.pageCount) // should == 2
    println(helper.itemCount) // should == 6
    println(helper.pageItemCount(0)) // should == 4
    println(helper.pageItemCount(1)) // last page - should == 2
    println(helper.pageItemCount(2)) // should == -1 since the page is invalid

// pageIndex takes an item index and returns the page that it belongs on
    println(helper.pageIndex(5)) // should == 1 (zero based index)
    println(helper.pageIndex(2)) // should == 0
    println(helper.pageIndex(20)) // should == -1
    println(helper.pageIndex(-10)) // should == -1
}