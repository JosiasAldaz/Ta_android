package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import com.example.myapplication.R

data class Movie(val title:String,val year: Int,val poster: String,val videoUrl:String)
class MainFragment:BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = getString(R.string.browse)
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        (1..3).forEach { categoryId ->
            val categoryTitle = "Category $categoryId"

            val listRowAdapter = ArrayObjectAdapter(CardPresenter())
            listRowAdapter.addAll(0,(1..5).map {
                Movie(
                    "Title $it",
                    2023,
                    "https://loremflickr.com/176/313/dog?lock=$it",
                    "https://www.bing.com/videos/search?q=Sample+MP4+File&&view=detail&mid=972442854C3E5E37A06F972442854C3E5E37A06F&&FORM=VRDGAR&ru=%2Fvideos%2Fsearch%3F%26q%3DSample%2BMP4%2BFile%26FORM%3DVDMHRS?lock=$it"
                )

            })

            val header = HeaderItem(categoryId.toLong(), categoryTitle)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }
        adapter = rowsAdapter
    }
}

