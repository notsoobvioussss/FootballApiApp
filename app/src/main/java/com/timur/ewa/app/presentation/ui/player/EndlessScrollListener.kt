package com.timur.ewa.app.presentation.ui.player

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndlessRecyclerViewScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadMore: () -> Unit
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (layoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.itemCount - 1) {
            loadMore()
        }
    }
}
