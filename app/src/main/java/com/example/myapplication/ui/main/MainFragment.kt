package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import com.example.myapplication.R
import androidx.leanback.widget.*
import android.content.Intent
import android.net.Uri


data class Movie(val title:String,val year: Int,val poster: String,val urlyoutube: String)
class MainFragment : BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = getString(R.string.browse)
        val categoryNames = arrayOf("Terror", "Tecnología", "Música")

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        (categoryNames.indices).forEach { categoryId ->
            val categoryTitle = categoryNames[categoryId]

            val listRowAdapter = ArrayObjectAdapter(CardPresenter())
            listRowAdapter.addAll(0, (1..5).map {
                Movie(
                    "Guardians of the Galaxy $it",
                    2023,
                    "https://th.bing.com/th/id/OIP.f7MWeWUGzZWdtS6EUANJKgHaHa?rs=1&pid=ImgDetMain/",
                    "Wr5moiWHj9o"
                )
            })

            val header = HeaderItem(categoryId.toLong(), categoryTitle)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }
        adapter = rowsAdapter

        onItemViewClickedListener = OnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
            if (item is Movie) {
                val videoUrl = "https://www.youtube.com/watch?v=${item.urlyoutube}"
                val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                startActivity(youtubeIntent)
            }
        }
    }
}

